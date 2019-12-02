package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.excepciones.PuntosIngresadosInvalidos;
import fiuba.algo3.algochess.modelo.excepciones.PuntosInsuficientesException;

public class Billetera {
    private int puntos;

    public Billetera(int montoInicial) {
        if(noSonPuntosValidos(montoInicial))
            throw new PuntosIngresadosInvalidos();

        puntos = Math.max(montoInicial, 0);
    }

    public int getPuntos() {
        return puntos;
    }

    private boolean noPuedePagar(int monto) {
        return puntos < monto;
    }

    private boolean noSonPuntosValidos(int puntos) {
        return puntos < 0;
    }

    public void pagar(int monto) {
        if (noPuedePagar(monto))
            throw new PuntosInsuficientesException();
        this.puntos -= monto;
    }

    public void ingresarPuntos(int puntos) {
        if (noSonPuntosValidos(puntos))
            throw new PuntosIngresadosInvalidos();
        this.puntos += puntos;
    }
}
