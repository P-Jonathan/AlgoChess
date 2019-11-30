package fiuba.algo3.AlgoChess.controlador.buttonHandler;

import fiuba.algo3.AlgoChess.controlador.PosicionarUnidadEvent;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import fiuba.algo3.AlgoChess.modelo.unidades.Jinete;
import fiuba.algo3.AlgoChess.vista.ReproductorMusica;
import fiuba.algo3.AlgoChess.vista.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
            tablero.getJugadorA().comprarUnidad(jinete);
            tableroView.setOnMousePressed(new PosicionarUnidadEvent(jinete, tablero, tableroView));
        } catch (RuntimeException e) {
            System.out.println("Dinero insuficiente");
        }
    }
}
