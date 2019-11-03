package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;

import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UnidadMovibleTest {
    @Test
    public void creoUnaUnidadDeInfanteriaLaColocoEnElTableroLaMuevoYSuPosicionDeberiaCambiar() {
        Tablero tablero = new Tablero(5,5);
        UnidadDeInfanteria soldado = new UnidadDeInfanteria(tablero);

        tablero.posicionarUnidad(soldado, new Posicion2D(4,4));

        soldado.mover(new Posicion2D(1,3));

        assertEquals(soldado.getPosicion().getX(), 1);
        assertEquals(soldado.getPosicion().getY(), 3);
    }
}
