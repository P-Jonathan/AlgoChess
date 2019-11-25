package fiuba.algo3.AlgoChess.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fiuba.algo3.AlgoChess.modelo.unidades.Curandero;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import fiuba.algo3.AlgoChess.modelo.unidades.UnidadDeInfanteria;
import org.junit.jupiter.api.Test;

class UnidadTest {
    @Test
    void creoUnidadYAlQuitarle10DeVidaSuVidaSeReduceEn10Puntos() {
        Unidad unidad = new Curandero();

        int vidaPrevia = unidad.getVida();

        unidad.disminuirVida(10);

        assertEquals(vidaPrevia - 10, unidad.getVida());
    }

    @Test
    void creoUnidadYAlQuitarle40DeVidaSuVidaSeReduceEn40Puntos() {
        Unidad unidad = new UnidadDeInfanteria();

        int vidaPrevia = unidad.getVida();

        unidad.disminuirVida(40);

        assertEquals(vidaPrevia - 40, unidad.getVida());
    }

    @Test
    void creoUnidadYAlAumentarSuVidaEn50SuVidaAumenta50Puntos() {
        Unidad unidad = new Curandero();

        int vidaPrevia = unidad.getVida();

        unidad.aumentarVida(50);

        assertEquals(vidaPrevia + 50, unidad.getVida());
    }

    @Test
    void creoUnidadYAlAumentarSuVidaEn100SuVidaAumenta100Puntos() {
        Unidad unidad = new UnidadDeInfanteria();

        int vidaPrevia = unidad.getVida();

        unidad.aumentarVida(100);

        assertEquals(vidaPrevia + 100, unidad.getVida());
    }
}