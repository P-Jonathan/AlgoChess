package fiuba.algo3.AlgoChess.modelo.tablero;

import fiuba.algo3.AlgoChess.modelo.excepciones.NoSePuedePosicionarEnTerrenoEnemigo;
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
        jugadorA = new Jugador();
        jugadorB = new Jugador();
        jugadorActual = jugadorA;
        jugadorEnEspera = jugadorB;
        setCasillasVacias();
    }

    private void setCasillasVacias() {
        casillas = new ArrayList<>();
        inicializarFilasDeCasillas(0, FILAS / 2, jugadorA);
        inicializarFilasDeCasillas(FILAS / 2, FILAS, jugadorB);
    }

    private void inicializarFilasDeCasillas(int filaInicial, int filaFinal, Jugador propietario) {
        for (int i = 0; i < COLUMNAS; i++) {
            for (int j = filaInicial; j < filaFinal; j++) {
                Casilla casilla = new Casilla(this, new Posicion(i, j));
                casilla.setPropietario(propietario);
                casillas.add(casilla);
            }
        }
    }

    Casilla getCasillaEnPosicion(Posicion posicion) {
        for (Casilla casilla : casillas) {
            if (casilla.estaEnPosicion(posicion)) {
                return casilla;
            }
        }

        throw new RuntimeException();
    }

    private Casilla getCasillaConUnidad(Unidad unidad) {
        for (Casilla casilla : casillas) {
            if (casilla.getOcupante().equals(unidad)) {
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

    private boolean puedePosicionarUnidadEnPosicion(Unidad unidad, Posicion posicion) {
        Casilla casilla = getCasillaEnPosicion(posicion);
        return casilla.esTerrenoAliadoPara(unidad);
    }

    private boolean noPuedePosicionarUnidadEnPosicion(Unidad unidad, Posicion posicion) {
        return !puedePosicionarUnidadEnPosicion(unidad, posicion);
    }

    public void posicionarUnidad(Unidad unidad, Posicion posicion) {
        if (noPuedePosicionarUnidadEnPosicion(unidad, posicion))
            throw new NoSePuedePosicionarEnTerrenoEnemigo();

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

    private List<Casilla> getCasillasAdyacences(Casilla casilla) {
        List<Casilla> casillasAdyacentes = new ArrayList<>();
        for (Casilla otraCasilla : casillas) {
            if (otraCasilla.esAdyacente(casilla)) {
                casillasAdyacentes.add(otraCasilla);
            }
        }
        casillasAdyacentes.remove(casilla);
        return casillasAdyacentes;
    }

    List<Unidad> getUnidadesAdyacencesAPosicion(Posicion posicion) {
        Casilla casillaBuscada = getCasillaEnPosicion(posicion);
        List<Casilla> casillasAdyacentes = getCasillasAdyacences(casillaBuscada);
        List<Unidad> unidadesAdyacentes = new ArrayList<>();
        for (Casilla casilla : casillasAdyacentes) {
            unidadesAdyacentes.add(casilla.getOcupante());
        }
        return unidadesAdyacentes;
    }

    public List<Unidad> getUnidadesADistanciaCorta(Posicion posicion) {
        Unidad unidadBuscada = getUnidadEnPosicion(posicion);
        List<Unidad> unidadesADistanciaCorta = new ArrayList<>();
        for (Unidad unidad : getUnidades()) {
            if(unidad.estaACortaDistancia(unidadBuscada)) {
                unidadesADistanciaCorta.add(unidad);
            }
        }
        return unidadesADistanciaCorta;
    }

    public List<Unidad> getUnidadesADistanciaMedia(Posicion posicion) {
        Unidad unidadBuscada = getUnidadEnPosicion(posicion);
        List<Unidad> unidadesADistanciaMedia = new ArrayList<>();
        for (Unidad unidad : getUnidades()) {
            if(unidad.estaAMediaDistancia(unidadBuscada)) {
                unidadesADistanciaMedia.add(unidad);
            }
        }
        return unidadesADistanciaMedia;
    }

    public List<Unidad> getUnidadesADistanciaLarga(Posicion posicion) {
        Unidad unidadBuscada = getUnidadEnPosicion(posicion);
        List<Unidad> unidadesADistanciaLarga = new ArrayList<>();
        for (Unidad unidad : getUnidades()) {
            if(unidad.estaALargaDistancia(unidadBuscada)) {
                unidadesADistanciaLarga.add(unidad);
            }
        }
        return unidadesADistanciaLarga;
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
