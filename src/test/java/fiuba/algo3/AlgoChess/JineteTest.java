package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Jinete;
import fiuba.algo3.AlgoChess.unidades.Unidad;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JineteTest {
    @Test
    public void unJineteAtacaUnaUnidadADistanciaYDeberiaRestarle15DeVida() {
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete();
        Unidad objetivo = new UnidadDeInfanteria();

        tablero.posicionarUnidad(jinete, 2,2);
        tablero.posicionarUnidad(objetivo, 6,2);

        int vidaPrevia = objetivo.getVida();

        tablero.atacarConUnidadAUnidad(jinete, objetivo);

        assertEquals(vidaPrevia - 15, objetivo.getVida());
    }

    @Test
    public void unJineteAtacaUnaUnidadCuerpoACuerpoYDeberiaRestarle5DeVida() {
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete();
        Unidad objetivo = new UnidadDeInfanteria();

        tablero.posicionarUnidad(jinete, 2,2);
        tablero.posicionarUnidad(objetivo, 4,4);

        int vidaPrevia = objetivo.getVida();

        tablero.atacarConUnidadAUnidad(jinete, objetivo);

        assertEquals(vidaPrevia - 5, objetivo.getVida());
    }
}
