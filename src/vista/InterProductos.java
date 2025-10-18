package vista;

import conexion.Conexion;
import controlador.Ctrl_Productos;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import modelo.Producto;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JTable;
import java.awt.Dimension;
import java.sql.PreparedStatement;

public class InterProductos extends javax.swing.JInternalFrame {

    private int idProductos;

    public InterProductos() {
        initComponents();
        this.setSize(new Dimension(800, 500));
        this.setTitle("INVENTARIO DE PRODUCTOS");
        this.CargarTablaProductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        txt_precioVenta = new javax.swing.JTextField();
        txt_precioCompra = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Administrar Productos ");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(290, 10, 440, 20);

        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel6.setText("Id: ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 360, 40, 20);

        jLabel7.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel7.setText("Cantidad: ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 400, 90, 20);

        jLabel8.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel8.setText("Nombre: ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(270, 360, 90, 20);

        jLabel9.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel9.setText("Descripción: ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(250, 400, 90, 20);

        jLabel10.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel10.setText("Precio de Venta:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(500, 360, 120, 20);

        jLabel11.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel11.setText("Precio de Compra: ");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(490, 400, 140, 20);

        txt_id.setBackground(new java.awt.Color(241, 250, 238));
        getContentPane().add(txt_id);
        txt_id.setBounds(130, 360, 64, 22);

        txt_cantidad.setBackground(new java.awt.Color(241, 250, 238));
        getContentPane().add(txt_cantidad);
        txt_cantidad.setBounds(130, 400, 64, 22);

        txt_nombre.setBackground(new java.awt.Color(241, 250, 238));
        getContentPane().add(txt_nombre);
        txt_nombre.setBounds(340, 360, 120, 22);

        txt_descripcion.setBackground(new java.awt.Color(241, 250, 238));
        getContentPane().add(txt_descripcion);
        txt_descripcion.setBounds(340, 400, 120, 22);

        txt_precioVenta.setBackground(new java.awt.Color(241, 250, 238));
        getContentPane().add(txt_precioVenta);
        txt_precioVenta.setBounds(630, 360, 64, 22);

        txt_precioCompra.setBackground(new java.awt.Color(241, 250, 238));
        getContentPane().add(txt_precioCompra);
        txt_precioCompra.setBounds(630, 400, 64, 22);

        jButton2.setBackground(new java.awt.Color(168, 218, 220));
        jButton2.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_circle.png"))); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(650, 60, 120, 31);

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_productos.setEnabled(false);
        jScrollPane2.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 37, 590, 240));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 40, 620, 290);

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(168, 218, 220));
        jButton_actualizar.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jButton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Loader.png"))); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.setPreferredSize(new java.awt.Dimension(100, 31));
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, -1));

