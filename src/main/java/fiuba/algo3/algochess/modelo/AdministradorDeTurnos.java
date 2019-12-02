package fiuba.algo3.algochess.modelo;

import fiuba.algo3.algochess.modelo.tablero.Jugador;
import fiuba.algo3.algochess.modelo.unidades.Observable;

public class AdministradorDeTurnos extends Observable {
    private static final AdministradorDeTurnos instancia = new AdministradorDeTurnos();

    private Jugador actual;
    private Jugador enEspera;

    private AdministradorDeTurnos() {}

    public static AdministradorDeTurnos getInstancia() {
        return instancia;
    }

    public void actual(Jugador jugador) {
        actual = jugador;
    }

    public void enEspera(Jugador jugador) {
        enEspera = jugador;
    }

    public void cambiarTurnosCompras() {
        if(actual.getPuntos() == 0 && enEspera.getPuntos() == 0)
            notifyObservers();

        if(enEspera.getPuntos() >= 1)
            cambiarTurnos();
    }

    public void cambiarTurnos() {
        Jugador aux = actual;
        actual = enEspera;
        enEspera = aux;
    }

    public Jugador jugadorActual() {
        return actual;
    }

    public boolean turnoDe(Jugador jugador) { return actual == jugador; }
}
