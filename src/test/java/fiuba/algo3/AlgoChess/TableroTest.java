package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {
    @Test
    public void creoUnTableroDe1x1NuevoYAlObtenerLaCasillaDeberiaEstarVacia() {
        Tablero tablero = new Tablero(1,1);
        Casilla casilla = tablero.getCasilla(new Posicion2D(0,0));

        assertFalse(casilla.ocupada());
    }

}
