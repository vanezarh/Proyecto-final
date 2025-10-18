package vista;

import conexion.Conexion;
import controlador.Ctrl_RegistrarVenta;
import controlador.VentaPDF;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.CabeceraVenta;
import modelo.Detalleventa;

public class InterFacturacion extends javax.swing.JInternalFrame {

    //MODELO DE DATOS 
    private DefaultTableModel modeloDatosProductos;
    //lista para el detalle de venta de los productos 
    ArrayList<Detalleventa> listaProductos = new ArrayList<>();
    private Detalleventa producto;

    private int idProducto = 0;
    private String nombre = "";
    private int cantidadProductoBBDD = 0;
    private double precioUnitario = 0.0;

    private int cantidad = 0; //Cantidad de productos a comprar
    private double subtotal = 0.0;//Cantidad por precio
    private double totalPagar = 0.0;
    private double descuento = 0.0;
    //variables para calculos 
    private double subtotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double totalPagarGeneral = 0.0;
    //fin de variables 

    private int auxIdDetalle = 1;//Id del detalle de venta

    public InterFacturacion() {
        initComponents();
        this.setSize(new Dimension(850, 600));
        this.setTitle("Facturación");
        this.CargarComboProductos();
        this.inicializarTablaProducto();
        txt_efectivo.setEnabled(false);
        txt_descuento.setEnabled(false);
        jButton_calcular_cambio.setEnabled(false);
        txt_subtotal.setText("0.0");
        txt_descuento.setText("");
        txt_total_pagar.setText("0.0");
    }

    // metodo para inicializar la tb-productos
    private void inicializarTablaProducto() {
        modeloDatosProductos = new DefaultTableModel();
        //anadir columnas 
        modeloDatosProductos.addColumn("id del Producto");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("P. Unitario");
        modeloDatosProductos.addColumn("Subtotal");
        modeloDatosProductos.addColumn("Total a pagar");
        modeloDatosProductos.addColumn("Acción");
        //agregar datos del modelo a tabla
        this.jTable_productos.setModel(modeloDatosProductos);
    }

