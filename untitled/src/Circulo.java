/**
 * Clase Circulo
 * Representa un círculo con un radio específico.
 * Hereda de la clase abstracta Figura.
 *
 * @author Mynor Adolfo Girón Muralles
 * @carnet 9941-25-8300
 */
public class Circulo extends Figura {
    // Atributo privado (encapsulamiento)
    private double radio;

    /**
     * Constructor para inicializar un círculo
     * @param nombre Nombre de la figura
     * @param radio Radio del círculo (debe ser mayor que cero)
     */
    public Circulo(String nombre, double radio) {
        super(nombre); // Llamada al constructor de la superclase
        this.radio = radio;
    }

    /**
     * Getter para el radio
     * @return Radio del círculo
     */
    public double getRadio() {
        return radio;
    }

    /**
     * Setter para el radio con validación
     * @param radio Nuevo radio (debe ser mayor que cero)
     */
    public void setRadio(double radio) {
        if (radio > 0) {
            this.radio = radio;
        } else {
            System.out.println("El radio debe ser mayor que cero.");
        }
    }

    /**
     * Sobrescritura del método abstracto calcularArea()
     * Fórmula: Área = π × radio²
     * @return Área del círculo
     */
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    /**
     * Sobrescritura del método mostrarInformacion()
     * Incluye información específica del círculo
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Figura: " + getNombre());
        System.out.println("Radio: " + radio + " unidades");
        System.out.println("Área: " + String.format("%.2f", calcularArea()) + " unidades²");
    }
}