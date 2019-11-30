package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ComprarUnidad implements EventHandler<MouseEvent> {
    private Tablero tablero;

    public ComprarUnidad(Tablero tablero) {
        this.tablero = tablero;
    }

    public void handle(MouseEvent mouseEvent) {
        new UnidadInfanteriaPosicionable(tablero);
    }
}
