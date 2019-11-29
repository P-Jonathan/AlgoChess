package fiuba.algo3.AlgoChess.controlador;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import fiuba.algo3.AlgoChess.vista.Manejador;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class MovimientoAdelanteController implements EventHandler<MouseEvent> {
    private Unidad unidad;

    public MovimientoAdelanteController(Unidad unidad) {
        this.unidad = unidad;
    }

    public void handle(MouseEvent mouseEvent) {
        unidad.moverHaciaAdelante();

        Manejador.getInstancia().resetPanes();
    }
}
