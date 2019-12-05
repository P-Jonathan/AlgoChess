package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.modelo.tablero.Jugador;
import fiuba.algo3.algochess.modelo.unidades.Observer;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class PuntosDeJugadoresView extends HBox implements Observer {
    private Jugador jugador;
    private String texto;
    private Label label;

    public PuntosDeJugadoresView(Jugador jugador, String texto) {
        this.jugador = jugador;
        this.texto = texto;
        this.label = new Label(texto + jugador.getPuntos());

        jugador.addObserver(this);

        this.getChildren().add(label);
    }

    @Override
    public void change() {
        label.setText(texto + jugador.getPuntos());
    }
}
