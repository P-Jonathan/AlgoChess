package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.controlador.buttonHandler.ComprarUnidadInfanteriaHandler;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

public class ButtonComprarUnidadInfanteria extends Button {

    public ButtonComprarUnidadInfanteria(Tablero tablero, TableroView tableroView) {
        super();
        this.setText("Comprar Unidad de Infanteria");
        this.setTextAlignment(TextAlignment.CENTER);
        this.setOnAction(new ComprarUnidadInfanteriaHandler(tablero, tableroView));
    }

}
