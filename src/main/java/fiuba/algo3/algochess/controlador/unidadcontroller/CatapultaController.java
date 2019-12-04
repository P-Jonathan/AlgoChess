package fiuba.algo3.algochess.controlador.unidadcontroller;

import fiuba.algo3.algochess.controlador.AccionesController;
import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.TableroView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class CatapultaController extends UnidadController {

    public CatapultaController(Unidad unidad, TableroView tableroView) {
        super(unidad, tableroView);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (AdministradorDeTurnos.getInstancia().turnoDe(unidad.propietario())) {
            ArrayList<Pane> panes = new ArrayList<Pane>();
            panes.add(tableroView.paneActual(unidad));

            AccionesController.getInstancia().agregarUnidad(unidad, panes);
        }
        if (AccionesController.getInstancia().tieneAutor()) {
            AccionesController.getInstancia().agregarUnidad(unidad);
        }
    }
}
