// Parcial2Lenguajes1/Persona.java
abstract class Persona {
    protected String nombre;

    public Persona(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void mostrarInfo();
}