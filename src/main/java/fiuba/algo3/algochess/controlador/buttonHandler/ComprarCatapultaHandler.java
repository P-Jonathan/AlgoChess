package fiuba.algo3.algochess.controlador.buttonHandler;

import fiuba.algo3.algochess.controlador.PosicionarUnidadEvent;
import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.excepciones.PuntosInsuficientesException;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Catapulta;
import fiuba.algo3.algochess.vista.ReproductorMusica;
import fiuba.algo3.algochess.vista.ShopView;
import fiuba.algo3.algochess.vista.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ComprarCatapultaHandler implements EventHandler<ActionEvent> {
    private Tablero tablero;
    private TableroView tableroView;
    private ShopView shopView;

    public ComprarCatapultaHandler(Tablero tablero, TableroView tableroView, ShopView shopView) {
        this.tablero = tablero;
        this.tableroView = tableroView;
        this.shopView = shopView;
    }

    public void handle(ActionEvent event) {
        try{
            Catapulta catapulta = new Catapulta();
            ReproductorMusica reproductor = new ReproductorMusica("catapulta.mp3");
            reproductor.reproducirEfectoDeSonido();
            AdministradorDeTurnos.getInstancia().jugadorActual().comprarUnidad(catapulta);
            tableroView.pintarCasillasDelJugador();
            shopView.setDisable(true);
            tableroView.setOnMousePressed(new PosicionarUnidadEvent(catapulta, tablero, tableroView, shopView));
        } catch (PuntosInsuficientesException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Dinero insuficiente");
            alert.setHeaderText("No tienes suficiente dinero para comprar esta unidad");
            alert.showAndWait();
        }
    }
}
