package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

public class UnidadDeInfanteriaTest {
    @Test
    public void unidadAtacaAUnidadEnemigaYLeQuitaVida() {
    	UnidadDeInfanteria unidadOfensiva = new UnidadDeInfanteria();
        UnidadDeInfanteria unidadEnemiga = new UnidadDeInfanteria();

        int vidaPrevia = unidadEnemiga.getVida();

        unidadOfensiva.atacar(unidadEnemiga);

        assertEquals(vidaPrevia - 10, unidadEnemiga.getVida());
    }
}