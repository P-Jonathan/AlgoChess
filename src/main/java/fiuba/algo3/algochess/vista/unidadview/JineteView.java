package fiuba.algo3.algochess.vista.unidadview;

import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.Sprite;
import fiuba.algo3.algochess.vista.TableroView;

public class JineteView extends UnidadView {
    public JineteView(Unidad unidad, TableroView tableroView) {
        super(unidad, tableroView, new Sprite("src/main/resources/jinete.png"));
    }

    @Override
    public void setFrameUp() {
        this.setFrame(0, 0);
    }

    @Override
    public void setFrameDown() {
        this.setFrame(4, 0);
    }

    @Override
    public void setFrameLeft() {
        this.setFrame(3, 1);
    }

    @Override
    public void setFrameRight() {
        this.setFrame(2, 0);
    }
}
