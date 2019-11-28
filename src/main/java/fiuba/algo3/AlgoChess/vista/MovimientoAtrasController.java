package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class MovimientoAtrasController implements EventHandler<MouseEvent> {
    private Unidad unidad;

    public MovimientoAtrasController(Unidad unidad) {
        this.unidad = unidad;
    }

    public void handle(MouseEvent mouseEvent) {
        unidad.moverHaciaAtras();
        Manejador.getInstancia().reset();
    }
}

