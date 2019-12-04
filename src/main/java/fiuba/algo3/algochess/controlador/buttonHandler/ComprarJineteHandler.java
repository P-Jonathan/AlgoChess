package fiuba.algo3.algochess.controlador.buttonHandler;

import fiuba.algo3.algochess.controlador.PosicionarUnidadEvent;
import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.excepciones.PuntosInsuficientesException;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Jinete;
import fiuba.algo3.algochess.vista.ReproductorMusica;
import fiuba.algo3.algochess.vista.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ComprarJineteHandler implements EventHandler<ActionEvent> {
    private Tablero tablero;
    private TableroView tableroView;

    public ComprarJineteHandler(Tablero tablero, TableroView tableroView) {
        this.tablero = tablero;
        this.tableroView = tableroView;
    }

    public void handle(ActionEvent event) {
        try{
            Jinete jinete = new Jinete();
            ReproductorMusica reproductor = new ReproductorMusica("jinete.mp3");
            reproductor.reproducirEfectoDeSonido();
            AdministradorDeTurnos.getInstancia().jugadorActual().comprarUnidad(jinete);
            tableroView.setOnMousePressed(new PosicionarUnidadEvent(jinete, tablero, tableroView));
        } catch (PuntosInsuficientesException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Dinero insuficiente");
            alert.setHeaderText("No tienes suficiente dinero para comprar esta unidad");
            alert.showAndWait();
        }
    }
}
