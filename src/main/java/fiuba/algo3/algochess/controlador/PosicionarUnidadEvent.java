package fiuba.algo3.algochess.controlador;

import fiuba.algo3.algochess.modelo.tablero.Posicion;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Curandero;
import fiuba.algo3.algochess.modelo.unidades.Jinete;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;
import fiuba.algo3.algochess.vista.*;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

import java.util.function.Supplier;

public class PosicionarUnidadEvent implements EventHandler<MouseEvent> {
    private Unidad unidad;
    private Tablero tablero;
    private TableroView tableroView;

    public PosicionarUnidadEvent(Unidad unidad, Tablero tablero, TableroView tableroView) {
        this.unidad = unidad;
        this.tablero = tablero;
        this.tableroView = tableroView;
    }

    public void handle(MouseEvent mouseEvent) {
        int x = (int) mouseEvent.getX() / 48;
        int y = (int) mouseEvent.getY() / 38;

        try {
            if(unidad != null) {
                tablero.posicionarUnidad(unidad, new Posicion(x, y));

                // Lo hago asi ahora despues con el map sacamos esta atrocidad xd
                if (unidad.getClass() == UnidadDeInfanteria.class) {
                    new UnidadInfanteriaView(tableroView, unidad);
                } else if (unidad.getClass() == Jinete.class) {
                    new JineteView(tableroView, unidad);
                } else if (unidad.getClass() == Curandero.class) {
                    new CuranderoView(tableroView, unidad);
                } else {
                    new CatapultaView(tableroView, unidad);
                }

                unidad = null;
            }
        } catch(RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("No podes posicionar esa unidad en este lado del mapa");

            alert.showAndWait();
        }
    }
}
