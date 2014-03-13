/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jackpot;

import java.util.Random;

/**
 *
 * @author Raul
 */
public class Partida {

    Random generador = new Random();
    int secuencia[] = new int[3];
    int premio;
    

    public void generarSecuencia() {

        for (int i = 0; i < 3; i++) {
            secuencia[i] = generador.nextInt(5);
        }
    }

    public int getImagen(int i) {
        return secuencia[i];
    }

    public double comprobarPremio() {

        switch (secuencia[0]) {
            case 0:
                if (secuencia[1] == 0) {
                    return 5;
                } else {
                    return 1;
                }

            case 1:
                if (secuencia[1] == 1) {
                    if (secuencia[2] == 1) {
                        return 10;
                    }
                    if (secuencia[2] == 4) {
                        return 10;
                    }
                }
            case 2:
                if (secuencia[1] == 2) {
                    if (secuencia[2] == 2) {
                        return 15;
                    }
                    if (secuencia[2] == 4) {
                        return 15;
                    }
                }
            case 3:
                if (secuencia[1] == 3) {
                    if (secuencia[2] == 3) {
                        return 20;
                    }
                    if (secuencia[2] == 4) {
                        return 20;
                    }
                }
            case 4:
                if (secuencia[1] == 4) {
                    if (secuencia[2] == 4) {
                        return 100;
                    }
                }
            default:
                return 0;
        }

    }

}
