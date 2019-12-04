package fiuba.algo3.algochess.controlador;

import fiuba.algo3.algochess.modelo.unidades.Unidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class MovimientoIzquierdaController implements EventHandler<MouseEvent> {
    private Unidad unidad;

    public MovimientoIzquierdaController(Unidad unidad) {
        this.unidad = unidad;
    }

    public void handle(MouseEvent mouseEvent) {
        unidad.moverALaIzquierda();

        AccionesController.getInstancia().resetPanes();
    }
}
