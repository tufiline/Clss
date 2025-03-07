package clases;

public class Almacenable extends Producto {
    private String ubicacion;
    private int cantidad;

    public Almacenable(String id, String nombre, double precio, String ubicacion, int cantidad) {
        super(id, nombre, precio);
        this.ubicacion = ubicacion;
        this.cantidad = cantidad;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Ubicación: " + ubicacion + ", Cantidad: " + cantidad;
    }

    public void almacenar() {
        // Lógica para almacenar el producto
    }
}