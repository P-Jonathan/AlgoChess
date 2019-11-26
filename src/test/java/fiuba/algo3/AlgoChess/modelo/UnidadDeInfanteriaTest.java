package fiuba.algo3.AlgoChess.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fiuba.algo3.AlgoChess.modelo.tablero.Jugador;
import fiuba.algo3.AlgoChess.modelo.tablero.Posicion;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.modelo.unidades.UnidadDeInfanteria;

class UnidadDeInfanteriaTest {
    @Test
    void atacaAUnidadEnemigaYLeQuita10DeVida() {
        Tablero tablero = new Tablero("P1", "P2");
        Jugador jugadorA = tablero.getJugadorA();
        Jugador jugadorB = tablero.getJugadorB();

        UnidadDeInfanteria unidad = new UnidadDeInfanteria();
        Unidad objetivo = new UnidadDeInfanteria();

        jugadorA.comprarUnidad(unidad);
        jugadorB.comprarUnidad(objetivo);

        tablero.posicionarUnidad(unidad, new Posicion(5, 9));
        tablero.posicionarUnidad(objetivo, new Posicion(5, 11));

        int vidaPrevia = objetivo.getVida();

        unidad.usarHabilidad(objetivo);

        assertEquals(vidaPrevia - 10, objetivo.getVida());
    }
}