package fiuba.algo3.algochess.modelo;

import fiuba.algo3.algochess.modelo.tablero.Jugador;
import fiuba.algo3.algochess.modelo.unidades.Observable;

public class ManejadorCompras extends Observable {
    private static final ManejadorCompras instancia = new ManejadorCompras();

    private Jugador comprando;
    private Jugador enEspera;

    private ManejadorCompras() {}

    public static ManejadorCompras getInstancia() {
        return instancia;
    }

    public void comprando(Jugador jugador) {
        comprando = jugador;
    }

    public void enEspera(Jugador jugador) {
        enEspera = jugador;
    }

    public void cambiarTurnos() {
        if(comprando.getPuntos() == 0 && enEspera.getPuntos() == 0)
            notifyObservers();

        if(enEspera.getPuntos() >= 1) {
            Jugador aux = comprando;
            comprando = enEspera;
            enEspera = aux;
        }
    }

    public Jugador jugadorComprando() {
        return comprando;
    }
}
