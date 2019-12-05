package fiuba.algo3.algochess.controlador.buttonHandler;

import fiuba.algo3.algochess.controlador.PosicionarUnidadEvent;
import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public abstract class CompraDeUnidadController implements EventHandler<ActionEvent> {
    protected TableroView tableroView;
    protected Tablero tablero;

    public CompraDeUnidadController(Tablero tablero, TableroView tableroView) {
        this.tableroView = tableroView;
        this.tablero = tablero;
    }

    protected abstract Unidad comprarUnidad();

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            Unidad unidad = comprarUnidad();
            AdministradorDeTurnos.getInstancia().jugadorActual().comprarUnidad(unidad);
            tableroView.setOnMousePressed(new PosicionarUnidadEvent(unidad, tablero, tableroView));
        } catch (RuntimeException e) {
            System.out.println("Dinero insuficiente");
        }
    }
}
