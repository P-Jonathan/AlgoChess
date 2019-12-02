package fiuba.algo3.algochess.controlador;

import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.Manejador;
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
