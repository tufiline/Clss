package libreria;

public class Usuario {
    // Atributos
    private String nombre;
    private String id;

    // Constructor
    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public Usuario(String nombre) {
            this.nombre = nombre;
        }
    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Método para mostrar información del usuario
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
    }
}
