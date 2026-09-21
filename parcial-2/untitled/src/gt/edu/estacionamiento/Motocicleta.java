package gt.edu.estacionamiento;

public class Motocicleta extends Vehiculo {
    private static final double TARIFA_POR_HORA = 6.00;

    public Motocicleta(String placa, String propietario, String horaIngreso, int horasUtilizadas) {
        super(placa, propietario, horaIngreso, horasUtilizadas);
    }

    @Override
    public double calcularCosto() {
        double subtotal = getHorasUtilizadas() * TARIFA_POR_HORA;
        if (getHorasUtilizadas() > 5) {
            subtotal = subtotal * 0.90; // Aplica 10% de descuento
        }
        return subtotal;
    }

    @Override
    public String getTipo() {
        return "Motocicleta";
    }
}
