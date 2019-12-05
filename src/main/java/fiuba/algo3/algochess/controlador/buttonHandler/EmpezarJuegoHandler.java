package fiuba.algo3.algochess.controlador.buttonHandler;

import fiuba.algo3.algochess.modelo.unidades.Observable;
import fiuba.algo3.algochess.vista.ManejadorEscenas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EmpezarJuegoHandler extends Observable implements EventHandler<ActionEvent> {
	ManejadorEscenas manejador;
	
	public EmpezarJuegoHandler(ManejadorEscenas manejador) {
		addObserver(manejador);
	}

	@Override
	public void handle(ActionEvent event) {
		notifyObservers();
	}

}
