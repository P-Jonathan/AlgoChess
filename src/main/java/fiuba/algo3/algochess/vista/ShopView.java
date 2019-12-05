package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.controlador.ChatProxyPrintStream;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.vista.comprabutton.CompraDeCatapultaView;
import fiuba.algo3.algochess.vista.comprabutton.CompraDeCuranderoView;
import fiuba.algo3.algochess.vista.comprabutton.CompraDeJineteView;
import fiuba.algo3.algochess.vista.comprabutton.ComprarUnidadDeInfanteriaView;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class ShopView extends VBox {
    private static final int DEFAULT_SHOP_WITDH = 320;
    private static final int DEFAULT_SHOP_HEIGHT = 400;

    public ShopView(Tablero tablero, TableroView tableroView) {

        addView(new PuntosDeJugadoresView(tablero.getJugadorA(), tablero.getJugadorB()));
        addView(new ComprarUnidadDeInfanteriaView(tablero, tableroView, this));
        addView(new CompraDeJineteView(tablero, tableroView, this));
        addView(new CompraDeCuranderoView(tablero, tableroView, this));
        addView(new CompraDeCatapultaView(tablero, tableroView, this));
    }

    public void addView(Node view) {
        this.getChildren().remove(view);
        this.getChildren().add(view);
    }
}
