package fiuba.algo3.algochess.controlador;

import fiuba.algo3.algochess.controlador.movecontroller.MovimientoControllerNull;
import fiuba.algo3.algochess.modelo.excepciones.NoSePuedeAtacarAAliados;
import fiuba.algo3.algochess.modelo.excepciones.UnidadFueraDeRango;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class AccionesController {
    private static final AccionesController instancia = new AccionesController();

    private Unidad autor;
    private List<Pane> panes;

    private AccionesController() {
        autor = null;
    }

    public static AccionesController getInstancia() { return instancia; }

    public void agregarUnidad(Unidad unidad) {
        atacar(unidad);
    }

    public void agregarUnidad(Unidad unidad, ArrayList<Pane> panes) {
        this.autor = unidad;
        this.panes = panes;
    }

    public void resetPanes() {
        panes.forEach(pane -> {
            pane.setStyle("-fx-background-color: #000ff");
            pane.setOnMouseClicked(new MovimientoControllerNull());
        });

        autor = null;
    }

    public void atacar(Unidad unidad) {
        if(autor != unidad) {
        	try {
            autor.usarHabilidad(unidad);
        	} catch (NoSePuedeAtacarAAliados e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Atacar aliados");
                alert.setHeaderText("No puedes atacar a una unidad aliada");
                alert.showAndWait();
            } catch (UnidadFueraDeRango e) {
        		Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Unidad fuera de rango");
        		alert.setHeaderText("La unidad que intentaste atacar esta fuera de rango.");
        		alert.showAndWait();
        	}
        	resetPanes();
        }
    }

    public boolean tieneAutor() {
        return autor != null;
    }
}
