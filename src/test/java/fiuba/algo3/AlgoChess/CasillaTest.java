package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.tablero.Casilla;
import fiuba.algo3.AlgoChess.unidades.Unidad;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasillaTest {
	@Test
	public void casillaOcupadaConUnidad() {
		Casilla c = new Casilla();
		Unidad u = new UnidadDeInfanteria();

		c.ocuparCon(u);

		assertTrue(c.ocupadaCon(u));
	}

	@Test
	public void creoCasillaYPuedoOcuparlaConUnaUnidadLoQueSignificaQueSeCreaVacia() {
		Casilla casilla = new Casilla();
		Unidad u = new UnidadDeInfanteria();

		assertDoesNotThrow( () -> {
			casilla.ocuparCon(u);
		});

		assertTrue(casilla.ocupadaCon(u));
	}

	@Test
	public void intentoPosicionarUnidadEnCasillaOcupadaYLanzaUnaException() {
		Casilla casilla = new Casilla();
		Unidad u = new UnidadDeInfanteria();
		Unidad p = new UnidadDeInfanteria();

		casilla.ocuparCon(u);

		assertTrue(casilla.ocupadaCon(u));
		assertFalse(casilla.ocupadaCon(p));
	}
}