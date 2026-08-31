/**
 * Clase Main
 * Programa principal que demuestra el uso de:
 * - Abstracción (clase abstracta Figura)
 * - Herencia (Circulo, Rectangulo, Triangulo)
 * - Sobrescritura (@Override)
 * - Polimorfismo (arreglo de tipo Figura)
 * - Encapsulamiento (atributos private)
 *
 * @author Mynor Adolfo Girón Muralles
 * @carnet 9941-25-8300
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("   SISTEMA DE FIGURAS GEOMÉTRICAS");
        System.out.println("=====================================");
        System.out.println("Estudiante: Mynor Adolfo Girón Muralles");
        System.out.println("Carné: 9941-25-8300");
        System.out.println("=====================================\n");

        // Crear objetos de cada figura (polimorfismo)
        Figura circulo = new Circulo("Círculo", 5.0);
        Figura rectangulo = new Rectangulo("Rectángulo", 8.0, 4.0);
        Figura triangulo = new Triangulo("Triángulo", 6.0, 3.0);

        // Guardar los objetos en un arreglo de tipo Figura[]
        Figura[] figuras = {circulo, rectangulo, triangulo};

        // Recorrer el arreglo usando for-each
        System.out.println("--- RESULTADOS ---\n");

        for (Figura figura : figuras) {
            // Mostrar el nombre de la figura
            System.out.println("Nombre: " + figura.getNombre());

            // Calcular y mostrar el área (con dos decimales)
            double area = figura.calcularArea();
            System.out.println("Área: " + String.format("%.2f", area) + " unidades²");
            System.out.println(); // Línea en blanco entre figuras
        }

        // Mostrar información detallada usando el método sobrescrito
        System.out.println("--- INFORMACIÓN DETALLADA ---\n");

        for (Figura figura : figuras) {
            figura.mostrarInformacion();
            System.out.println();
        }

        System.out.println("✅ Programa ejecutado correctamente.");
        System.out.println("🌟 Demostración de abstracción, herencia y polimorfismo.");
    }
}
