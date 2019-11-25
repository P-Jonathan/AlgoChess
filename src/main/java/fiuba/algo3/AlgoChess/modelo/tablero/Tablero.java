package fiuba.algo3.AlgoChess.modelo.tablero;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private static final String NOMBRE_DEFAULT_BANDO_A = "A";
    private static final String NOMBRE_DEFAULT_BANDO_B = "B";
    private static final int FILAS = 20;
    private static final int COLUMNAS = 20;

    private Jugador jugadorA;
    private Jugador jugadorB;
    private Jugador jugadorActual;
    private Jugador jugadorEnEspera;

    private List<Casilla> casillas;

    public Tablero() {
        jugadorA = new Jugador(NOMBRE_DEFAULT_BANDO_A);
        jugadorB = new Jugador(NOMBRE_DEFAULT_BANDO_B);
        jugadorActual = jugadorA;
        jugadorEnEspera = jugadorB;
        setCasillasVacias();
    }


    public Tablero(String bandoA, String bandoB) {
        jugadorA = new Jugador(bandoA);
        jugadorB = new Jugador(bandoB);
        jugadorActual = jugadorA;
        jugadorEnEspera = jugadorB;
        setCasillasVacias();
    }

    private void setCasillasVacias() {
        casillas = new ArrayList<>();
        inicializarFilasDeCasillas(0, FILAS/2, jugadorA);
        inicializarFilasDeCasillas(FILAS / 2, FILAS, jugadorB);
    }

    private void inicializarFilasDeCasillas(int filaInicial, int filaFinal, Jugador propietario) {
        for (int i = filaInicial; i < filaFinal; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                Casilla casilla = new Casilla(this, new Posicion(i, j));
                casilla.setPropietario(propietario);
                casillas.add(casilla);
            }
        }
    }

    Casilla getCasillaEnPosicion(Posicion posicion) {
        for (Casilla casilla : casillas) {
            if (casilla.distanciaAPosicion(posicion) == 0) {
                return casilla;
            }
        }

        throw new RuntimeException();
    }

    private Casilla getCasillaConUnidad(Unidad unidad) {
        for (Casilla casilla : casillas) {
            if (casilla.getOcupante() == unidad) {
                return casilla;
            }
        }

        throw new RuntimeException();
    }

    public int getWidth() {
        return COLUMNAS;
    }

    public int getHeight() {
        return FILAS;
    }

    public void posicionarUnidad(Unidad unidad, Posicion posicion) {
        Casilla casilla = getCasillaEnPosicion(posicion);
        casilla.setOcupante(unidad);
    }

    public Unidad quitarUnidad(Posicion posicion) {
        Casilla casilla = getCasillaEnPosicion(posicion);
        return casilla.removeOcupante();
    }

    public Unidad getUnidadEnPosicion(Posicion posicion) {
        Casilla casilla = getCasillaEnPosicion(posicion);
        return casilla.getOcupante();
    }

    private List<Casilla> getCasillasAdyacencesAPosicion(Posicion posicion) {
        List<Casilla> casillasAdyacentes = new ArrayList<>();
        for (Casilla casilla : casillas) {
            if (casilla.distanciaAPosicion(posicion) == 1) {
                casillasAdyacentes.add(casilla);
            }
        }
        return casillasAdyacentes;
    }

    List<Unidad> getUnidadesAdyacencesAPosicion(Posicion posicion) {
        List<Casilla> casillasAdyacentes = getCasillasAdyacencesAPosicion(posicion);
        List<Unidad> unidadesAdyacentes = new ArrayList<>();
        for (Casilla casilla : casillasAdyacentes) {
            unidadesAdyacentes.add(casilla.getOcupante());
        }
        return unidadesAdyacentes;
    }

    public List<Unidad> getUnidades() {
        List<Unidad> unidades = new ArrayList<>();
        for (Casilla casilla : casillas) {
            unidades.add(casilla.getOcupante());
        }
        return unidades;
    }

    public Jugador getJugadorA() {
        return jugadorA;
    }

    public Jugador getJugadorB() {
        return jugadorB;
    }
}
