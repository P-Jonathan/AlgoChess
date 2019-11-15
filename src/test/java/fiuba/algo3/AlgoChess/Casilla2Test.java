package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.tablero.Casilla2;
import fiuba.algo3.AlgoChess.unidades.Unidad2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Casilla2Test {
    @Test
    public void creoCasillaVacia() {
        Casilla2 casilla = new Casilla2();

        assertDoesNotThrow(() -> {

            casilla.ocuparCon(new Unidad2());
        });
    }

    @Test
    public void creoCasillaConOcupanteYNoPueoOcuparlaDeNuevo() {
        Unidad2 unOcupante = new Unidad2();
        Casilla2 casilla = new Casilla2(unOcupante);

        assertThrows(CasillaOcupadaException.class, () -> {

            Unidad2 otroOcupante = new Unidad2();
            casilla.ocuparCon(otroOcupante);
        });
    }
}