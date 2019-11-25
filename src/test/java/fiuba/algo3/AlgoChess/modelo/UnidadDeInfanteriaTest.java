package fiuba.algo3.AlgoChess.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.modelo.unidades.UnidadDeInfanteria;

class UnidadDeInfanteriaTest {
    @Test
    void atacaAUnidadEnemigaYLeQuita10DeVida() {
        Tablero tablero = new Tablero("P1", "P2");
    	UnidadDeInfanteria unidadOfensiva = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidadEnemiga = new UnidadDeInfanteria(tablero.getJugadorB());

        int vidaPrevia = unidadEnemiga.getVida();

        unidadOfensiva.usarHabilidad(unidadEnemiga);

        assertEquals(vidaPrevia - 10, unidadEnemiga.getVida());
    }
}