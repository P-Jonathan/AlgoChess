package fiuba.algo3.algochess.vista;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algochess.controlador.ChatProxyPrintStream;
import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Observer;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlgoChessView implements Observer {
        private Stage stage;
        private List<HBox> escenas = new ArrayList<HBox>();
        private Tablero tablero;
        private TableroView tableroView;

        public AlgoChessView(Stage stage) {
            this.stage = stage;

            tablero = new Tablero();
            tableroView = new TableroView(tablero);

            Menu menu = new Menu(tablero,this);

            escenas.add(new HBox(new ShopView(tablero, tableroView)));
            escenas.add(new HBox(new ButtonPasarTurno()));

            AdministradorDeTurnos.getInstancia().addObserver(this);

            stage.setScene(new Scene(new HBox(menu)));
        }

        @Override
        public void change() {
            stage.setScene(new Scene(new HBox(tableroView,escenas.get(0))));
            tableroView.setDisable(false);
            escenas.remove(0);
        }
    }
}
