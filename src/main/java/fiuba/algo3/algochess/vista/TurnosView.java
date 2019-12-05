package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Observer;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TurnosView extends HBox implements Observer {
    private final static String JUGANDO_J1 = "Jugador 1 (Norte)";
    private final static String JUGANDO_J2 = "Jugador 2 (Sur)";

    private Tablero tablero;
    private Label label;

    public TurnosView(Tablero tablero) {
        this.tablero = tablero;

        if(AdministradorDeTurnos.getInstancia().jugadorActual() == tablero.getJugadorA()) {
            this.label = new Label("Jugando ahora: " + JUGANDO_J1);
            label.setStyle("-fx-font-weight: bold");
        } else {
            this.label = new Label("Jugando ahora: " + JUGANDO_J2);
            label.setStyle("-fx-font-weight: bold");
        }

        this.getChildren().add(this.label);
        AdministradorDeTurnos.getInstancia().addObserver(this);
    }

    public void update() {
        if(AdministradorDeTurnos.getInstancia().jugadorActual() == tablero.getJugadorA()) {
            this.label.setText("Jugando ahora: " + JUGANDO_J1);
            label.setStyle("-fx-font-weight: bold");
        } else {
            this.label.setText("Jugando ahora: " + JUGANDO_J2);
            label.setStyle("-fx-font-weight: bold");
        }
    }

    @Override
    public void change() {
        update();
    }
}
