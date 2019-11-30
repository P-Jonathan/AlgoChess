package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.controlador.buttonHandler.ComprarCuranderoHandler;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;


public class ButtonComprarCurandero extends Button {

    public ButtonComprarCurandero(Tablero tablero, TableroView tableroView) {
        super();
        this.setText("Comprar Curandero");
        this.setTextAlignment(TextAlignment.CENTER);
        this.setOnAction(new ComprarCuranderoHandler(tablero, tableroView));
    }

}
