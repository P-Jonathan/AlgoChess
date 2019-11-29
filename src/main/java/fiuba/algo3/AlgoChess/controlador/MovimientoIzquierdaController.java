package fiuba.algo3.AlgoChess.controlador;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import fiuba.algo3.AlgoChess.vista.Manejador;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class MovimientoIzquierdaController implements EventHandler<MouseEvent> {
    private Unidad unidad;

    public MovimientoIzquierdaController(Unidad unidad) {
        this.unidad = unidad;
    }

    public void handle(MouseEvent mouseEvent) {
        unidad.moverALaIzquierda();

        Manejador.getInstancia().resetPanes();
    }
}
