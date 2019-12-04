package fiuba.algo3.algochess.controlador.movecontroller;

import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.unidadview.UnidadView;
import javafx.scene.input.MouseEvent;

public class MovimientoControllerNull extends MoveHandler {
    public MovimientoControllerNull() {
        super(null, null);
    }

    public void handle(MouseEvent mouseEvent){}
}
