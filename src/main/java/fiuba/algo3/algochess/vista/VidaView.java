package fiuba.algo3.algochess.vista;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VidaView extends Rectangle {
    private static final int ANCHO_BARRA = 28;
    private static final int ALTO_BARRA = 3;
    private static final int X_BARRA = 2;
    private static final int Y_BARRA = 1;
    private double vidaMax;

    public VidaView(double vidaMax) {
        this.vidaMax = vidaMax;
        double vidaActual = vidaMax;

        setWidth(vidaActual / vidaMax * ANCHO_BARRA);
        setHeight(ALTO_BARRA);
        setX(X_BARRA);
        setY(Y_BARRA);
        setFill(Color.GREEN);
    }

    public void actualizarBarra(double vidaActual) {
        setWidth(vidaActual / vidaMax * ANCHO_BARRA);
    }
}
