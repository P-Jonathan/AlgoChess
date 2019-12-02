package fiuba.algo3.algochess.controlador.buttonHandler;

import fiuba.algo3.algochess.controlador.PosicionarUnidadEvent;
import fiuba.algo3.algochess.modelo.ManejadorCompras;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Jinete;
import fiuba.algo3.algochess.vista.ReproductorMusica;
import fiuba.algo3.algochess.vista.TableroView;
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
            ManejadorCompras.getInstancia().jugadorComprando().comprarUnidad(jinete);
            tableroView.setOnMousePressed(new PosicionarUnidadEvent(jinete, tablero, tableroView));
        } catch (RuntimeException e) {
            System.out.println("Dinero insuficiente");
        }
    }
}