    //metodo para presentar informacion de la tabla Detalle Venta
    private void listaTablaProductos() {
        this.modeloDatosProductos.setRowCount(listaProductos.size());
        for (int i = 0; i < listaProductos.size(); i++) {
            this.modeloDatosProductos.setValueAt(i + 1, i, 0);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getNombre(), i, 1);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getCantidad(), i, 2);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getPrecioUnitario(), i, 3);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getSubtotal(), i, 4);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getTotalPagar(), i, 5);
            this.modeloDatosProductos.setValueAt("Eliminar", i, 6);
        }
        jTable_productos.setModel(modeloDatosProductos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_producto_buscar = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        jComboBox_producto = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jButton_buscar_producto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_total_pagar = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        jButton_calcular_cambio = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jButton_añadir_producto = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Producto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, 20));

        txt_producto_buscar.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        txt_producto_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_producto_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(txt_producto_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 90, -1));

        txt_cedula.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        getContentPane().add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 110, -1));

        jComboBox_producto.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jComboBox_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Producto", "Item 1", "Item 2", "Item 3", " " }));
        jComboBox_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 180, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Buscar por Id:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        txt_cantidad.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        txt_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidadActionPerformed(evt);
            }
        });
        getContentPane().add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 60, -1));

        jButton_buscar_producto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton_buscar_producto.setText("Buscar");
        jButton_buscar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscar_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_buscar_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 80, 30));

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));

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
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_productos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 820, 210));

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Cambio: ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Descuento:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Total a pagar:  ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txt_total_pagar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txt_total_pagar.setEnabled(false);
        txt_total_pagar.setName(""); // NOI18N
        txt_total_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_pagarActionPerformed(evt);
            }
        });
        jPanel2.add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 120, 30));

        txt_efectivo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txt_efectivo.setName(""); // NOI18N
        txt_efectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_efectivoActionPerformed(evt);
            }
        });
        jPanel2.add(txt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 80, 30));

        txt_cambio.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txt_cambio.setEnabled(false);
        txt_cambio.setName(""); // NOI18N
        txt_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cambioActionPerformed(evt);
            }
        });
        jPanel2.add(txt_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 80, 30));

        txt_descuento.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txt_descuento.setName(""); // NOI18N
        txt_descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descuentoActionPerformed(evt);
            }
        });
        jPanel2.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 120, 30));

        jButton_calcular_cambio.setBackground(new java.awt.Color(0, 245, 212));
        jButton_calcular_cambio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton_calcular_cambio.setText("Calcular cambio");
        jButton_calcular_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcular_cambioActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_calcular_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 130, 30));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Subtotal:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txt_subtotal.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txt_subtotal.setEnabled(false);
        txt_subtotal.setName(""); // NOI18N
        txt_subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_subtotalActionPerformed(evt);
            }
        });
        jPanel2.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 120, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 330, 210));

        jButton2.setBackground(new java.awt.Color(0, 245, 212));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/factura (1).png"))); // NOI18N
        jButton2.setText("Registrar Venta");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 120, 100));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("FACTURACIÓN");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 150, -1));

        jButton_añadir_producto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton_añadir_producto.setText("Añadir");
        jButton_añadir_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_añadir_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_añadir_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 70, 30));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("C.I.");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_productoActionPerformed

    private void txt_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidadActionPerformed

    private void txt_total_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_pagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_pagarActionPerformed

    private void txt_efectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_efectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_efectivoActionPerformed

    private void txt_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cambioActionPerformed

    private void txt_descuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descuentoActionPerformed

    private void jButton_calcular_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcular_cambioActionPerformed
        if (!txt_efectivo.getText().isEmpty()) {
            //validar que el usuario no ingrese otro caracteres no numericos 
            boolean validacion = validarDouble(txt_efectivo.getText());
            if (validacion == true) {
                //validar el efecticvo sea mayor a cero
                double efc = Double.parseDouble(txt_efectivo.getText().trim());
                double top = Double.parseDouble(txt_subtotal.getText().trim());
                double dc = Double.parseDouble(txt_descuento.getText().trim());

                if (efc < top) {
                    JOptionPane.showMessageDialog(null, "Error, el dinero en efectivo no es suficiente");
                } else {
                    double cambio = (top - dc);
                    double tcambio = efc - cambio;
                    double cambi = (double) Math.round(tcambio * 100d) / 100;               
                    String camb = String.valueOf(cambi);
                    String Tp = String.valueOf(cambio);
                    txt_cambio.setText(camb);
                    txt_total_pagar.setText(Tp);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se admiten caracteres no numéricos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dinero en efectivo para calcular cambio");
        }
    }//GEN-LAST:event_jButton_calcular_cambioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        Detalleventa detalleventa = new Detalleventa();
        Ctrl_RegistrarVenta controlVenta = new Ctrl_RegistrarVenta();

        String fechaActual = "";
        Date date = new Date();
        fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
        if (listaProductos.size() > 0) {
            //registrar cabecera de venta 
            if (txt_cedula.getText().isEmpty() || txt_nombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese los datos del cliente");
            }
            int idCliente = Integer.parseInt(txt_cedula.getText().trim());
            cabeceraVenta.setIdCliente(idCliente);
            cabeceraVenta.setNombre(txt_nombre.getText().trim());
            cabeceraVenta.setIdCabeceraventa(0);
            cabeceraVenta.setValorPagar(Double.parseDouble(txt_total_pagar.getText().trim()));
            cabeceraVenta.setFechaVenta(fechaActual);
            cabeceraVenta.setEstado(1);

            if (controlVenta.guardar(cabeceraVenta)) {

                JOptionPane.showMessageDialog(null, "Venta registrada");
                //Generar factura venta
                VentaPDF pdf = new VentaPDF();
                pdf.DatosCliente(idCliente);
                pdf.generarFacturaPDF(Ctrl_RegistrarVenta.idCabeceraRegistrada);

                //GUARDAR DETALLE 
                for (Detalleventa elemento : listaProductos) {
                    detalleventa.setIdDetalleVenta(0);
                    detalleventa.setIdCabeceraVenta(0);
                    detalleventa.setIdProducto(elemento.getIdProducto());
                    detalleventa.setCantidad(elemento.getCantidad());
                    detalleventa.setPrecioUnitario(elemento.getPrecioUnitario());
                    detalleventa.setSubtotal(elemento.getSubtotal());
                    detalleventa.setTotalPagar(elemento.getTotalPagar());
                    detalleventa.setDescuento(elemento.getDescuento());
                    detalleventa.setEstado(1);

                    if (controlVenta.guardarDetalle(detalleventa)) {
                        txt_subtotal.setText("0.0");
                        txt_descuento.setText("");
                        txt_total_pagar.setText("0.0");
                        txt_cambio.setText("0.0");
                        txt_efectivo.setText(" ");
                        txt_nombre.setText("");
                        txt_cedula.setText("");
                        auxIdDetalle = 1;
                        this.CargarComboProductos();
                        this.RestarStockProductos(elemento.getIdProducto(), elemento.getCantidad());
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar detalle de venta");
                    }
                }

                listaProductos.clear();
                listaTablaProductos();

            } else {

                JOptionPane.showMessageDialog(null, "Error al guardar cabecera de venta");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error, seleccione un producto");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_producto_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_producto_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_producto_buscarActionPerformed

    private void jButton_buscar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar_productoActionPerformed
        String Productobuscar = txt_producto_buscar.getText().trim();
        Connection cn = Conexion.conectar();
        String sql = "select nombre from tb_productos where id_producto= '" + Productobuscar + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                jComboBox_producto.setSelectedItem(rs.getString("nombre"));
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado, verificar dato...");
            }
            txt_producto_buscar.setText("");
            cn.close();
        } catch (Exception e) {
            System.out.println("Error al buscar producto: " + e);
        }

    }//GEN-LAST:event_jButton_buscar_productoActionPerformed

    private void jButton_añadir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_añadir_productoActionPerformed
        String combo = this.jComboBox_producto.getSelectedItem().toString();
        //Validar que seleccione un producto 
        if (combo.equalsIgnoreCase("Seleccione producto: ")) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else {
            //Validar que ingrese cantidad
            if (!txt_cantidad.getText().isEmpty()) {
                //Validar que ingrese caracteres numericos 
                boolean validacion = validar(txt_cantidad.getText());
                if (validacion == true) {
                    //Validar cantidad mayor a 0 
                    if (Integer.parseInt(txt_cantidad.getText()) > 0) {
                        cantidad = Integer.parseInt(txt_cantidad.getText());
                        //ejecutar  metodo para datos del producto
                        this.DatosDelProducto();
                        //Calcular que la cantidad de productos no rebase al stock seleccionado
                        if (cantidad <= cantidadProductoBBDD) {
                            subtotal = cantidad * precioUnitario;
                            totalPagar = subtotal - descuento;
                            // REDONDEAR DECIMALES 
                            subtotal = (double) Math.round(subtotal * 100) / 100;
                            //Se crea nuevo producto  
                            producto = new Detalleventa(auxIdDetalle, 1, idProducto, nombre, Integer.parseInt(txt_cantidad.getText()), precioUnitario, subtotal, totalPagar, descuento, 1);
                            //añadir a la lista 
                            listaProductos.add(producto);
                            JOptionPane.showMessageDialog(null, "Producto agregado");
                            auxIdDetalle++;
                            txt_cantidad.setText("");//limpia campo
                            this.CargarComboProductos();
                            this.CalcularTotalPagar();
                            txt_efectivo.setEnabled(true);
                            txt_descuento.setEnabled(true);
                            jButton_calcular_cambio.setEnabled(true);

                        } else {
                            JOptionPane.showMessageDialog(null, "Error, la cantidad supera al stock, verifica nuevamente...");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero(o), ni negativa");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese datos numéricos.");
                }
            } else {

                JOptionPane.showMessageDialog(null, "Ingrese la cantidad de  producto");
            }

        }
        this.listaTablaProductos();
    }//GEN-LAST:event_jButton_añadir_productoActionPerformed

    private void txt_subtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_subtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_subtotalActionPerformed
    int idArrayList = 0;
    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked
        int fila_point = jTable_productos.rowAtPoint(evt.getPoint());
        int columna_point = 0;
        if (fila_point > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(fila_point, columna_point);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar producto?");
        //opciones de confir dialog-(si=0,no=1,cancel=2,close=-1
        switch (opcion) {
            case 0: //presione si 
                listaProductos.remove(idArrayList - 1);
                this.CalcularTotalPagar();
                this.listaTablaProductos();
                break;
            case 1: //presione no
                break;
            default:// Si presiona cancel (2) o close (-1)
                break;
        }

    }//GEN-LAST:event_jTable_productosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_añadir_producto;
    private javax.swing.JButton jButton_buscar_producto;
    private javax.swing.JButton jButton_calcular_cambio;
    private javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cedula;
    public static javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_producto_buscar;
    public static javax.swing.JTextField txt_subtotal;
    public static javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables
