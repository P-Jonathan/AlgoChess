package fiuba.algo3.AlgoChess.modelo;

import fiuba.algo3.AlgoChess.modelo.tablero.Posicion;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.modelo.unidades.Jinete;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import fiuba.algo3.AlgoChess.modelo.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.*;

class JineteTest {
    @Test
    void unJineteAtacaUnaUnidadEnemigaADistanciaMediaYDeberiaRestarle15DeVida() {
        Tablero tablero = new Tablero("P1", "P2");

        Jinete jinete = new Jinete(tablero.getJugadorA());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(jinete, new Posicion(8, 8));
        tablero.posicionarUnidad(objetivo, new Posicion(12, 12));

        int vidaPrevia = objetivo.getVida();

        jinete.usarHabilidad(objetivo);

        assertEquals(vidaPrevia - 15, objetivo.getVida());
    }

    @Test
    void unJineteAtacaUnaUnidadCuerpoACuerpoAUnaUnidadEnemigaYDeberiaRestarle5DeVida() {
        Tablero tablero = new Tablero("P1", "P2");

        Jinete jinete = new Jinete(tablero.getJugadorA());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(jinete, new Posicion(9, 9));
        tablero.posicionarUnidad(objetivo, new Posicion(10, 10));

        int vidaPrevia = objetivo.getVida();

        jinete.moverHaciaAdelante();
        jinete.usarHabilidad(objetivo);

        assertEquals(vidaPrevia - 5, objetivo.getVida());
    }

    @Test
    void unJineteAtacaAUnEnemigoADistanciaMediaTeniendoUnSoldadoAliadoCercaYDeberiaQuitarle15DeVida() {
        Tablero tablero = new Tablero("P1", "P2");

        Jinete jinete = new Jinete(tablero.getJugadorA());
        Unidad aliado = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(jinete, new Posicion(9, 9));
        tablero.posicionarUnidad(aliado, new Posicion(8, 9));
        tablero.posicionarUnidad(objetivo, new Posicion(10, 13));

        int vidaPrevia = objetivo.getVida();

        jinete.usarHabilidad(objetivo);

        assertEquals(vidaPrevia - 15, objetivo.getVida());
    }

    @Test
    void unJineteAtacaAUnEnemigoADistanciaMediaTeniendoUnSoldadoEnemigoCercaDeberiaLanzarUnaExcepcion() {
        Tablero tablero = new Tablero("P1", "P2");

        Jinete jinete = new Jinete(tablero.getJugadorA());
        Unidad enemigoCerca = new UnidadDeInfanteria(tablero.getJugadorB());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(jinete, new Posicion(9, 9));
        tablero.posicionarUnidad(enemigoCerca, new Posicion(11, 10));
        tablero.posicionarUnidad(objetivo, new Posicion(10, 15));

        jinete.moverHaciaAdelante();

        assertThrows(RuntimeException.class, () -> jinete.usarHabilidad(objetivo));
    }

    @Test
    void unJineteAtacaAUnEnemigoADistanciaCortaTeniendoUnSoldadoEnemigoCercaYDeberiaQuitarle5PuntosDeVida() {
        Tablero tablero = new Tablero("P1", "P2");

        Jinete jinete = new Jinete(tablero.getJugadorA());
        Unidad enemigo = new UnidadDeInfanteria(tablero.getJugadorB());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(jinete, new Posicion(9, 9));
        tablero.posicionarUnidad(enemigo, new Posicion(10, 10));
        tablero.posicionarUnidad(objetivo, new Posicion(10, 11));

        int vidaPrevia = objetivo.getVida();

        jinete.usarHabilidad(objetivo);

        assertEquals(vidaPrevia - 5, objetivo.getVida());
    }

    @Test
    void unJineteAtacaAUnEnemigoADistanciaCortaTeniendoUnJineteAliadoCercaYNoDeberiaLanzarUnaExcepcion() {
        Tablero tablero = new Tablero("P1", "P2");

        Jinete jinete = new Jinete(tablero.getJugadorA());
        Unidad aliado = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(jinete, new Posicion(9, 9));
        tablero.posicionarUnidad(aliado, new Posicion(9, 8));
        tablero.posicionarUnidad(objetivo, new Posicion(10, 10));

        int vidaPrevia = objetivo.getVida();

        jinete.usarHabilidad(objetivo);

        assertThrows(RuntimeException.class, () -> jinete.usarHabilidad(objetivo));
    }
}
