package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.unidades.Unidad;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

public class UnidadOfensivaTest {
    @Test
    public void unidadOfensivaAtacaAUnidadEnemigaYLeQuitaVida() {
        Tablero tablero = new Tablero();

        UnidadDeInfanteria unidadOfensiva = new UnidadDeInfanteria();
        Unidad unidadEnemiga = new UnidadDeInfanteria();

        int vidaPrevia = unidadEnemiga.getVida();

        unidadOfensiva.atacar(unidadEnemiga);

        assertEquals(vidaPrevia - 10, unidadEnemiga.getVida());
    }
}
