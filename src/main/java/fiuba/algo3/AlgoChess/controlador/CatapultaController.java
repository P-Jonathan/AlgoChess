package fiuba.algo3.AlgoChess.controlador;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import fiuba.algo3.AlgoChess.vista.Manejador;
import fiuba.algo3.AlgoChess.vista.TableroView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class CatapultaController implements EventHandler<MouseEvent> {
    private Unidad unidad;
    private TableroView tableroView;

    public CatapultaController(Unidad unidad, TableroView tableroView) {
        this.unidad = unidad;
        this.tableroView = tableroView;
    }

    public void handle(MouseEvent mouseEvent) {
        if(!Manejador.getInstancia().tieneAutor()) {
            ArrayList<Pane> panes = new ArrayList<Pane>();
            panes.add(tableroView.paneActual(unidad));

            Manejador.getInstancia().agregarUnidad(unidad, panes);
        } else {
            Manejador.getInstancia().agregarUnidad(unidad);
        }
    }
}
