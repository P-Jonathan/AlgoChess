package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.controlador.MovimientoControllerNull;
import fiuba.algo3.algochess.modelo.excepciones.UnidadFueraDeRango;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Manejador {
    private static final Manejador instancia = new Manejador();

    private Unidad autor;
    private List<Pane> panes;

    private Manejador() {
        autor = null;
    }

    public static Manejador getInstancia() { return instancia; }

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
        	}catch (UnidadFueraDeRango e) {
        		Alert alert = new Alert(Alert.AlertType.WARNING);
        		alert.setContentText("La unidad que intentaste atacar esta fuera de rango.");
        		alert.showAndWait();
        	}
        	resetPanes();
        }
    }

    public boolean tieneAutor() {
        return autor != null;
    }
}
