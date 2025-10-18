package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import vista.InterFacturacion;

public class VentaPDF {

    private String nombreCliente;
    private String cedulaCliente;

    private String fechaActual;
    private String nombreArchivoPDFVenta;

    //metodo para obtener datos cliente
    public void DatosCliente(int idCliente) {
        Connection cn = Conexion.conectar();
        String sql = "select*from tb_cabecera_venta where idCliente='" + idCliente + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                nombreCliente = rs.getString("nombre");
                cedulaCliente = rs.getString("idCliente");
            }
            cn.close();
        } catch (SQLException e) {
        }
    }

    //metodo para generar factura de venta
    public void generarFacturaPDF(int numeroFactura) {
        
        try {
            //CARGAR FECHA ACTUAL 
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //cambiar formato de fecha de / a _
            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");
                }
            }
            nombreArchivoPDFVenta = "Venta_" + nombreCliente + "_" + fechaNueva + ".pdf";
            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/img/logo.png");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE); //Agregar nueva linea
            String facturaStr = String.format("%03d", numeroFactura);
            fecha.add("Factura: " +facturaStr+ "\nFecha: " + fechaActual + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);//PARA QUITAR BORDE DE TABLA
            //Tamaño de celdas
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40F};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregar celdas 
            Encabezado.addCell(img);

            String nit = "5828669011";
            String nombre = "Librería Antoneth";
            String telefono = "72614896";
            String direccion = "Av. Principal, Satélite Norte";
            String razon = "Tu mejor opción en útiles escolares y de oficina";
            Encabezado.addCell("");//celda vacia
            Encabezado.addCell("NIT: " + nit + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nRAZÓN SOCIAL: " + razon);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            //Cuerpo 
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE); //NUEVA LINEA
            cliente.add("Datos del cliente: " + "\n\n");
            doc.add(cliente);
            //datos de cliente 
            PdfPTable tablaCliente = new PdfPTable(2);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);

            float[] ColumnaCliente = new float[]{50f, 50F};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("Cédula de identidad/ C.I.: " , negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: " , negrita));
            //quitar bordes 
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            // agregar celdas a la tabla 
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cedulaCliente);
            tablaCliente.addCell(nombreCliente);
            //agregar al documento
            doc.add(tablaCliente);
            // espacio blanco de separacion
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);
            //Agregar productos 
            PdfPTable tablaProducto = new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            // Tamaño de celdas
            float[] ColumnaProducto = new float[]{15f, 50f, 15f, 20F};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad: " ,negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Descripción: " , negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio Unitario: " , negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Precio Total: " , negrita));
            //quitar bordes 
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            // AGREGAR COLOR AL ENCABEZADO DE PRODUCTO 
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            //agregar a la celda
            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);
            for (int i = 0; i < InterFacturacion.jTable_productos.getRowCount(); i++) {
                String producto = InterFacturacion.jTable_productos.getValueAt(i, 2).toString();
                String cantidad = InterFacturacion.jTable_productos.getValueAt(i, 1).toString();
                String precio = InterFacturacion.jTable_productos.getValueAt(i, 3).toString();
                String total = InterFacturacion.jTable_productos.getValueAt(i, 5).toString();
                tablaProducto.addCell(producto);
                tablaProducto.addCell(cantidad);
                tablaProducto.addCell(precio);
                tablaProducto.addCell(total);
            }
            //agregar al doc
            doc.add(tablaProducto);
            //total pagar 
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Subtotal: " + InterFacturacion.txt_subtotal.getText()+" bs");
            info.add(Chunk.NEWLINE); 
            info.add("Descuento aplicado: "+InterFacturacion.txt_descuento.getText()+" bs"); 
            info.add(Chunk.NEWLINE); 
            info.add("Total a pagar: "+InterFacturacion.txt_total_pagar.getText()+" bs"); 
            info.setAlignment(Element.ALIGN_RIGHT);
            
            // Agregar al doc 
            doc.add(info);
            //firma 
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelación y Firma\n\n");
            firma.add("_______________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            //AGREGAR A DOC 
            doc.add(firma);
            //mensaje
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("¡¡Gracias por su preferencia!!");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            //AGREGAR A DOC 
            doc.add(mensaje);
            // cerrar documento
            doc.close();
            archivo.close();
            //abrir el doc al ser generado automaticamente
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "No se puede abrir el PDF. Ciérrelo si está abierto en otra aplicación." + e);
                }
            }
        } catch (DocumentException | IOException  e) {
            System.out.println("Error en los puntos: " + e);
        }
    }

}
