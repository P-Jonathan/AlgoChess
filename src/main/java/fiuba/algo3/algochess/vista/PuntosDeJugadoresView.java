package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.modelo.tablero.Jugador;
import fiuba.algo3.algochess.modelo.unidades.Observer;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class PuntosDeJugadoresView extends HBox implements Observer {
    private Jugador jugadorA;
    private Jugador jugadorB;

    private Label l1;
    private Label l2;

    public PuntosDeJugadoresView(Jugador jugadorA, Jugador jugadorB) {
        this.jugadorA = jugadorA;
        this.jugadorB = jugadorB;

        jugadorA.addObserver(this);
        jugadorB.addObserver(this);

        l1 = new Label("Puntos del jugador A: " + jugadorA.getPuntos());
        l2 = new Label("Puntos del jugador B: " + jugadorB.getPuntos());

        l1.setMinWidth(320);
        l2.setMinWidth(320);

        l1.setTextAlignment(TextAlignment.CENTER);
        l2.setTextAlignment(TextAlignment.CENTER);

        VBox verticalBox = new VBox();

        verticalBox.getChildren().add(l1);
        verticalBox.getChildren().add(l2);
        verticalBox.setPadding(new Insets(0,0,20,0));

        getChildren().add(verticalBox);
    }

    @Override
    public void change() {
        l1.setText("Puntos del jugador A: " + jugadorA.getPuntos());
        l2.setText("Puntos del jugador B: " + jugadorB.getPuntos());
    }
}
