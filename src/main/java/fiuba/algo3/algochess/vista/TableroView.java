package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.controlador.MovimientoAdelanteController;
import fiuba.algo3.algochess.controlador.MovimientoAtrasController;
import fiuba.algo3.algochess.controlador.MovimientoDerechaController;
import fiuba.algo3.algochess.controlador.MovimientoIzquierdaController;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
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
                //v.setStyle("-fx-background-color: #FFFFFF");
                panes[i][j] = v;
                table.add(v, i, j);
            }
        }

        table.setVgap(1);
        table.setHgap(1);
        //table.setStyle("-fx-background-color: #000000");
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

    public void updateView(Node view, int x, int y) {
        removeView(view);
        addViewOnMap(view, x, y);
    }

    public void addViewOnMap(Node view, int x, int y) {
        panes[x][y].getChildren().add(0, view);
    }

    public void removeView(Node view) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                try {
                    panes[i][j].getChildren().remove(view);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
    }


    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void updateView(Node view) {
        getChildren().remove(view);
        getChildren().add(view);
    }

    private boolean paneVacio(Pane pane) {
        return pane.getChildren().isEmpty();
    }

    public ArrayList<Pane> getPanesAdyacentes(Unidad unidad) {
        ArrayList<Pane> panesAdyacentes = new ArrayList<Pane>();

        try {
            if(paneVacio(paneAdelante(unidad))) {
                paneAdelante(unidad).setOnMouseClicked(new MovimientoAdelanteController(unidad));
                panesAdyacentes.add(paneAdelante(unidad));
            }
        } catch(Exception e) {}

        try {
            if(paneVacio(paneAtras(unidad))) {
                paneAtras(unidad).setOnMouseClicked(new MovimientoAtrasController(unidad));
                panesAdyacentes.add(paneAtras(unidad));
            }
        } catch(Exception e) {}

        try {
            if(paneVacio(paneDerecha(unidad))) {
                paneDerecha(unidad).setOnMouseClicked(new MovimientoDerechaController(unidad));
                panesAdyacentes.add(paneDerecha(unidad));
            }
        } catch(Exception e) {}

        try {
            if(paneVacio(paneIzquierda(unidad))) {
                paneIzquierda(unidad).setOnMouseClicked(new MovimientoIzquierdaController(unidad));
                panesAdyacentes.add(paneIzquierda(unidad));
            }
        } catch(Exception e) {}

        panesAdyacentes.stream().forEach(pane -> pane.setStyle("-fx-background-color: #74d575"));

        return panesAdyacentes;
    }

    public Pane paneActual(Unidad unidad) {
        panes[unidad.getX()][unidad.getY()].setStyle("-fx-background-color: #46b1f2");

        return panes[unidad.getX()][unidad.getY()];
    }

    public Pane paneAdelante(Unidad unidad) {
        return panes[unidad.getX()][unidad.getY() + 1];
    }

    public Pane paneAtras(Unidad unidad) {
        return panes[unidad.getX()][unidad.getY() - 1];
    }

    public Pane paneDerecha(Unidad unidad) {
        return panes[unidad.getX() + 1][unidad.getY()];
    }

    public Pane paneIzquierda(Unidad unidad) {
        return panes[unidad.getX() - 1][unidad.getY()];
    }
}
