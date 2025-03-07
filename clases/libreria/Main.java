package libreria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Crear usuarios
        Usuario usuario1 = new Usuario("Juan Perez", "U001");
        Usuario usuario2 = new Usuario("Maria Lopez", "U002");

        // Crear administrador
        Administrador admin = new Administrador("Carlos Gomez", "A001", "Alto");

        // Crear libros
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", "ISBN001", 5);
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel Garcia Marquez", "ISBN002", 1);

        // Agregar usuarios, administrador y libros a la biblioteca
        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);
        biblioteca.agregarUsuario(admin);
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        // Mostrar usuarios y libros
        System.out.println("Usuarios en la biblioteca:");
        biblioteca.mostrarUsuarios();

        System.out.println("\nLibros en la biblioteca:");
        biblioteca.mostrarLibros();

        // Interacción con el administrador desde la terminal
        while (true) {
            System.out.println("\nOpciones de administrador:");
            System.out.println("1. Editar usuario");
            System.out.println("2. Editar libro");
            System.out.println("3. Mostrar usuarios");
            System.out.println("4. Mostrar libros");
            System.out.println("5. Prestar libro");
            System.out.println("6. Devolver libro");
            System.out.println("7. Agregar usuario");
            System.out.println("8. Agregar libro");
            System.out.println("9. Quitar usuario");
            System.out.println("10. Quitar libro");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            if (opcion == 1) {
                System.out.print("Ingrese el ID del usuario a editar: ");
                String id = scanner.nextLine();
                System.out.print("Ingrese el nuevo nombre del usuario: ");
                String nuevoNombre = scanner.nextLine();
                admin.editarUsuario(biblioteca, id, nuevoNombre);
            } else if (opcion == 2) {
                System.out.print("Ingrese el ISBN del libro a editar: ");
                String isbn = scanner.nextLine();
                System.out.print("Ingrese el nuevo título del libro: ");
                String nuevoTitulo = scanner.nextLine();
                System.out.print("Ingrese el nuevo autor del libro: ");
                String nuevoAutor = scanner.nextLine();
                System.out.print("Ingrese la nueva cantidad de ejemplares: ");
                int nuevosEjemplares = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
                admin.editarLibro(biblioteca, isbn, nuevoTitulo, nuevoAutor, nuevosEjemplares);
            } else if (opcion == 3) {
                System.out.println("Usuarios en la biblioteca:");
                biblioteca.mostrarUsuarios();
            } else if (opcion == 4) {
                System.out.println("Libros en la biblioteca:");
                biblioteca.mostrarLibros();
            } else if (opcion == 5) {
                System.out.print("Ingrese el ISBN del libro a prestar: ");
                String isbn = scanner.nextLine();
                if (admin.prestarLibro(biblioteca, isbn)) {
                    System.out.println("Libro prestado exitosamente.");
                } else {
                    System.out.println("No hay ejemplares disponibles para prestar.");
                }
            } else if (opcion == 6) {
                System.out.print("Ingrese el ISBN del libro a devolver: ");
                String isbn = scanner.nextLine();
                admin.devolverLibro(biblioteca, isbn);
                System.out.println("Libro devuelto exitosamente.");
            } else if (opcion == 7) {
                System.out.print("Ingrese el nombre del nuevo usuario: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el ID del nuevo usuario: ");
                String id = scanner.nextLine();
                Usuario nuevoUsuario = new Usuario(nombre, id);
                admin.agregarUsuario(biblioteca, nuevoUsuario);
                System.out.println("Usuario agregado exitosamente.");
            } else if (opcion == 8) {
                System.out.print("Ingrese el título del nuevo libro: ");
                String titulo = scanner.nextLine();
                System.out.print("Ingrese el autor del nuevo libro: ");
                String autor = scanner.nextLine();
                System.out.print("Ingrese el ISBN del nuevo libro: ");
                String isbn = scanner.nextLine();
                System.out.print("Ingrese la cantidad de ejemplares del nuevo libro: ");
                int ejemplares = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
                Libro nuevoLibro = new Libro(titulo, autor, isbn, ejemplares);
                admin.agregarLibro(biblioteca, nuevoLibro);
                System.out.println("Libro agregado exitosamente.");
            } else if (opcion == 9) {
                System.out.print("Ingrese el ID del usuario a quitar: ");
                String id = scanner.nextLine();
                admin.quitarUsuario(biblioteca, id);
                System.out.println("Usuario quitado exitosamente.");
            } else if (opcion == 10) {
                System.out.print("Ingrese el ISBN del libro a quitar: ");
                String isbn = scanner.nextLine();
                admin.quitarLibro(biblioteca, isbn);
                System.out.println("Libro quitado exitosamente.");
            } else if (opcion == 11) {
                break;
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}