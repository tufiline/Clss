package clases;

public class Servicio extends Producto {
    private int duracion;
    private int historial;

    public Servicio(String id, String nombre, double precio, int duracion, int historial) {
        super(id, nombre, precio);
        this.duracion = duracion;
        this.historial = historial;
    }

    public void prestar() {
        System.out.println("Servicio " + nombre + " prestado por " + duracion + " horas. Historial de uso: " + historial);
    }
}