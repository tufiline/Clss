package libreria;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // Atributos
    private List<Usuario> usuarios;
    private List<Libro> libros;

    // Constructor
    public Biblioteca() {
        this.usuarios = new ArrayList<>();
        this.libros = new ArrayList<>();
    }

    // Métodos para agregar usuarios y libros
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // Métodos para quitar usuarios y libros
    public void quitarUsuario(String id) {
        usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }

    public void quitarLibro(String isbn) {
        libros.removeIf(libro -> libro.getIsbn().equals(isbn));
    }

    // Métodos para mostrar información
    public void mostrarUsuarios() {
        for (Usuario usuario : usuarios) {
            usuario.mostrarInformacion();
        }
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            libro.mostrarInformacion();
        }
    }

    // Métodos para editar usuarios y libros
    public void editarUsuario(String id, String nuevoNombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                usuario.setNombre(nuevoNombre);
                break;
            }
        }
    }

    public void editarLibro(String isbn, String nuevoTitulo, String nuevoAutor, int nuevosEjemplares) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                libro.setEjemplares(nuevosEjemplares);
                break;
            }
        }
    }

    // Método para prestar un libro
    public boolean prestarLibro(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn) && libro.getEjemplares() > 0) {
                libro.setEjemplares(libro.ejemplares - 1);
                return true;
            }
        }
        return false;
    }

    // Método para devolver un libro
    public void devolverLibro(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                libro.setEjemplares(libro.getEjemplares() + 1);
                break;
            }
        }
    }
}