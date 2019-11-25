package fiuba.algo3.AlgoChess.modelo.tablero;

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
            throw new RuntimeException();
        this.puntos -= monto;
    }

    public void ingresarPuntos(int puntos) {
        if (noSonPuntosValidos(puntos))
            throw new RuntimeException();
        this.puntos += puntos;
    }
}
