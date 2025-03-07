package libreria;

public class Administrador extends Usuario {
    // Atributo adicional
    private String nivelAcceso;

    // Constructor
    public Administrador(String nombre, String id, String nivelAcceso) {
        super(nombre, id);
        this.nivelAcceso = nivelAcceso;
    }

    // Método getter y setter para nivelAcceso
    public String getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    // Método para mostrar información del administrador
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Nivel de Acceso: " + nivelAcceso);
    }

    // Método específico para administrador
    public void gestionarBiblioteca() {
        System.out.println("Gestionando la biblioteca...");
    }

    // Métodos para editar usuarios y libros
    public void editarUsuario(Biblioteca biblioteca, String id, String nuevoNombre) {
        biblioteca.editarUsuario(id, nuevoNombre);
    }

    public void editarLibro(Biblioteca biblioteca, String isbn, String nuevoTitulo, String nuevoAutor, int nuevosEjemplares) {
        biblioteca.editarLibro(isbn, nuevoTitulo, nuevoAutor, nuevosEjemplares);
    }

    // Métodos para prestar y devolver libros
    public boolean prestarLibro(Biblioteca biblioteca, String isbn) {
        return biblioteca.prestarLibro(isbn);
    }

    public void devolverLibro(Biblioteca biblioteca, String isbn) {
        biblioteca.devolverLibro(isbn);
    }

    // Métodos para agregar y quitar usuarios y libros
    public void agregarUsuario(Biblioteca biblioteca, Usuario usuario) {
        biblioteca.agregarUsuario(usuario);
    }

    public void agregarLibro(Biblioteca biblioteca, Libro libro) {
        biblioteca.agregarLibro(libro);
    }

    public void quitarUsuario(Biblioteca biblioteca, String id) {
        biblioteca.quitarUsuario(id);
    }

    public void quitarLibro(Biblioteca biblioteca, String isbn) {
        biblioteca.quitarLibro(isbn);
    }
}
