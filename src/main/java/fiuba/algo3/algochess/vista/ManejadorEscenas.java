package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Observer;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManejadorEscenas implements Observer {
    private Stage stage;
    private HBox escena1,escena2;
    private Tablero tablero;
    private TableroView tableroView;

    public ManejadorEscenas(Stage stage) {
        this.stage = stage;

        tablero = new Tablero();
        tableroView = new TableroView(tablero);

        escena1 = new HBox(new ShopView(tablero, tableroView));
        escena2 = new HBox(new ButtonPasarTurno());
        AdministradorDeTurnos.getInstancia().addObserver(this);

        stage.setScene(new Scene(new HBox(new Menu(tablero,this))));
    }

    @Override
    public void change() {
    	stage.setScene(new Scene(new HBox(tableroView,escena1)));
    	escena1 = escena2;
    }
}
