package fiuba.algo3.algochess.controlador;

import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.Manejador;
import fiuba.algo3.algochess.vista.TableroView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class UnidadInfanteriaController implements EventHandler<MouseEvent> {
    private Unidad unidad;
    private TableroView tableroView;

    public UnidadInfanteriaController(Unidad unidad, TableroView tableroView) {
        this.unidad = unidad;
        this.tableroView = tableroView;
    }

    public void handle(MouseEvent mouseEvent) {
        if(!Manejador.getInstancia().tieneAutor()) {
            ArrayList<Pane> panes = tableroView.getPanesAdyacentes(unidad);
            panes.add(tableroView.paneActual(unidad));

            Manejador.getInstancia().agregarUnidad(unidad, panes);
        } else {
            Manejador.getInstancia().agregarUnidad(unidad);
        }
    }
}
