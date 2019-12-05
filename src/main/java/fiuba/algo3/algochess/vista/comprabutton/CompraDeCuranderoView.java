package fiuba.algo3.algochess.vista.comprabutton;

import fiuba.algo3.algochess.controlador.buttonHandler.ComprarCuranderoHandler;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.vista.TableroView;
import fiuba.algo3.algochess.vista.Sprite;

public class CompraDeCuranderoView extends CompraDeUnidadView {
    public CompraDeCuranderoView(Tablero tablero, TableroView tableroView) {
        super(new ComprarCuranderoHandler(tablero, tableroView), tableroView,
                new Sprite("src/main/resources/caras.png", 12, 0, 27, 19, 50, 50)
        );
        this.setText("Curandero");
    }
}
