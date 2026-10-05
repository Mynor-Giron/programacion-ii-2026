package model;

public class ResumenInventario {
    private int cantidadProductos;
    private int totalUnidades;
    private double valorTotal;

    public ResumenInventario() {
    }

    public ResumenInventario(int cantidadProductos, int totalUnidades, double valorTotal) {
        this.cantidadProductos = cantidadProductos;
        this.totalUnidades = totalUnidades;
        this.valorTotal = valorTotal;
    }

    // Getters y Setters
    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public int getTotalUnidades() {
        return totalUnidades;
    }

    public void setTotalUnidades(int totalUnidades) {
        this.totalUnidades = totalUnidades;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}