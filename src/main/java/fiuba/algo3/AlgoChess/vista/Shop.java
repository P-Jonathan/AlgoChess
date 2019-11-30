package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Shop extends Group {
    public int width = 320;
    public int height = 640;


    private GridPane table;
    private Pane[] panes;

    public Shop(Tablero tablero) {
        GridPane table = new GridPane();
        panes = new Pane[4];

        for (int i = 0; i < 4; i++) {
            Pane v = new Pane();
            v.setMinHeight(160);
            v.setMinWidth(320);
            v.setStyle("-fx-background-color: #FFFFFF");
            panes[i] = v;
            table.add(v , 0, i);
        }

        table.setVgap(1);
        table.setHgap(1);
        table.setStyle("-fx-background-color: #000000");

        this.addView(table);
    }

    public void addViewOnMap(Node view, int x) {
        panes[x].getChildren().add(0, view);
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }
}
