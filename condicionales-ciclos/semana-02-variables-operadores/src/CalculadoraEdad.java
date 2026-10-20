public class CalculadoraEdad {
    public static void main(String[] args) {
        // Datos del estudiante definidos directamente en el código
        String nombreCompleto = "Mynor Adolfo Giron Muralles";
        String carne = "9941 25 8300";
        int anioNacimiento = 2003;
        int anioActual = 2026;

        // Calcula la edad aproximada utilizando los años ingresados
        int edadAproximada = anioActual - anioNacimiento;
        int edadEnMeses = edadAproximada * 12;
        boolean esMayorDeEdad = edadAproximada >= 18;

        // Impresión de la evidencia de ejecución en el formato requerido
        System.out.println("----- RESULTADO -----");
        System.out.println("Estudiante: " + nombreCompleto);
        System.out.println("Carné: " + carne);
        System.out.println("Edad aproximada: " + edadAproximada + " años");
        System.out.println("Edad aproximada en meses: " + edadEnMeses + " meses");
        System.out.println("¿Es mayor de edad?: " + esMayorDeEdad);
    }
}