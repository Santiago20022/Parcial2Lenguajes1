// Parcial2Lenguajes1/Institucion.java
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Institucion {
    private static LinkedList<Egresado> egresados = new LinkedList<>();
    private static HashSet<Empleado> empleados = new HashSet<>();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar Egresado");
            System.out.println("2. Agregar Empleado");
            System.out.println("3. Listar Egresados");
            System.out.println("4. Listar Empleados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    agregarEgresado();
                    break;
                case 2:
                    agregarEmpleado();
                    break;
                case 3:
                    listarEgresados();
                    break;
                case 4:
                    listarEmpleados();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 5);
    }

    private static void agregarEgresado() {
        try {
            String nombre;
            do {
                System.out.print("Nombre: ");
                nombre = scanner.nextLine();
                if (nombre.trim().isEmpty()) {
                    System.out.println("El nombre no puede estar vacío. Inténtalo de nuevo.");
                }
            } while (nombre.trim().isEmpty());

            int edad = -1;
            while (edad < 1 || edad > 99) {
                System.out.print("Edad (1-99): ");
                String edadInput = scanner.nextLine();
                try {
                    edad = Integer.parseInt(edadInput);
                    if (edad < 1 || edad > 99) {
                        System.out.println("Edad inválida. Debe ser un número entre 1 y 99.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                }
            }

            LocalDate fecha1, fecha2;
            System.out.print("Fecha de matrícula (yyyy-MM-dd): ");
            fecha1 = LocalDate.parse(scanner.nextLine(), formatter);
            System.out.print("Fecha de terminación (yyyy-MM-dd): ");
            fecha2 = LocalDate.parse(scanner.nextLine(), formatter);

            egresados.add(new Egresado(nombre, edad, fecha1, fecha2));
            System.out.println("Egresado agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar egresado: " + e.getMessage());
        }
    }

    private static void agregarEmpleado() {
        try {
            String nombre;
            do {
                System.out.print("Nombre: ");
                nombre = scanner.nextLine();
                if (nombre.trim().isEmpty()) {
                    System.out.println("El nombre no puede estar vacío. Inténtalo de nuevo.");
                }
            } while (nombre.trim().isEmpty());

            String cargo;
            do {
                System.out.print("Cargo: ");
                cargo = scanner.nextLine();
                if (cargo.trim().isEmpty()) {
                    System.out.println("El cargo no puede estar vacío. Inténtalo de nuevo.");
                }
            } while (cargo.trim().isEmpty());

            String dependencia;
            do {
                System.out.print("Dependencia: ");
                dependencia = scanner.nextLine();
                if (dependencia.trim().isEmpty()) {
                    System.out.println("La dependencia no puede estar vacía. Inténtalo de nuevo.");
                }
            } while (dependencia.trim().isEmpty());

            LocalDate fecha1, fecha2;
            System.out.print("Fecha de inicio laboral (yyyy-MM-dd): ");
            fecha1 = LocalDate.parse(scanner.nextLine(), formatter);
            System.out.print("Fecha actual (yyyy-MM-dd): ");
            fecha2 = LocalDate.parse(scanner.nextLine(), formatter);

            empleados.add(new Empleado(nombre, cargo, dependencia, fecha1, fecha2));
            System.out.println("Empleado agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar empleado: " + e.getMessage());
        }
    }

    private static void listarEgresados() {
        if (egresados.isEmpty()) {
            System.out.println("No hay egresados registrados.");
        } else {
            System.out.println("\n--- Lista de Egresados ---");
            for (Egresado e : egresados) {
                e.mostrarInfo();
            }
        }
    }

    private static void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("\n--- Lista de Empleados ---");
            for (Empleado e : empleados) {
                e.mostrarInfo();
            }
        }
    }
}