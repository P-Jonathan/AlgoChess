package fiuba.algo3.AlgoChess.modelo;

import fiuba.algo3.AlgoChess.modelo.tablero.Jugador;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import fiuba.algo3.AlgoChess.modelo.unidades.UnidadDeInfanteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TurnoTest {

    @Test
    void seVerificaQueAlComprarUnaUnidadDeInfanteriaSeLeRestanLosPuntosCorrespondientesAlJugadorSiElTurnoEsElCorrespondiente() {
        Tablero tablero = new Tablero();
        Unidad unidad = new UnidadDeInfanteria();
        Jugador jugador = tablero.getJugadorA();
        int puntosPrevios = jugador.getPuntos();

        jugador.comprarUnidadConTurno(unidad);

        assertEquals(puntosPrevios - unidad.getCosto(), jugador.getPuntos());
    }


    @Test
    void seVerificaQueSeLanzaUnaExcepcionCUandoSeQuiereCOmprearUnaUnidadYNoEsUnTurnoValido(){
        Tablero tablero = new Tablero();
        Unidad unidad = new UnidadDeInfanteria();
        Jugador jugador = tablero.getJugadorA();

        jugador.jugadorCambiarTurno();

        assertThrows(RuntimeException.class, () -> jugador.comprarUnidadConTurno(unidad));
    }
}
