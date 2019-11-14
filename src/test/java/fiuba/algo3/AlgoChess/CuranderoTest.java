package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Curandero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuranderoTest {
	@Test
	public void unCuranderoCuraAUnaUNidadDeInfanteriaYSuVidaDeberiaAumentarEn15() {
		Curandero curandero = new Curandero("Test", new Posicion2D(0, 0));
		UnidadDeInfanteria soldado = new UnidadDeInfanteria("Test",  new Posicion2D(1, 1));
		assertEquals(soldado.getVida(), 100);
		curandero.curar(soldado);
		assertEquals(soldado.getVida(), 115);
	}
}