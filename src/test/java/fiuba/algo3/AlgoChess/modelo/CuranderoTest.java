package fiuba.algo3.AlgoChess.modelo;

import fiuba.algo3.AlgoChess.modelo.unidades.UnidadDeInfanteria;
import fiuba.algo3.AlgoChess.modelo.unidades.Curandero;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CuranderoTest {
    @Test
    void unCuranderoCuraAUnaUNidadDeInfanteriaYSuVidaDeberiaAumentarEn15() {
        Tablero tablero = new Tablero("P1", "P2");
        Curandero curandero = new Curandero(tablero.getJugadorA());
        Unidad aliado = new UnidadDeInfanteria(tablero.getJugadorA());

        int vidaPrevia = aliado.getVida();

        curandero.usarHabilidad(aliado);

        assertEquals(vidaPrevia + 15, aliado.getVida());
    }
}