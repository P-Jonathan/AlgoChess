package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Unidad;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.unidades.Curandero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CuranderoTest {
    @Test
    public void unCuranderoCuraAUnaUNidadDeInfanteriaYSuVidaDeberiaAumentarEn15() {
        Curandero curandero = new Curandero();
        UnidadDeInfanteria soldado = new UnidadDeInfanteria();

        assertEquals(soldado.getVida(), 100);

        curandero.curar(soldado);

        assertEquals(soldado.getVida(), 115);
    }
}