package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.controlador.movecontroller.MovimientoAdelanteController;
import fiuba.algo3.algochess.controlador.movecontroller.MovimientoAtrasController;
import fiuba.algo3.algochess.controlador.movecontroller.MovimientoDerechaController;
import fiuba.algo3.algochess.controlador.movecontroller.MovimientoIzquierdaController;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.vista.unidadview.UnidadView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class TableroView extends Group {
    public int width = 20;
    public int heigth = 20;

    private int tileWidth = 32;
    private int tileHeigth = 32;

    private GridPane table;

    private Pane[][] panes;

    public TableroView() {
        GridPane table = new GridPane();
        panes = new Pane[width * tileWidth][heigth * tileHeigth];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                Pane v = new Pane();
                v.setMinHeight(tileHeigth);
                v.setMinWidth(tileWidth);
                panes[i][j] = v;
                table.add(v, i, j);
            }
        }

        table.setVgap(0);
        table.setHgap(0);
        table.setGridLinesVisible(true);
        table.setBackground(
                new Background(
                        new BackgroundImage(
                                new Image("background.png"),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.DEFAULT,
                                BackgroundSize.DEFAULT)
                ));
        this.addView(table);
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeigth() {
        return tileHeigth;
    }

    public void addViewOnMap(Node view, int x, int y) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                try {
                    panes[i][j].getChildren().remove(view);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
        panes[x][y].getChildren().add(0, view);
    }


    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void updateView(Node view) {
        getChildren().remove(view);
        getChildren().add(view);
    }

    public ArrayList<Pane> getPanesAdyacentes(Unidad unidad, UnidadView unidadView) {
        ArrayList<Pane> panesAdyacentes = new ArrayList<Pane>();

        if (unidad.getY() + 1 < getHeigth()) {
            panes[unidad.getX()][unidad.getY() + 1].setOnMouseClicked(new MovimientoAdelanteController(unidad, unidadView));
            panesAdyacentes.add(panes[unidad.getX()][unidad.getY() + 1]);
        }

        if (unidad.getY() - 1 >= 0) {
            panes[unidad.getX()][unidad.getY() - 1].setOnMouseClicked(new MovimientoAtrasController(unidad, unidadView));
            panesAdyacentes.add(panes[unidad.getX()][unidad.getY() - 1]);
        }

        if (unidad.getX() + 1 <= getTileWidth()) {
            panes[unidad.getX() + 1][unidad.getY()].setOnMouseClicked(new MovimientoDerechaController(unidad, unidadView));
            panesAdyacentes.add(panes[unidad.getX() + 1][unidad.getY()]);
        }

        if (unidad.getX() - 1 >= 0) {
            panes[unidad.getX() - 1][unidad.getY()].setOnMouseClicked(new MovimientoIzquierdaController(unidad, unidadView));
            panesAdyacentes.add(panes[unidad.getX() - 1][unidad.getY()]);
        }

        panesAdyacentes.forEach(pane -> pane.setStyle("-fx-background-color: #79f281"));

        return panesAdyacentes;
    }

    public Pane paneActual(Unidad unidad) {
        panes[unidad.getX()][unidad.getY()].setStyle("-fx-background-color: #46b1f2");

        return panes[unidad.getX()][unidad.getY()];
    }

    //public void prepararParaAccion(Unidad unidad) {  }
}
