package modelo;

public class Producto {

    private int id_producto;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private double precio_venta;
    private double precio_compra;
    private int numero;

    public Producto() {
        this.id_producto =0;
        this.nombre = "";
        this.descripcion = "";
        this.cantidad = 0;
        this.precio_venta = 0;
        this.precio_compra = 0;
        this.numero = 0;
    }

    public Producto(int id_producto, String nombre, String descripcion, int cantidad, double precio_venta, double precio_compra, int numero) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio_venta = precio_venta;
        this.precio_compra = precio_compra;
        this.numero = numero;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

   
}
    