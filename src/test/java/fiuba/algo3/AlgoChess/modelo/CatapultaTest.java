package fiuba.algo3.AlgoChess.modelo;

import fiuba.algo3.AlgoChess.modelo.tablero.Posicion;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.modelo.unidades.Catapulta;
import fiuba.algo3.AlgoChess.modelo.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatapultaTest {
    @Test
    void creoCatapultaLeAumentoLaVidaEn20PeroSuVidaSigueSiendoLaMisma() {
        Catapulta catapulta = new Catapulta();

        int vidaPrevia = catapulta.getVida();

        catapulta.aumentarVida(50);

        assertEquals(vidaPrevia, catapulta.getVida());
    }

    @Test
    void catapultaIntentaAtacarAUnObjetivoPeroNoEstaEnRango() {
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(tablero.getJugadorA());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(catapulta, new Posicion(0, 0));
        tablero.posicionarUnidad(objetivo, new Posicion(1, 1));

        int vidaPrevia = objetivo.getVida();

        catapulta.usarHabilidad(objetivo);

        assertEquals(vidaPrevia, objetivo.getVida());
    }

    @Test
    void catapultaAtacaAUnObjetivoYLeResta20DeVidaAlObjetivoYAUnaUnidadQueEstaJuntoAElla() {
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(tablero.getJugadorA());
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());
        Unidad adyacente = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(catapulta, new Posicion(5, 5));
        tablero.posicionarUnidad(objetivo, new Posicion(11, 11));
        tablero.posicionarUnidad(adyacente, new Posicion(12, 11));

        int vidaPreviaObjetivo = objetivo.getVida();
        int vidaPreviaAdyacente = adyacente.getVida();

        catapulta.usarHabilidad(objetivo);

        assertEquals(vidaPreviaObjetivo - 20, objetivo.getVida());
        assertEquals(vidaPreviaAdyacente - 20, adyacente.getVida());
    }
}
