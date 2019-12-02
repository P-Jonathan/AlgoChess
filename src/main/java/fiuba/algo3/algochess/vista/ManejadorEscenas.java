package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.modelo.ManejadorCompras;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Observer;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ManejadorEscenas implements Observer {
    private Stage stage;

    private Tablero tablero;
    private TableroView tableroView;

    public ManejadorEscenas(Stage stage) {
        this.stage = stage;

        tablero = new Tablero();
        tableroView = new TableroView();

        Shop shop = new Shop(tablero, tableroView);

        ManejadorCompras.getInstancia().addObserver(this);

        stage.setScene(new Scene(new HBox(tableroView, shop)));
    }

    @Override
    public void change() {
        stage.setScene(new Scene(new HBox(tableroView)));
    }
}