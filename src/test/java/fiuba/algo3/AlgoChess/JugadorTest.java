package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {
    @Test
    public void UnJugadorCompraUnaUnidadYBajaLaCantidadDePuntoQueTieneElJugador(){
        Jugador jugador =  new Jugador();
        Tablero tablero = new Tablero();
        UnidadDeInfanteria unidadOfensiva = new UnidadDeInfanteria("Test", tablero, new Posicion2D(1, 1));
        int puntosPrevios = jugador.getPuntos();
        jugador.comprarUnidad(unidadOfensiva);

        assertEquals(puntosPrevios-1,jugador.getPuntos());
    }

}