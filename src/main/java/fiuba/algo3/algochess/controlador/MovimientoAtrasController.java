package fiuba.algo3.algochess.controlador;

import fiuba.algo3.algochess.modelo.unidades.Unidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class MovimientoAtrasController implements EventHandler<MouseEvent> {
    private Unidad unidad;

    public MovimientoAtrasController(Unidad unidad) {
        this.unidad = unidad;
    }

    public void handle(MouseEvent mouseEvent) {
        unidad.moverHaciaAtras();

        AccionesController.getInstancia().resetPanes();
    }
}

