package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.excepciones.NoExisteLaCasillaConLaUnidadSolicitada;
import fiuba.algo3.algochess.modelo.excepciones.NoSePuedePosicionarEnTerrenoEnemigo;
import fiuba.algo3.algochess.modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

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
        Optional<Casilla> optionalCasilla = casillas
                .stream()
                .filter(c -> c.estaEnPosicion(posicion))
                .findFirst();

        if(optionalCasilla.isPresent())
            return optionalCasilla.get();

        throw new RuntimeException();
    }

    private Casilla getCasillaConUnidad(Unidad unidad) {
        Optional<Casilla> optionalCasilla = casillas
                .stream()
                .filter(c -> c.getOcupante().equals(unidad))
                .findFirst();

        if(optionalCasilla.isPresent())
            return optionalCasilla.get();

        throw new NoExisteLaCasillaConLaUnidadSolicitada();
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
        return casillas
                .stream()
                .filter(c -> c.esAdyacente(casilla))
                .collect(toList());
    }

    List<Unidad> getUnidadesAdyacencesAPosicion(Posicion posicion) {
        Casilla casilla = getCasillaEnPosicion(posicion);
        return casillas
                .stream()
                .filter(c -> c.esAdyacente(casilla))
                .map(Casilla::getOcupante)
                .collect(toList());
    }

    public List<Unidad> getUnidadesADistanciaCorta(Posicion posicion) {
        Casilla casilla = getCasillaEnPosicion(posicion);
        return casillas
                .stream()
                .filter(c -> c.estaADistanciaCorta(casilla))
                .map(Casilla::getOcupante)
                .collect(toList());
    }

    public List<Unidad> getUnidadesADistanciaMedia(Posicion posicion) {
        Casilla casilla = getCasillaEnPosicion(posicion);
        return casillas
                .stream()
                .filter(c -> c.estaADistanciaMedia(casilla))
                .map(Casilla::getOcupante)
                .collect(toList());
    }

    public List<Unidad> getUnidadesADistanciaLarga(Posicion posicion) {
        Casilla casilla = getCasillaEnPosicion(posicion);
        return casillas
                .stream()
                .filter(c -> c.estaADistanciaLarga(casilla))
                .map(Casilla::getOcupante)
                .collect(toList());
    }

    public List<Unidad> getUnidades() {
        return casillas
                .stream()
                .map(Casilla::getOcupante)
                .collect(toList());
    }

    public Jugador getJugadorA() {
        return jugadorA;
    }

    public Jugador getJugadorB() {
        return jugadorB;
    }
}
