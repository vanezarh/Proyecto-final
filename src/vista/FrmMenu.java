package vista;

import controlador.Reportes;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;

public class FrmMenu extends javax.swing.JFrame {

    public static JDesktopPane jDesktopPane_menu;

    public FrmMenu() {
        initComponents();
        this.setSize(new Dimension(1200, 700));
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Menú - SISTEMA DE GESTION DE PRODUCTOS");

        this.setLayout(null);
        jDesktopPane_menu = new JDesktopPane();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.jDesktopPane_menu.setBounds(0, 0, ancho, (alto - 110));
        this.add(jDesktopPane_menu);

    }
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/productos.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        AdministrarProducto = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        GestionarVentas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        ReporteProductos = new javax.swing.JMenuItem();
        ReporteVentas = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        VerHistorial = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        CerrarSesion = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(203, 238, 243));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(203, 238, 243));
        setIconImage(getIconImage());
        getContentPane().setLayout(null);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Usuario2.png"))); // NOI18N
        jMenu1.setText("Usuario");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(200, 50));
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/productos.png"))); // NOI18N
        jMenu2.setText("Productos");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(200, 50));

        AdministrarProducto.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        AdministrarProducto.setText("Administrar Productos");
        AdministrarProducto.setFocusCycleRoot(true);
        AdministrarProducto.setPreferredSize(new java.awt.Dimension(200, 30));
        AdministrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdministrarProductoActionPerformed(evt);
            }
        });
        jMenu2.add(AdministrarProducto);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/facturar.png"))); // NOI18N
        jMenu3.setText("Facturar");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(200, 50));

        GestionarVentas.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        GestionarVentas.setText("Gestionar Ventas");
        GestionarVentas.setPreferredSize(new java.awt.Dimension(200, 30));
        GestionarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionarVentasActionPerformed(evt);
            }
        });
        jMenu3.add(GestionarVentas);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reportes.png"))); // NOI18N
        jMenu4.setText("Reportes");
        jMenu4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(200, 50));

        ReporteProductos.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ReporteProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reportes1.png"))); // NOI18N
        ReporteProductos.setText("Reportes Productos");
        ReporteProductos.setPreferredSize(new java.awt.Dimension(200, 30));
        ReporteProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteProductosActionPerformed(evt);
            }
        });
        jMenu4.add(ReporteProductos);

        ReporteVentas.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ReporteVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reportes1.png"))); // NOI18N
        ReporteVentas.setText("Reportes Ventas");
        ReporteVentas.setPreferredSize(new java.awt.Dimension(200, 30));
        ReporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteVentasActionPerformed(evt);
            }
        });
        jMenu4.add(ReporteVentas);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Historial.png"))); // NOI18N
        jMenu5.setText("Historial");
        jMenu5.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jMenu5.setPreferredSize(new java.awt.Dimension(200, 50));

        VerHistorial.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        VerHistorial.setText("Ver Historial ");
        VerHistorial.setPreferredSize(new java.awt.Dimension(200, 30));
        VerHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerHistorialActionPerformed(evt);
            }
        });
        jMenu5.add(VerHistorial);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar_sesion.png"))); // NOI18N
        jMenu6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        CerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        CerrarSesion.setText("Cerrar Sesión");
        CerrarSesion.setPreferredSize(new java.awt.Dimension(200, 30));
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });
        jMenu6.add(CerrarSesion);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdministrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdministrarProductoActionPerformed
        InterProductos interProductos = new InterProductos();
        jDesktopPane_menu.add(interProductos);
        interProductos.setVisible(true);
    }//GEN-LAST:event_AdministrarProductoActionPerformed

    private void GestionarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionarVentasActionPerformed
        InterFacturacion interFacturacion = new InterFacturacion();
        jDesktopPane_menu.add(interFacturacion);
        interFacturacion.setVisible(true);
    }//GEN-LAST:event_GestionarVentasActionPerformed

    private void ReporteProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteProductosActionPerformed
        Reportes reporte = new Reportes();
        reporte.ReportesProductos();
    }//GEN-LAST:event_ReporteProductosActionPerformed

    private void ReporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteVentasActionPerformed
        Reportes reporte = new Reportes();
        reporte.ReportesVentas();
    }//GEN-LAST:event_ReporteVentasActionPerformed

    private void VerHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerHistorialActionPerformed
        InterGraficas interGraficas = new InterGraficas();
        jDesktopPane_menu.add(interGraficas);
        interGraficas.setVisible(true);
    }//GEN-LAST:event_VerHistorialActionPerformed

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CerrarSesionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AdministrarProducto;
    private javax.swing.JMenuItem CerrarSesion;
    private javax.swing.JMenuItem GestionarVentas;
    private javax.swing.JMenuItem ReporteProductos;
    private javax.swing.JMenuItem ReporteVentas;
    private javax.swing.JMenuItem VerHistorial;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}
