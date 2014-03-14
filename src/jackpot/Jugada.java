package jackpot;

import java.sql.Date;

/**
 *
 * @author Raul
 */
public class Jugada {

    private double saldoMaquina;
    private double saldoJugador;
    private Date fechaHora = null;
    private double premio;

    public void setSaldoMaquina(double saldoMaquina) {
        this.saldoMaquina = saldoMaquina;
    }

    public void setSaldoJugador(double saldoJugador) {
        this.saldoJugador = saldoJugador;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    public void setPremio(double premio) {
        this.premio = premio;
    }

    public double getSaldoMaquina() {
        return saldoMaquina;
    }

    public double getSaldoJugador() {
        return saldoJugador;
    }

    public Date getFechaHora() {
        return fechaHora;
    }
    public double getPremio() {
        return premio;
    }

    @Override
    public String toString() {
        return "Fecha: " + fechaHora + ". Saldo Jugador: " + saldoJugador
                + ". Saldo Maquina: " + saldoMaquina + "Premio: " + premio + "\r\n";
//        return "Saldo Jugador: " + saldoJugador
//                + ". Saldo Maquina: " + saldoMaquina + "Premio: " + premio + "\r\n";
    }
}
