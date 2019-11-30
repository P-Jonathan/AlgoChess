package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.controlador.buttonHandler.ComprarJineteHandler;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

public class ButtonComprarJinete extends Button {

    public ButtonComprarJinete(Tablero tablero, TableroView tableroView) {
        super();
        this.setText("Comprar Jinete");
        this.setTextAlignment(TextAlignment.CENTER);
        this.setOnAction(new ComprarJineteHandler(tablero, tableroView));
    }

}
