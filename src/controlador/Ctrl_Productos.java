
package controlador;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import modelo.Producto;


public class Ctrl_Productos {
    //metodo para registrar productos
    public boolean guardar (Producto objeto){
    boolean respuesta = false; 
    Connection cn= conexion.Conexion.conectar( );
    try{
         PreparedStatement consulta = cn.prepareStatement("insert into tb_productos values(?,?,?,?,?,?,?)"); 
         consulta.setInt(1,objeto.getId_producto());
         consulta.setString(2,objeto.getNombre());
         consulta.setString(3, objeto.getDescripcion());
         consulta.setInt(4,objeto.getCantidad());
         consulta.setDouble(5, objeto.getPrecio_venta());
         consulta.setDouble(6, objeto.getPrecio_compra());
         consulta.setInt(7, 0);
         if (consulta.executeUpdate() >0){
             respuesta= true;
         }
         cn.close();
         
        }catch(SQLException e){
            System.out.println("Error al guardar productos: "+e);
        }
       return respuesta; 
    }    
//Metodo para actualizar 
public boolean actualizar (Producto objeto, int idProducto){
    boolean respuesta = false; 
    Connection cn= conexion.Conexion.conectar( );
    try{
         PreparedStatement consulta = cn.prepareStatement("update tb_productos set id_producto = ?, nombre = ?,  descripcion = ?,  cantidad = ?, precio_venta = ?, precio_compra  = ? where numero ='"+idProducto+"'"); 
         consulta.setInt(1,objeto.getId_producto());
         consulta.setString(2,objeto.getNombre());
         consulta.setString(3, objeto.getDescripcion());
         consulta.setInt(4,objeto.getCantidad());
         consulta.setDouble(5, objeto.getPrecio_venta());
         consulta.setDouble(6, objeto.getPrecio_compra());
         if (consulta.executeUpdate() >0){
             respuesta= true;
         }
         cn.close();
         
        }catch(SQLException e){
            System.out.println("Error al actualizar productos: "+e);
        }
       return respuesta; 
    }
 
//Metodo para eliminar 
public boolean eliminar (int idProducto){
    boolean respuesta = false; 
    Connection cn= conexion.Conexion.conectar( );
    try{
         PreparedStatement consulta = cn.prepareStatement("delete from tb_productos where numero ='"+idProducto+"'"); 
         consulta.executeUpdate(); 
         if (consulta.executeUpdate() >0){
             respuesta= true;
         }
         cn.close();
         
        }catch(SQLException e){
            System.out.println("Error al eliminar productos: "+e);
        }
       return respuesta; 
    }    
    }    
      
        

