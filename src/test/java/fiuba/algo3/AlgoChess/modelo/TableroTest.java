package fiuba.algo3.AlgoChess.modelo;

import fiuba.algo3.AlgoChess.modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import fiuba.algo3.AlgoChess.modelo.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {
    @Test
    void seColocaUnaUnidadAliadaEnUnCasilleroDelSectorAliadoVacioConExito() {
        Tablero tablero = new Tablero();

        Unidad unidad = new UnidadDeInfanteria(tablero.getJugadorA());
        Posicion posicion = new Posicion(2, 2);

        assertDoesNotThrow(() -> tablero.posicionarUnidad(unidad, posicion));
        assertEquals(unidad, tablero.getUnidadEnPosicion(posicion));
    }

    @Test
    void seVerificaQueNoSePuedeColocarUnaUnidadAliadaEnUnCasilleroOcupadoEnElSectorAliado() {
        Tablero tablero = new Tablero();

        Posicion posicion = new Posicion(2, 2);
        Unidad unidad = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(unidad, posicion);

        assertThrows(RuntimeException.class, () -> tablero.posicionarUnidad(unidad2, posicion));
    }

    @Test
    void seVerificaQueNoSePuedeColocarUnaPiezaAliadaEnUnCasilleroDelSectorEnemigo() {
        Tablero tablero = new Tablero();

        Unidad unidad = new UnidadDeInfanteria(tablero.getJugadorB());
        Posicion posicion = new Posicion(0, 0);

        assertThrows(RuntimeException.class, () -> tablero.posicionarUnidad(unidad, posicion));
    }

    @Test
    void seVerificaQueAlAtacarUnaUnidadEnemigaEnTerrenoAliadoSeLeQuitaUnCincoPorCientoMasDeVida() {
        Tablero tablero = new Tablero();
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(objetivo, new Posicion(0, 10));

        objetivo.moverHaciaAtras();
        objetivo.moverHaciaAtras();

        int danio = 10;
        double vidaPrevia = objetivo.getVida();
        double vidaEsperada = vidaPrevia - (danio + (danio * 0.05));

        objetivo.disminuirVida(danio);

        assertEquals(vidaEsperada, objetivo.getVida());
    }

    @Test
    void seVerificaQueAlAtacarUnaUnidadEnemigaEnTerrenoEnemigoNoSeLeQuitaUnCincoPorCientoMasDeVida() {
        Tablero tablero = new Tablero();
        Unidad objetivo = new UnidadDeInfanteria(tablero.getJugadorB());

        tablero.posicionarUnidad(objetivo, new Posicion(0, 10));

        int danio = 10;
        double vidaPrevia = objetivo.getVida();
        double vidaEsperada = vidaPrevia - danio;

        objetivo.disminuirVida(danio);

        assertEquals(vidaEsperada, objetivo.getVida());
    }
}
