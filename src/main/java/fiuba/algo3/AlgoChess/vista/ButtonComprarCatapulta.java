package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.controlador.buttonHandler.ComprarCatapultaHandler;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

public class ButtonComprarCatapulta extends Button {

    public ButtonComprarCatapulta(Tablero tablero, TableroView tableroView) {
        super();
        this.setText("Comprar Catapulta");
        this.setTextAlignment(TextAlignment.CENTER);
        this.setOnAction(new ComprarCatapultaHandler(tablero, tableroView));
    }

}
