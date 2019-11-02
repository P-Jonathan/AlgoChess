package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CasillaTest {
	@Test
	public void creoCasillaYEstaVacia() {
		Casilla casilla = new Casilla();
		assertEquals(casilla.ocupada(), false);
	}
}