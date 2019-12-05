package fiuba.algo3.algochess.vista.comprabutton;

import fiuba.algo3.algochess.controlador.buttonHandler.ComprarCatapultaHandler;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.vista.TableroView;
import fiuba.algo3.algochess.vista.Sprite;

public class CompraDeCatapultaView extends CompraDeUnidadView {
    public CompraDeCatapultaView(Tablero tablero, TableroView tableroView) {
        super(new ComprarCatapultaHandler(tablero, tableroView), tableroView,
                new Sprite("src/main/resources/caras.png", 6, 0, 27, 19, 50, 50)
        );
        this.setText("Catapulta");
    }
}
