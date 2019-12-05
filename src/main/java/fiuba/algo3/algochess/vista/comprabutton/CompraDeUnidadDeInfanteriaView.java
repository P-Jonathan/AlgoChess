package fiuba.algo3.algochess.vista.comprabutton;

import fiuba.algo3.algochess.controlador.buttonHandler.ComprarUnidadInfanteriaHandler;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.vista.TableroView;
import fiuba.algo3.algochess.vista.Sprite;

public class CompraDeUnidadDeInfanteriaView extends CompraDeUnidadView {
    public CompraDeUnidadDeInfanteriaView(Tablero tablero, TableroView tableroView) {
        super(new ComprarUnidadInfanteriaHandler(tablero, tableroView), tableroView,
                new Sprite("src/main/resources/caras.png", 0, 0, 27, 19, 50, 50)
        );
        this.setText("Unidad de Infanteria");
    }
}
