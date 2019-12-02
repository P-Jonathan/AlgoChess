package fiuba.algo3.AlgoChess.modelo.tablero;

import fiuba.algo3.AlgoChess.modelo.excepciones.PuntosIngresadosInvalidos;
import fiuba.algo3.AlgoChess.modelo.excepciones.PuntosInsuficientesException;

public class Billetera {
    private int puntos;

    Billetera(int montoInicial) {
        puntos = Math.max(montoInicial, 0);
    }

    int getPuntos() {
        return puntos;
    }

    private boolean noPuedePagar(int monto) {
        return puntos < monto;
    }

    private boolean noSonPuntosValidos(int puntos) {
        return puntos < 0;
    }

    void pagar(int monto) {
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
