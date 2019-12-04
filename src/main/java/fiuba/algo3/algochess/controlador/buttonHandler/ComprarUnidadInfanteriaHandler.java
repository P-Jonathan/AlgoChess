package fiuba.algo3.algochess.controlador.buttonHandler;

import fiuba.algo3.algochess.controlador.PosicionarUnidadEvent;
import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.excepciones.PuntosInsuficientesException;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;
import fiuba.algo3.algochess.vista.ReproductorMusica;
import fiuba.algo3.algochess.vista.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ComprarUnidadInfanteriaHandler implements EventHandler<ActionEvent> {
    private Tablero tablero;
    private TableroView tableroView;

    public ComprarUnidadInfanteriaHandler(Tablero tablero, TableroView tableroView) {
        this.tablero = tablero;
        this.tableroView = tableroView;
    }

    public void handle(ActionEvent event) {
        try{
            UnidadDeInfanteria unidadDeInfanteria = new UnidadDeInfanteria();
            ReproductorMusica reproductor = new ReproductorMusica("infanteria.mp3");
            reproductor.reproducirEfectoDeSonido();
            AdministradorDeTurnos.getInstancia().jugadorActual().comprarUnidad(unidadDeInfanteria);
            tableroView.setOnMousePressed(new PosicionarUnidadEvent(unidadDeInfanteria, tablero, tableroView));
        } catch (PuntosInsuficientesException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Dinero insuficiente");
            alert.setHeaderText("No tienes suficiente dinero para comprar esta unidad");
            alert.showAndWait();
        }
    }
}
