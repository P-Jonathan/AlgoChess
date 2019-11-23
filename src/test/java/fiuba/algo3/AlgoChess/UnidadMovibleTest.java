package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.*;

public class UnidadMovibleTest {
    @Test
    public void creoUnaUnidadMovibleLaMuevoYSuPosicionDeberiaCambiar() {
        Tablero tablero = new Tablero();
        UnidadDeInfanteria soldado = new UnidadDeInfanteria();

        tablero.posicionarUnidad(soldado, 2, 2);

        tablero.moverUnidadAdelante(soldado);

        UnidadDeInfanteria soldado2 = new UnidadDeInfanteria();

        assertDoesNotThrow( ()-> {
                tablero.posicionarUnidad(soldado2, 2, 2);
        });
    }

    @Test
    public void creoUnaUnidadMovibleLaMuevoAUnaCasillaOcupadaEIntentoPonerUnaUnidadEnSuPosicionYDeberiaLanzarNoPosicionarla() {
        Tablero tablero = new Tablero();
        UnidadDeInfanteria soldado1 = new UnidadDeInfanteria();
        UnidadDeInfanteria soldado2 = new UnidadDeInfanteria();
        UnidadDeInfanteria soldado3 = new UnidadDeInfanteria();

        tablero.posicionarUnidad(soldado1, 2, 2);
        tablero.posicionarUnidad(soldado2, 3, 2);

        tablero.moverUnidadAdelante(soldado1);

        assertEquals(soldado1.posicion(), "2;2");

        tablero.posicionarUnidad(soldado3, 2,2);

        assertEquals(soldado1.posicion(), "2;2");
    }

    @Test
    public void unaUnidadMovibleNoDeberiaMoverseAUnCasilleroOcupado() {
        Tablero tablero = new Tablero();

        UnidadDeInfanteria soldado1 = new UnidadDeInfanteria();
        UnidadDeInfanteria soldado2 = new UnidadDeInfanteria();

        tablero.posicionarUnidad(soldado1, 2,2);
        tablero.posicionarUnidad(soldado2, 1,2);

        assertEquals(soldado1.posicion(), "2;2");
        assertEquals(soldado2.posicion(), "1;2");
    }
}
