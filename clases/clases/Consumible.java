package clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Consumible extends Producto {
    private String fechaCaducidad;

    public Consumible(String id, String nombre, double precio, String fechaCaducidad) {
        super(id, nombre, precio);
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public double calcularPrecio(double utilidad) {
        double precio = super.calcularPrecio(utilidad);
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaCad = LocalDate.parse(fechaCaducidad, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        long mesesDiferencia = ChronoUnit.MONTHS.between(fechaActual, fechaCad);

        if (mesesDiferencia < 2) {
            precio -= precio * 0.10; // Aplicar 10% de descuento
        }

        return precio;
    }

    public void consumir() {
        System.out.println("Consumido " + nombre + ". Fecha de caducidad: " + fechaCaducidad);
    }
}