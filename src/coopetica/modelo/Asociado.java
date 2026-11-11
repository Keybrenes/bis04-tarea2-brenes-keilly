package coopetica.modelo;
public class Asociado {
    private String cedula;
    private String nombre;
    private double saldoAportes;
    public Asociado(String cedula, String nombre, double saldoAportes) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.saldoAportes = saldoAportes;
    }
    public String getCedula()      { return cedula; }
    public String getNombre()      { return nombre; }
    public double getSaldoAportes(){ return saldoAportes; }

    public void setSaldoAportes(double saldoAportes) {
        this.saldoAportes = saldoAportes;
    }
    @Override
    public String toString() {
        return cedula + " - " + nombre + " - Aportes: " + saldoAportes;
    }
}