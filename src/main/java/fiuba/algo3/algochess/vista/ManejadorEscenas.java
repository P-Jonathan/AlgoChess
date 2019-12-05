package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
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
        tableroView = new TableroView(tablero);

        ShopView shop = new ShopView(tablero, tableroView);

        AdministradorDeTurnos.getInstancia().addObserver(this);

        stage.setScene(new Scene(new HBox(tableroView, shop)));
    }

    @Override
    public void change() {
        if(AdministradorDeTurnos.getInstancia().finalizaronCompras()) {
            ButtonPasarTurno boton = new ButtonPasarTurno();
            stage.setScene(new Scene(new HBox(tableroView, boton)));
        }
    }
}
