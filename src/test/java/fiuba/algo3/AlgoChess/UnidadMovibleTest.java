package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.unidades.Unidad;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

public class UnidadMovibleTest {
    @Test
    public void creoUnaUnidadMovibleLaMuevoYSuPosicionDeberiaCambiar() {
        Tablero tablero = new Tablero();
        UnidadDeInfanteria soldado = new UnidadDeInfanteria();

        tablero.posicionarUnidad(soldado, 2, 2);

        tablero.moverUnidadAdelante(soldado);

        assertEquals(soldado.getCoords(), "3 ; 2");
    }

    @Test
    public void unaUnidadMovibleNoDeberiaMoverseAUnCasilleroOcupado() {
        Tablero tablero = new Tablero();

        UnidadDeInfanteria soldado1 = new UnidadDeInfanteria();
        UnidadDeInfanteria soldado2 = new UnidadDeInfanteria();

        tablero.posicionarUnidad(soldado1, 2,2);
        tablero.posicionarUnidad(soldado2, 1,2);

        assertThrows(CasillaOcupadaException.class, ()->{
            tablero.moverUnidadAdelante(soldado2);
        });
    }
}
