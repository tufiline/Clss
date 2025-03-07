package clases;

public class Main {
    public static void main(String[] args) {
        Almacenable almacenado = new Almacenable("001", "Laptop", 15000, "Bodega A", 10);
        System.out.println(almacenado.mostrarInfo());
        almacenado.almacenar();
        almacenado.aplicarDescuento(10); // Aplicar un 10% de descuento
        System.out.println("Precio con descuento: " + almacenado.getPrecio());

        Consumible consumible = new Consumible("002", "Leche", 20, "2025-12-31");
        System.out.println(consumible.mostrarInfo());
        consumible.consumir();
        consumible.aplicarDescuento(5); // Aplicar un 5% de descuento
        System.out.println("Precio con descuento: " + consumible.getPrecio());

        Servicio servicio = new Servicio("003", "Mantenimiento", 500, 3, 5);
        System.out.println(servicio.mostrarInfo());
        servicio.prestar();
        servicio.aplicarDescuento(15); // Aplicar un 15% de descuento
        System.out.println("Precio con descuento: " + servicio.getPrecio());
    }
}