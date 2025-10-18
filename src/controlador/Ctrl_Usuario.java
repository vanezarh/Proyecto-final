package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class Ctrl_Usuario {

    public boolean loginUser(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_usuario where usuario= ? and password= ? ";
        PreparedStatement ps;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, objeto.getUsuario());
            ps.setString(2, objeto.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesion");
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
        }
        return respuesta;
    }
}
