// Parcial2Lenguajes1/Validar.java

public class Validar {
    public static void main(String[] args) {
        // tests
    }

    public static boolean validarEstatura(String est) {
        return est.matches("[\\d.]{3,4}+");
    }

    public static boolean validarEdad(String ed) {
        return ed.matches("[0-9]{1,2}+"); // Cambiado para permitir edades de 1 a 99
    }
    
    public static boolean validarNombre(String nom) {
        return nom.matches("[a-zA-Z ]{7,40}+");
    }
}