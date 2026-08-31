/**
 * Clase abstracta Figura
 * Representa una figura geométrica genérica.
 * Actúa como superclase para Circulo, Rectangulo y Triangulo.
 * No puede ser instanciada directamente.
 *
 * @author Mynor Adolfo Girón Muralles
 * @carnet 9941-25-8300
 */
public abstract class Figura {
    // Atributo privado (encapsulamiento)
    private String nombre;

    /**
     * Constructor para inicializar el nombre de la figura
     * @param nombre Nombre de la figura
     */
    public Figura(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método público para consultar el nombre de la figura
     * @return Nombre de la figura
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método concreto para mostrar la información de la figura
     * Puede ser heredado por las subclases
     */
    public void mostrarInformacion() {
        System.out.println("Figura: " + nombre);
        System.out.println("Área: " + String.format("%.2f", calcularArea()) + " unidades²");
    }

    /**
     * Método abstracto para calcular el área
     * Las subclases deben implementar este método
     * @return Área de la figura
     */
    public abstract double calcularArea();
}