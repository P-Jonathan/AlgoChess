package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class TableroView extends Group {
    public int width = 20;
    public int heigth = 20;

    private int tileWidth = 32;
    private int tileHeigth = 32;

    private GridPane table;


    private Pane[][] panes;

    public TableroView() {
        GridPane table = new GridPane();
        panes = new Pane[width*tileWidth][heigth*tileHeigth];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                Pane v = new Pane();
                v.setMinHeight(tileHeigth);
                v.setMinWidth(tileWidth);
                v.setStyle("-fx-background-color: #FFFFFF");
                panes[i][j] = v;
                table.add(v , i, j);
            }
        }

        table.setVgap(1);
        table.setHgap(1);
        table.setStyle("-fx-background-color: #000000");

        this.addView(table);
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

    public void accionCon(Unidad unidad, Node unidadView) {
        ArrayList<Pane> panesAdyacentes = new ArrayList<Pane>();

        panesAdyacentes.add(panes[unidad.getX() + 1][unidad.getY()]);
        panesAdyacentes.add(panes[unidad.getX() - 1][unidad.getY()]);
        panesAdyacentes.add(panes[unidad.getX()][unidad.getY() + 1]);
        panesAdyacentes.add(panes[unidad.getX()][unidad.getY() - 1]);

        for(Pane paneAdyacente : panesAdyacentes){
            paneAdyacente.setStyle("-fx-background-color: #79f281");
        }

        panes[unidad.getX()][unidad.getY() + 1].setOnMouseClicked(e-> {
            unidad.moverHaciaAdelante();
            addViewOnMap(unidadView, unidad.getX(), unidad.getY());
            for(Pane paneAdyacente : panesAdyacentes){
                paneAdyacente.setStyle("-fx-background-color: #FFFFFF");
                paneAdyacente.setOnMouseClicked(e2-> {});
            }
        });

        panes[unidad.getX()][unidad.getY() - 1].setOnMouseClicked(e-> {
            unidad.moverHaciaAtras();
            addViewOnMap(unidadView, unidad.getX(), unidad.getY());
            for(Pane paneAdyacente : panesAdyacentes){
                paneAdyacente.setStyle("-fx-background-color: #FFFFFF");
                paneAdyacente.setOnMouseClicked(e2-> {});
            }
        });

        panes[unidad.getX() + 1][unidad.getY()].setOnMouseClicked(e-> {
            unidad.moverALaDerecha();
            addViewOnMap(unidadView, unidad.getX(), unidad.getY());
            for(Pane paneAdyacente : panesAdyacentes){
                paneAdyacente.setStyle("-fx-background-color: #FFFFFF");
                paneAdyacente.setOnMouseClicked(e2-> {});
            }
        });

        panes[unidad.getX() - 1][unidad.getY()].setOnMouseClicked(e-> {
            unidad.moverALaIzquierda();
            addViewOnMap(unidadView, unidad.getX(), unidad.getY());
            for(Pane paneAdyacente : panesAdyacentes){
                paneAdyacente.setStyle("-fx-background-color: #FFFFFF");
                paneAdyacente.setOnMouseClicked(e2-> {});
            }
        });
    }

}
