package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.List;

public class Manejador {
    private static final Manejador instancia = new Manejador();

    private Unidad unidad = null;
    private Node unidadView;
    private List<Pane> panes;
    private TableroView tableroView;

    private Manejador() {}

    public static Manejador getInstancia() { return instancia; }

    public void agregarUnidad(Unidad unidad, Node unidadView, TableroView tableroView) {
        if(this.unidad != null){
            atacar(unidad);
        } else {
            this.unidad = unidad;
            this.unidadView = unidadView;
            this.tableroView = tableroView;

            panes = tableroView.getPanesAdyacentes(unidad);
            for (Pane pane : panes) {
                pane.setStyle("-fx-background-color: #79f281");
            }
        }
    }

    public void update() {
        for(Pane pane : panes){
            pane.setStyle("-fx-background-color: #FFFFFF");
            pane.setOnMouseClicked(new MovimientoControllerNull());
        }

        tableroView.addViewOnMap(unidadView, unidad.getX(), unidad.getY());
        unidad = null;
    }

    public void atacar(Unidad unidad) {
        if(this.unidad != unidad) {
            this.unidad.usarHabilidad(unidad);
            System.out.println(unidad.getVida());
            update();
        }
    }
}
