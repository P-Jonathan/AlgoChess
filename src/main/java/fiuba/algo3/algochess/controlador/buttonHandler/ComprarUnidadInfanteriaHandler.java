package fiuba.algo3.algochess.controlador.buttonHandler;

import fiuba.algo3.algochess.controlador.PosicionarUnidadEvent;
import fiuba.algo3.algochess.modelo.ManejadorCompras;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;
import fiuba.algo3.algochess.vista.ReproductorMusica;
import fiuba.algo3.algochess.vista.TableroView;
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
            ManejadorCompras.getInstancia().jugadorComprando().comprarUnidad(unidadDeInfanteria);
            tableroView.setOnMousePressed(new PosicionarUnidadEvent(unidadDeInfanteria, tablero, tableroView));
        } catch (RuntimeException e) {
            System.out.println("Dinero insuficiente");
        }
    }
}
