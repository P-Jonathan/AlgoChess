package fiuba.algo3.algochess.controlador;

import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.Manejador;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class MovimientoDerechaController implements EventHandler<MouseEvent> {
    private Unidad unidad;

    public MovimientoDerechaController(Unidad unidad) {
        this.unidad = unidad;
    }

    public void handle(MouseEvent mouseEvent) {
        unidad.moverALaDerecha();

        Manejador.getInstancia().resetPanes();
    }
}
