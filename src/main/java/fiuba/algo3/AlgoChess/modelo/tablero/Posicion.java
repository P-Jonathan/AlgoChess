package fiuba.algo3.AlgoChess.modelo.tablero;

import static java.lang.Math.sqrt;
import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Posicion {
    private int x;
    private int y;

    public Posicion() {
        x = 0;
        y = 0;
    }

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int distanciaAPosicion(Posicion posicion) {
        return posicion.distanciaAXeY(x, y);
    }

    private int distanciaAXeY(int x, int y) {
        int distanciaEnX = abs(this.x - x);
        int distanciaEnY = abs(this.y - y);
        return (int) sqrt(pow(2, distanciaEnX) + pow(2, distanciaEnY));
    }

    Posicion posicionArriba() {
        return new Posicion(x + 1, y);
    }

    Posicion posicionADerecha() {
        return new Posicion(x, y + 1);
    }

    Posicion posicionAbajo() {
        return new Posicion(x - 1, y);
    }

    Posicion posicionAIzquierda() {
        return new Posicion(x, y - 1);
    }
}
