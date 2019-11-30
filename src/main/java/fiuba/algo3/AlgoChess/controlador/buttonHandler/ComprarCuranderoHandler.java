package fiuba.algo3.AlgoChess.controlador.buttonHandler;

import fiuba.algo3.AlgoChess.controlador.PosicionarUnidadEvent;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import fiuba.algo3.AlgoChess.modelo.unidades.Curandero;
import fiuba.algo3.AlgoChess.vista.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComprarCuranderoHandler implements EventHandler<ActionEvent> {
    private Tablero tablero;
    private TableroView tableroView;

    public ComprarCuranderoHandler(Tablero tablero, TableroView tableroView) {
        this.tablero = tablero;
        this.tableroView = tableroView;
    }

    public void handle(ActionEvent event) {
        try{
            Curandero curandero = new Curandero();
            tablero.getJugadorA().comprarUnidad(curandero);
            tableroView.setOnMousePressed(new PosicionarUnidadEvent(curandero, tablero, tableroView));
        } catch (RuntimeException e) {
            System.out.println("Dinero insuficiente");
        }
    }
}
