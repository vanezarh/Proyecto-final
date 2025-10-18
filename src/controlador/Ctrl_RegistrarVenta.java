package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import modelo.CabeceraVenta;
import modelo.Detalleventa;

public class Ctrl_RegistrarVenta {

    //ultimo id de cabecera 
    public static int idCabeceraRegistrada;
    java.math.BigDecimal iDColVar;

    //metodo para guardar Cabecera de venta
    public boolean guardar(CabeceraVenta objeto) {

        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_cabecera_venta values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, 0);//id
            consulta.setInt(2, objeto.getIdCliente());
            consulta.setDouble(3, objeto.getValorPagar());
            consulta.setString(4, objeto.getFechaVenta());
            consulta.setInt(5, objeto.getEstado());
            consulta.setString(6, objeto.getNombre());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
                ResultSet rs = consulta.getGeneratedKeys();
                if (rs.next()) {
                    int numeroFactura = rs.getInt(1);  // ESTE ES EL ID DE LA CABECERA
                    idCabeceraRegistrada = numeroFactura; // si quieres usarlo para los detalles
                    System.out.println("Número de factura: " + numeroFactura);
                }
            }
            ResultSet rs = consulta.getGeneratedKeys();
            while (rs.next()) {
                iDColVar = rs.getBigDecimal(1);
                idCabeceraRegistrada = iDColVar.intValue();

            }
            cn.close(); 

        } catch (SQLException e) {
            System.out.println("Error al guardar cabecera: " + e);
        }
        return respuesta;
    }
    //metodo para guardar detalle de venta 

    public boolean guardarDetalle(Detalleventa objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO tb_detalle_venta VALUES(?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//ID
            consulta.setInt(2, idCabeceraRegistrada);
            consulta.setInt(3, objeto.getIdProducto());
            consulta.setInt(4, objeto.getCantidad());
            consulta.setDouble(5, objeto.getPrecioUnitario());
            consulta.setDouble(6, objeto.getSubtotal());
            consulta.setDouble(7, objeto.getTotalPagar());
            consulta.setDouble(8, objeto.getDescuento());

            consulta.setInt(9, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar detalle de venta: " + e);
        }
        return respuesta;
    }
}
