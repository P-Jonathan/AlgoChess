package fiuba.algo3.algochess.controlador;

import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.tablero.Posicion;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Curandero;
import fiuba.algo3.algochess.modelo.unidades.Jinete;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;
import fiuba.algo3.algochess.vista.*;
import fiuba.algo3.algochess.vista.unidadview.*;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

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
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();
        int x = (int) mouseX / tableroView.getTileWidth();
        int y = (int) mouseY / tableroView.getTileHeigth();

        System.out.println("Pane position: (" + x + "," + y + ")");

        try {
            if (unidad != null) {
                tablero.posicionarUnidad(unidad, new Posicion(x, y));
                ViewFactory.getInstance(unidad, tableroView);
                AdministradorDeTurnos.getInstancia().administrarCompras();
                unidad = null;
            }
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("No podes posicionar esa unidad en este lado del mapa");
            alert.showAndWait();
        }
    }
}
