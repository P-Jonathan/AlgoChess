package fiuba.algo3.AlgoChess.controlador.buttonHandler;

import fiuba.algo3.AlgoChess.controlador.PosicionarUnidadEvent;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import fiuba.algo3.AlgoChess.modelo.unidades.UnidadDeInfanteria;
import fiuba.algo3.AlgoChess.vista.ReproductorMusica;
import fiuba.algo3.AlgoChess.vista.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
            tablero.getJugadorA().comprarUnidad(unidadDeInfanteria);
            tableroView.setOnMousePressed(new PosicionarUnidadEvent(unidadDeInfanteria, tablero, tableroView));
        } catch (RuntimeException e) {
            System.out.println("Dinero insuficiente");
        }
    }
}