        jButton_eliminar.setBackground(new java.awt.Color(168, 218, 220));
        jButton_eliminar.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        jButton_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.setPreferredSize(new java.awt.Dimension(100, 31));
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 120, -1));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(640, 40, 140, 290);

        jPanel3.setBackground(new java.awt.Color(217, 217, 217));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 340, 770, 110);

        jLabel_wallpaper.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))); // NOI18N
        getContentPane().add(jLabel_wallpaper);
        jLabel_wallpaper.setBounds(-20, 0, 1250, 1160);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Producto producto = new Producto();
        Ctrl_Productos controlProductos = new Ctrl_Productos();

        if (txt_id.getText().isEmpty() || txt_cantidad.getText().isEmpty() || txt_nombre.getText().isEmpty() || txt_descripcion.getText().isEmpty() || txt_precioVenta.getText().isEmpty() || txt_precioCompra.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            txt_id.setBackground(Color.red);
            txt_cantidad.setBackground(Color.red);
            txt_nombre.setBackground(Color.red);
            txt_descripcion.setBackground(Color.red);
            txt_precioVenta.setBackground(Color.red);
            txt_precioCompra.setBackground(Color.red);
        } else {
            try {
                producto.setId_producto(Integer.parseInt(txt_id.getText().trim()));
                producto.setCantidad(Integer.parseInt(txt_cantidad.getText().trim()));
                producto.setNombre(txt_nombre.getText().trim());
                producto.setDescripcion(txt_descripcion.getText().trim());
//
                String PVentaTXT = txt_precioVenta.getText().trim();
                String PCompraTXT = txt_precioCompra.getText().trim();
                double Pventa;
                double Pcompra;

                // Reemplazar coma por punto en caso necesario
                PVentaTXT = PVentaTXT.replace(",", ".");
                PCompraTXT = PCompraTXT.replace(",", ".");

                Pventa = Double.parseDouble(PVentaTXT);
                Pcompra = Double.parseDouble(PCompraTXT);

                producto.setPrecio_venta(Pventa);
                producto.setPrecio_compra(Pcompra);
                if (Pcompra > Pventa) {
                    JOptionPane.showMessageDialog(null, "Error, el precio de compra es mayor al de venta, verifica nuevamente...");

                } else {
                    if (producto.getCantidad() <= 0) {
                        JOptionPane.showMessageDialog(null, "No se puede registrar un producto con stock 0. Verifica la cantidad.");
                    } else {

                        if (controlProductos.guardar(producto)) {
                            JOptionPane.showMessageDialog(null, "Producto agregado exitosamente");
                            txt_id.setBackground(Color.green);
                            txt_cantidad.setBackground(Color.green);
                            txt_nombre.setBackground(Color.green);
                            txt_descripcion.setBackground(Color.green);
                            txt_precioVenta.setBackground(Color.green);
                            txt_precioCompra.setBackground(Color.green);
                            this.CargarTablaProductos();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al guardar producto");
                        }
                    }
                }

            } catch (HeadlessException | NumberFormatException e) {
                System.out.println("Error en: " + e);

            }
            this.Limpiar();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        Producto producto = new Producto();
        Ctrl_Productos controlProductos = new Ctrl_Productos();

        if (txt_id.getText().isEmpty() || txt_cantidad.getText().isEmpty() || txt_nombre.getText().isEmpty() || txt_descripcion.getText().isEmpty() || txt_precioVenta.getText().isEmpty() || txt_precioCompra.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
            try {
                producto.setId_producto(Integer.parseInt(txt_id.getText().trim()));
                producto.setCantidad(Integer.parseInt(txt_cantidad.getText().trim()));
                producto.setNombre(txt_nombre.getText().trim());
                producto.setDescripcion(txt_descripcion.getText().trim());
//Si el usuario ingresa coma    
                String PVentaTXT = txt_precioVenta.getText().trim();
                String PCompraTXT = txt_precioCompra.getText().trim();
                double Pventa;
                double Pcompra;

                // Reemplazar coma por punto en caso necesario
                PVentaTXT = PVentaTXT.replace(",", ".");
                PCompraTXT = PCompraTXT.replace(",", ".");

                Pventa = Double.parseDouble(PVentaTXT);
                Pcompra = Double.parseDouble(PCompraTXT);

                producto.setPrecio_venta(Pventa);
                producto.setPrecio_compra(Pcompra);

                if (controlProductos.actualizar(producto, idProductos)) {
                    JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente");
                    this.CargarTablaProductos();
                    this.Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar producto");
                }

            } catch (HeadlessException | NumberFormatException e) {
                System.out.println("Error en: " + e);

            }
        }

    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        Ctrl_Productos controlProductos = new Ctrl_Productos();
        if (idProductos == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un producto!");
        } else {
            if (!controlProductos.eliminar(idProductos)) {
                JOptionPane.showMessageDialog(null, "Producto eliminado");
                this.CargarTablaProductos();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar producto");
            }

        }

    }//GEN-LAST:event_jButton_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precioCompra;
    private javax.swing.JTextField txt_precioVenta;
    // End of variables declaration//GEN-END:variables
//Metodo para limpiar//
    public void Limpiar() {
        txt_id.setText("");
        txt_cantidad.setText("");
        txt_nombre.setText("");
        txt_descripcion.setText("");
        txt_precioVenta.setText("");
        txt_precioCompra.setText("");
    }
//Metodo para mostrar todas los productos registrados//

    private void CargarTablaProductos() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select id_producto, nombre, descripcion, cantidad, precio_venta, precio_compra, numero from tb_productos";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterProductos.jTable_productos = new JTable(model);
            InterProductos.jScrollPane2.setViewportView(InterProductos.jTable_productos);

            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Descripción");
            model.addColumn("Cantidad");
            model.addColumn("Precio Venta");
            model.addColumn("Precio Compra");
            model.addColumn("#");
            while (rs.next()) {
                Object fila[] = new Object[7];

                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            InterProductos.jTable_productos.setDefaultEditor(Object.class, null);
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla productos: " + e);
        }
        jTable_productos.addMouseListener(new MouseAdapter() {
            //Poder seleccionar los datos
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_productos.rowAtPoint(e.getPoint());
                int column_point = 6;
                if (fila_point > -1) {
                    idProductos = (int) model.getValueAt(fila_point, column_point);
                    EnviarDatoProductosSeleccionada(idProductos);
                }
            }

        });
    }

    private void EnviarDatoProductosSeleccionada(int idProductos) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("select * from tb_productos where numero= '" + idProductos + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txt_id.setText(rs.getString("id_producto"));
                txt_cantidad.setText(rs.getString("cantidad"));
                txt_nombre.setText(rs.getString("nombre"));
                txt_descripcion.setText(rs.getString("descripcion"));
                txt_precioVenta.setText(rs.getString("precio_venta"));
                txt_precioCompra.setText(rs.getString("precio_compra"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error al seleccionar producto: " + e);
        }
    }

}
