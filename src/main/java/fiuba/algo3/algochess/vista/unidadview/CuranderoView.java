package fiuba.algo3.algochess.vista.unidadview;

import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.Sprite;
import fiuba.algo3.algochess.vista.TableroView;

public class CuranderoView extends UnidadView {

    public CuranderoView(Unidad unidad, TableroView tableroView) {
        super(unidad, tableroView, new Sprite("src/main/resources/curandero.png", 0, 0, 32, 32));
    }

    @Override
    public void setFrameUp() {

    }

    @Override
    public void setFrameDown() {

    }

    @Override
    public void setFrameLeft() {

    }

    @Override
    public void setFrameRight() {

    }
}
