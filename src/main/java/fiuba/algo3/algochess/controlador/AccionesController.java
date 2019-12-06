package fiuba.algo3.algochess.controlador;

import fiuba.algo3.algochess.controlador.movecontroller.MovimientoControllerNull;
import fiuba.algo3.algochess.modelo.excepciones.FinDelJuegoException;
import fiuba.algo3.algochess.modelo.excepciones.NoSePuedeAtacarAAliados;
import fiuba.algo3.algochess.modelo.excepciones.UnidadFueraDeRango;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class AccionesController {
    private static final AccionesController instancia = new AccionesController();

    private Unidad autor;
    private List<Pane> panes;

    private AccionesController() {
        autor = null;
    }

    public static AccionesController getInstancia() { return instancia; }

    public void agregarObjetivo(Unidad objetivo) {
        atacar(objetivo);
    }

    public void agregarUnidad(Unidad unidad, ArrayList<Pane> panes) {
        this.autor = unidad;
        this.panes = panes;
    }

    public void reset() {
        panes.forEach(pane -> {
            pane.setStyle("-fx-background-color: #000ff");
            pane.setOnMouseClicked(new MovimientoControllerNull());
        });

        autor = null;
    }

    public void atacar(Unidad objetivo) {
        if(autor != objetivo) {
        	try {
                autor.usarHabilidad(objetivo);
        	} catch (NoSePuedeAtacarAAliados e) {
                /*Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Atacar aliados");
                alert.setHeaderText("No puedes atacar a una unidad aliada");
                alert.showAndWait();*/
                System.out.println("Atacar aliados.\n"
                        + "No puedes atacar a una unidad aliada");
            } catch (UnidadFueraDeRango e) {
        		/*Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Unidad fuera de rango");
        		alert.setHeaderText("La unidad que intentaste atacar esta fuera de rango.");
        		alert.showAndWait();*/
        		System.out.println("Unidad fuera de rango.\n"
                        + "La unidad que intentaste atacar esta fuera de rango.");
        	} catch (FinDelJuegoException e) {
        	    /*
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Game over");
                alert.setHeaderText("Un jugador se ha quedado sin unidades. Fin del juego");
                alert.showAndWait();
                */
                System.out.println("Game over\n"
                        + "Un jugador se ha quedado sin unidades. Fin del juego");
            }
        	reset();
        }
    }

    public boolean tieneAutor() {
        return autor != null;
    }
}
