package clases;

public class Producto {
    protected String id;
    protected String nombre;
    protected double precio;

    public Producto(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String mostrarInfo() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio;
    }

    public void aplicarDescuento(double porcentaje) {
        this.precio -= this.precio * (porcentaje / 100);
    }

    public double getPrecio() {
        return this.precio;
    }

    public double calcularPrecio(double utilidad) {
        return this.precio + utilidad;
    }
}