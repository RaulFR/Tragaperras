
package jackpot;

/**
 *
 * @author Raul
 */
public class Saldo {
    private double saldoMaquina = 1000;
    private double saldoJugador;
    final double MONEDA1 = 0.5;
    final double MONEDA2 = 1;
    final double MONEDA3 = 2;
    final double INVERTIR = -0.5;
    
    public void insertarMonedas(double saldoJugador){
        this.saldoJugador += saldoJugador;
        this.saldoMaquina += saldoJugador;
    }
    public void incrementarSaldoJugador(double saldoJugador){
        this.saldoJugador += saldoJugador;
    }
    
    public double getSaldoJugador(){
        return saldoJugador;
    }
    
    public double cobrarSaldo(){
        double saldoCobrar = saldoJugador;
        this.saldoMaquina -= saldoJugador;
        saldoJugador = 0;
        return saldoCobrar;
    }

    public double getSaldoMaquina() {
        return saldoMaquina;
    }
    
    
}
