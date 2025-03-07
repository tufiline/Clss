import java.util.HashMap;
import java.util.Scanner;

public class actividad3 {

    static class Producto {
        private String codigo, tipo;
        private double costo, impuesto;

        public Producto(String codigo, String tipo, double costo, double impuesto) {
            this.codigo = codigo;
            this.tipo = tipo;
            this.costo = costo;
            this.impuesto = impuesto;
        }

        public String getCodigo() { return codigo; }
        public void muestraProducto() {
            System.out.println("Código: " + codigo + ", Tipo: " + tipo + ", Costo: " + costo + ", Impuesto: " + impuesto);
        }

        public double calcularPrecio(double utilidad) {
            return (costo + costo * (utilidad / 100)) * (1 + impuesto / 100);
        }
    }

    static class Inventario {
        private HashMap<String, Integer> productos = new HashMap<>();

        public void muestrarInventario() {
            productos.forEach((codigo, cantidad) -> System.out.println("Producto: " + codigo + ", Cantidad: " + cantidad));
        }

        public void abastecerInventario(String codigo, int cantidad) {
            productos.put(codigo, productos.getOrDefault(codigo, 0) + cantidad);
        }
    }

    public static String compararProductos(Producto p1, Producto p2, double utilidad) {
        double precioP1 = p1.calcularPrecio(utilidad);
        double precioP2 = p2.calcularPrecio(utilidad);
        return precioP1 > precioP2 ? "Mayor precio: " + p1.getCodigo() : precioP2 > precioP1 ? "Mayor precio: " + p2.getCodigo() : "Precios iguales";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        HashMap<String, Producto> productos = new HashMap<>();

        while (true) {
            System.out.println("1. Agregar producto\n2. Abastecer inventario\n3. Mostrar producto\n4. Mostrar inventario\n5. Comparar productos\n6. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.println("Código:");
                String codigo = scanner.nextLine();
                System.out.println("Tipo:");
                String tipo = scanner.nextLine();
                System.out.println("Costo:");
                double costo = scanner.nextDouble();
                System.out.println("Impuesto:");
                double impuesto = scanner.nextDouble();
                scanner.nextLine();

                Producto producto = new Producto(codigo, tipo, costo, impuesto);
                productos.put(codigo, producto);
                inventario.abastecerInventario(codigo, 0);
                System.out.println("Producto agregado.");

            } else if (opcion == 2) {
                System.out.println("Código:");
                String codigo = scanner.nextLine();
                if (!productos.containsKey(codigo)) {
                    System.out.println("Producto no encontrado.");
                    continue;
                }
                System.out.println("Cantidad:");
                int cantidad = scanner.nextInt();
                scanner.nextLine();

                inventario.abastecerInventario(codigo, cantidad);
                System.out.println("Inventario actualizado.");

            } else if (opcion == 3) {
                System.out.println("Código:");
                String codigo = scanner.nextLine();
                Producto producto = productos.get(codigo);
                if (producto == null) {
                    System.out.println("Producto no encontrado.");
                    continue;
                }
                producto.muestraProducto();

            } else if (opcion == 4) {
                inventario.muestrarInventario();

            } else if (opcion == 5) {
                System.out.println("Código del primer producto:");
                String codigo1 = scanner.nextLine();
                Producto producto1 = productos.get(codigo1);
                if (producto1 == null) {
                    System.out.println("Producto no encontrado.");
                    continue;
                }
                System.out.println("Código del segundo producto:");
                String codigo2 = scanner.nextLine();
                Producto producto2 = productos.get(codigo2);
                if (producto2 == null) {
                    System.out.println("Producto no encontrado.");
                    continue;
                }
                System.out.println("Utilidad:");
                double utilidad = scanner.nextDouble();
                scanner.nextLine();

                System.out.println(compararProductos(producto1, producto2, utilidad));

            } else if (opcion == 6) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}