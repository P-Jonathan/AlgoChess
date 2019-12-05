package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.vista.comprabutton.CompraDeCatapultaView;
import fiuba.algo3.algochess.vista.comprabutton.CompraDeCuranderoView;
import fiuba.algo3.algochess.vista.comprabutton.CompraDeJineteView;
import fiuba.algo3.algochess.vista.comprabutton.ComprarUnidadDeInfanteriaView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ShopView extends Group {
    public int width = 320;
    public int height = 640;

    private GridPane table;
    private Pane[] panes;

    public ShopView(Tablero tablero, TableroView tableroView) {
        GridPane table = new GridPane();
        panes = new Pane[7];

        for (int i = 0; i < 7; i++) {
            Pane v = new Pane();
            v.setMinHeight(50);
            v.setMinWidth(320);
            v.setStyle("-fx-background-color: #FFFFFF");
            panes[i] = v;
            table.add(v , 0, i);
        }

        table.setVgap(1);
        table.setHgap(1);
        table.setStyle("-fx-background-color: #000000");

        addView(table);

        addViewOnMap(new TurnosView(tablero), 0);
        addViewOnMap(new PuntosDeJugadoresView(tablero.getJugadorA(), "Puntos del jugador A: "), 1);
        addViewOnMap(new PuntosDeJugadoresView(tablero.getJugadorB(), "Puntos del jugador B: "), 2);
        addViewOnMap(new ComprarUnidadDeInfanteriaView(tablero, tableroView, this), 3);
        addViewOnMap(new CompraDeJineteView(tablero, tableroView, this), 4);
        addViewOnMap(new CompraDeCuranderoView(tablero, tableroView, this), 5);
        addViewOnMap(new CompraDeCatapultaView(tablero, tableroView, this), 6);
    }

    public void addViewOnMap(Node view, int x) {
        panes[x].getChildren().remove(view);
        panes[x].getChildren().add(0, view);
    }

    public void addView(Node view) {
        this.getChildren().remove(view);
        this.getChildren().add(view);
    }
}
