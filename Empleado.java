// Parcial2Lenguajes1/Empleado.java
import java.time.*;

class Empleado extends Persona {
    private String cargo;
    private String dependencia;
    private LocalDate fechaInicio;
    private LocalDate fechaActual;

    public Empleado(String nombre, String cargo, String dependencia, LocalDate fechaInicio, LocalDate fechaActual) {
        super(nombre);
        if (cargo == null || cargo.trim().isEmpty()) throw new IllegalArgumentException("Cargo inválido.");
        if (dependencia == null || dependencia.trim().isEmpty()) throw new IllegalArgumentException("Dependencia inválida.");
        if (fechaInicio.isAfter(fechaActual))
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha actual.");

        this.cargo = cargo.trim();
        this.dependencia = dependencia.trim();
        this.fechaInicio = fechaInicio;
        this.fechaActual = fechaActual;
    }

    public long calcularTiempoVinculado() {
        Period period = Period.between(fechaInicio, fechaActual);
        return period.getYears() * 12 + period.getMonths();
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre + ", Cargo: " + cargo + ", Dependencia: " + dependencia +
                ", Tiempo vinculado: " + calcularTiempoVinculado() + " meses");
    }
}