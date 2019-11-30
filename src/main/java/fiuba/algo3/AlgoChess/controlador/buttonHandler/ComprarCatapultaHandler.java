package fiuba.algo3.AlgoChess.controlador.buttonHandler;

import fiuba.algo3.AlgoChess.controlador.PosicionarUnidadEvent;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import fiuba.algo3.AlgoChess.modelo.unidades.Catapulta;
import fiuba.algo3.AlgoChess.vista.ReproductorMusica;
import fiuba.algo3.AlgoChess.vista.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComprarCatapultaHandler implements EventHandler<ActionEvent> {
    private Tablero tablero;
    private TableroView tableroView;

    public ComprarCatapultaHandler(Tablero tablero, TableroView tableroView) {
        this.tablero = tablero;
        this.tableroView = tableroView;
    }

    public void handle(ActionEvent event) {
        try{
            Catapulta catapulta = new Catapulta();
            ReproductorMusica reproductor = new ReproductorMusica("catapulta.mp3");
            reproductor.reproducirEfectoDeSonido();
            tablero.getJugadorA().comprarUnidad(catapulta);
            tableroView.setOnMousePressed(new PosicionarUnidadEvent(catapulta, tablero, tableroView));
        } catch (RuntimeException e) {
            System.out.println("Dinero insuficiente");
        }
    }
}