//Metodo para cargar productos en el jcombobox
    private void CargarComboProductos() {
        Connection cn = Conexion.conectar();
        String sql = "select* from tb_productos";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_producto.removeAllItems();
            jComboBox_producto.addItem("Seleccione producto: ");
            while (rs.next()) {
                jComboBox_producto.addItem(rs.getString("nombre"));

            }

        } catch (Exception e) {
            System.out.println("Error al cargar productos: " + e);
        }
    }

    //Metodo para validar que ingrese caracteres numericos 
    private boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //Metodo para mostrar datos del producto seleccionado

    private void DatosDelProducto() {
        try {
            String sql = "select * from tb_productos where nombre='" + jComboBox_producto.getSelectedItem() + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idProducto = rs.getInt("id_producto");
                nombre = rs.getString("nombre");
                cantidadProductoBBDD = rs.getInt("cantidad");
                precioUnitario = rs.getDouble("precio_venta");

            }

        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto: " + e);
        }

    }

    //Metodo para calcular el total a pagar de todos los productos seleccionados 
    private void CalcularTotalPagar() {
        subtotalGeneral = 0;
        descuentoGeneral = 0;
        totalPagarGeneral = 0;
        for (Detalleventa elemento : listaProductos) {
            subtotalGeneral += elemento.getSubtotal();
            descuentoGeneral += elemento.getDescuento();
            totalPagarGeneral += elemento.getTotalPagar();

        }
        //redondear decimales 
        subtotalGeneral = (double) Math.round(subtotalGeneral * 100) / 100;
        descuentoGeneral = (double) Math.round(descuentoGeneral * 100) / 100;
        totalPagarGeneral = (double) Math.round(totalPagarGeneral * 100) / 100;
        // enviar datos a la vista 
        txt_subtotal.setText(String.valueOf(subtotalGeneral));
        txt_descuento.setText(String.valueOf(descuentoGeneral));
        txt_total_pagar.setText(String.valueOf(totalPagarGeneral));

    }

    //Metodo para validar que ingrese caracteres numericos 
    private boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void RestarStockProductos(int idProducto, int cantidad) {
        int cantidadProductosBd = 0;
        String nombreProducto= ""; 
        try {
            Connection cn = Conexion.conectar();
            String sql = "select nombre, cantidad from tb_productos where id_producto= '" + idProducto + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cantidadProductosBd = rs.getInt("cantidad");
                nombreProducto = rs.getString("nombre");
            }
        } catch (SQLException e) {
            System.out.println("error al restar cantidad 1: " + e);
        }
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement consulta = cn.prepareStatement("update tb_productos set cantidad=? where id_producto= '" + idProducto + "'");
            int cantidadNueva = cantidadProductosBd - cantidad;
            consulta.setInt(1, cantidadNueva);
            if (consulta.executeUpdate() > 0) {
                System.out.println("Todo bien :)");
            }
             if (cantidadNueva == 0) {
                JOptionPane.showMessageDialog(null, "⚠ El producto '" + nombreProducto + "' se ha agotado (stock 0).");
             }
            cn.close();
        } catch (SQLException e) {
            System.out.println("error al restar cantidad 2: " + e);
        }
    }
}
