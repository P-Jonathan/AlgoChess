package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.modelo.tablero.Posicion;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import fiuba.algo3.AlgoChess.modelo.unidades.UnidadDeInfanteria;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class UnidadInfanteriaPosicionable implements EventHandler<MouseEvent> {
    private Tablero tablero;

    public UnidadInfanteriaPosicionable(Tablero tablero) {
        this.tablero = tablero;
    }
    public void handle(MouseEvent mouseEvent) {
        int x = (int) mouseEvent.getX() / 32;
        int y = (int) mouseEvent.getY() / 32;

        tablero.posicionarUnidad(new UnidadDeInfanteria(), new Posicion(x,y));
    }
}
