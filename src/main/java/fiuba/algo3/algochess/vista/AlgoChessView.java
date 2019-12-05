package fiuba.algo3.algochess.vista;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algochess.controlador.ChatProxyPrintStream;
import fiuba.algo3.algochess.modelo.AdministradorDeTurnos;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Observer;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlgoChessView implements Observer {
    private Stage stage;
    private List<VBox> escenas = new ArrayList<>();
    private TableroView tableroView;

    public AlgoChessView(Stage stage) {
        this.stage = stage;

        Tablero tablero = new Tablero();
        tableroView = new TableroView(tablero);


        // Creo el chat y redirecciono la salida estandar hacia este utilizando un proxy
        ChatBox chat = new ChatBox();
        System.setOut(new ChatProxyPrintStream(System.out, chat));

        AdministradorDeTurnos.getInstancia().addObserver(this);

        Menu menu = new Menu(tablero, this);

        ShopView shop = new ShopView(tablero, tableroView);
        shop.addView(chat);
        escenas.add(new VBox(shop));
        escenas.add(new VBox(new ButtonPasarTurno(), chat));

        stage.setScene(new Scene(new HBox(menu)));
    }

    @Override
    public void change() {
        stage.setScene(new Scene(new HBox(tableroView, escenas.get(0))));
        tableroView.setDisable(false);
        escenas.remove(0);
    }
}
