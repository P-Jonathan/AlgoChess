package fiuba.algo3.algochess.modelo;

import fiuba.algo3.algochess.modelo.tablero.Jugador;
import fiuba.algo3.algochess.modelo.tablero.Posicion;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;
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

    @Test
    void seVerificaQueUnaUnidadNoPuedeMoverse2VecesSeguidasPorElTurno(){
        Tablero tablero = new Tablero();
        Unidad unidad = new UnidadDeInfanteria();
        Jugador jugador = tablero.getJugadorA();
        Posicion posicion = new Posicion(2, 2);

        jugador.comprarUnidadConTurno(unidad);
        tablero.posicionarUnidad(unidad,posicion);
        unidad.moverHaciaAdelanteConTurno();

        assertThrows(RuntimeException.class, () -> unidad.moverHaciaAdelanteConTurno());
    }
}
