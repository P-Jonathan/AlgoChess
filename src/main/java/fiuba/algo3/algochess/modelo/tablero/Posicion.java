package fiuba.algo3.algochess.modelo.tablero;

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

    /*****************************/
    public int getX() { return x; }
    public int getY() { return y; }
    /*****************************/

    int distanciaAPosicion(Posicion posicion) {
        return posicion.distanciaAXeY(x, y);
    }

    private int distanciaAXeY(int x, int y) {
        int distanciaEnX = abs(this.x - x);
        int distanciaEnY = abs(this.y - y);
        return (int) sqrt(pow(distanciaEnX, 2) + pow(distanciaEnY, 2));
    }

    Posicion posicionAdelante() {
        return new Posicion(x, y + 1);
    }

    Posicion posicionADerecha() {
        return new Posicion(x + 1, y);
    }

    Posicion posicionAtras() {
        return new Posicion(x, y - 1);
    }

    Posicion posicionAIzquierda() {
        return new Posicion(x - 1, y);
    }

    public boolean isEquals(Posicion posicion) {
        return posicion.poseeXeY(x, y);
    }

    private boolean poseeXeY(int x, int y) {
        return this.x == x && this.y == y;
    }
}
