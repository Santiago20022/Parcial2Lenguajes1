import java.time.*;

class Egresado extends Persona {
    private int edad;
    private LocalDate fechaMatricula;
    private LocalDate fechaTerminacion;

    public Egresado(String nombre, int edad, LocalDate fechaMatricula, LocalDate fechaTerminacion) {
        super(nombre);
        if (edad <= 0) throw new IllegalArgumentException("Edad inválida.");
        if (fechaMatricula.compareTo(fechaTerminacion) > 0)
            throw new IllegalArgumentException("La fecha de matrícula no puede ser posterior a la de terminación.");
        this.edad = edad;
        this.fechaMatricula = fechaMatricula;
        this.fechaTerminacion = fechaTerminacion;
    }

    public long calcularDuracionEstudios() {
        Period period = Period.between(fechaMatricula, fechaTerminacion);
        return period.getYears() * 12 + period.getMonths();
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Egresado: " + nombre + ", Edad: " + edad +
                ", Duración del estudio: " + calcularDuracionEstudios() + " meses");
    }
}