package fiuba.algo3.AlgoChess.vista;

import fiuba.algo3.AlgoChess.modelo.tablero.Jugador;
import fiuba.algo3.AlgoChess.modelo.tablero.Posicion;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import fiuba.algo3.AlgoChess.modelo.unidades.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage) {
        theStage.setTitle("Prueba AlgoChess");

        Tablero tablero = new Tablero();
        TableroView tableroView = new TableroView();

        Jugador jugadorA = tablero.getJugadorA();

        Unidad unidadInfanteria = new UnidadDeInfanteria();
        jugadorA.comprarUnidad(unidadInfanteria);
        tablero.posicionarUnidad(unidadInfanteria, new Posicion(2,2));
        new UnidadViewInfanteria(tableroView, unidadInfanteria);

        Unidad jinete = new Jinete();
        jugadorA.comprarUnidad(jinete);
        tablero.posicionarUnidad(jinete, new Posicion(5,5));
        new JineteView(tableroView, jinete);

        Unidad catapulta = new Catapulta();
        jugadorA.comprarUnidad(catapulta);
        tablero.posicionarUnidad(catapulta, new Posicion(0,0));
        new CatapultaView(tableroView, catapulta);

        Unidad curandero = new Curandero();
        jugadorA.comprarUnidad(curandero);
        tablero.posicionarUnidad(curandero, new Posicion(7,7));
        new CuranderoView(tableroView, curandero);



        VBox vb = new VBox(tableroView);

        Scene theScene = new Scene(vb);
        theStage.setScene(theScene);
        theStage.show();
    }
}
