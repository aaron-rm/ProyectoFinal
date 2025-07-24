package cSistema.aUsuario;

public class Cuenta {
  private String idCuenta;
    private String password;
    private Cliente cliente;
    private boolean activa;
    private int puntosAcumulados;

    public Cuenta(String idCuenta, String password, Cliente cliente) {
        this.idCuenta = idCuenta;
        this.password = password;
        this.cliente = cliente;
        this.activa = false;
        this.puntosAcumulados = 0;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isActiva() {
        return activa;
    }
  
    //Activar cuenta
    public void activarCuenta() {
        if (!activa) {
            activa = true;
            System.out.println("Cuenta activada exitosamente.");
        } else {
            System.out.println("La cuenta ya está activa.");
        }
    }

    //Cerrar cuenta
    public void cerrarCuenta() {
        if (activa) {
            activa = false;
            System.out.println("Cuenta cerrada exitosamente.");
        } else {
            System.out.println("La cuenta ya está cerrada.");
        }
    }

    //Pts por compra
    public void agregarPuntos(double totalCompra) {
        int puntos = (int)(totalCompra / 10);
        puntosAcumulados += puntos;
        System.out.println("Se agregaron " + puntos + " puntos a la cuenta.");
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }
}
