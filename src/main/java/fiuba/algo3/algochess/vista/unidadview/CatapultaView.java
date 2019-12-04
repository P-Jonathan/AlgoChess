package fiuba.algo3.algochess.vista.unidadview;

import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.Sprite;
import fiuba.algo3.algochess.vista.TableroView;

public class CatapultaView extends UnidadView {

    public CatapultaView(Unidad unidad, TableroView tableroView) {
        super(unidad, tableroView, new Sprite("src/main/resources/catapulta.png", 4, 0, 32, 32));
    }
}
