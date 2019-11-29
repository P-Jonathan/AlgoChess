package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.controlador.MovimientoControllerNull;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Manejador {
    private static final Manejador instancia = new Manejador();

    private Unidad autor;
    private List<Pane> panes;

    private Manejador() {
        autor = null;
    }

    public static Manejador getInstancia() { return instancia; }

    public void agregarUnidad(Unidad unidad) {
        atacar(unidad);
    }

    public void agregarUnidad(Unidad unidad, ArrayList<Pane> panes) {
        this.autor = unidad;
        this.panes = panes;
    }

    public void resetPanes() {
        panes.stream().forEach(pane -> {
            pane.setStyle("-fx-background-color: #FFFFFF");
            pane.setOnMouseClicked(new MovimientoControllerNull());
        });

        autor = null;
    }

    public void atacar(Unidad unidad) {
        if(autor != unidad) {
            autor.usarHabilidad(unidad);
            resetPanes();
        }
    }

    public boolean tieneAutor() {
        return autor != null;
    }
}
