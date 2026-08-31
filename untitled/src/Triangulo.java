/**
 * Clase Triangulo
 * Representa un triángulo con base y altura.
 * Hereda de la clase abstracta Figura.
 *
 * @author Mynor Adolfo Girón Muralles
 * @carnet 9941-25-8300
 */
public class Triangulo extends Figura {
    // Atributos privados (encapsulamiento)
    private double base;
    private double altura;

    /**
     * Constructor para inicializar un triángulo
     * @param nombre Nombre de la figura
     * @param base Base del triángulo (debe ser mayor que cero)
     * @param altura Altura del triángulo (debe ser mayor que cero)
     */
    public Triangulo(String nombre, double base, double altura) {
        super(nombre); // Llamada al constructor de la superclase
        this.base = base;
        this.altura = altura;
    }

    // ========== GETTERS Y SETTERS ==========

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        if (base > 0) {
            this.base = base;
        } else {
            System.out.println("La base debe ser mayor que cero.");
        }
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            System.out.println("La altura debe ser mayor que cero.");
        }
    }

    /**
     * Sobrescritura del método abstracto calcularArea()
     * Fórmula: Área = (base × altura) / 2
     * @return Área del triángulo
     */
    @Override
    public double calcularArea() {
        return (base * altura) / 2.0;
    }

    /**
     * Sobrescritura del método mostrarInformacion()
     * Incluye información específica del triángulo
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Figura: " + getNombre());
        System.out.println("Base: " + base + " unidades");
        System.out.println("Altura: " + altura + " unidades");
        System.out.println("Área: " + String.format("%.2f", calcularArea()) + " unidades²");
    }
}