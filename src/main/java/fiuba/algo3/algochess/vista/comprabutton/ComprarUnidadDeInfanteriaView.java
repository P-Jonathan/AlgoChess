package fiuba.algo3.algochess.vista.comprabutton;

import fiuba.algo3.algochess.controlador.buttonHandler.ComprarUnidadInfanteriaHandler;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.vista.ShopView;
import fiuba.algo3.algochess.vista.TableroView;
import fiuba.algo3.algochess.vista.Sprite;

public class ComprarUnidadDeInfanteriaView extends CompraDeUnidadView {
    public ComprarUnidadDeInfanteriaView(Tablero tablero, TableroView tableroView, ShopView shopView) {
        super(new ComprarUnidadInfanteriaHandler(tablero, tableroView, shopView), tableroView,
                new Sprite("src/main/resources/caras.png", 0, 0, 27, 19, 50, 50)
        );
        this.setText("Unidad de Infanteria");
    }
}
