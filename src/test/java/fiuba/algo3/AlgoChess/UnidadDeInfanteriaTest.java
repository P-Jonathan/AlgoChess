package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UnidadDeInfanteriaTest {
	@Test
	public void creoUnidadYAlQuitarle50DeVidaLeQuedan50() {
		UnidadDeInfanteria soldado = new UnidadDeInfanteria();
		assertEquals(soldado.getVida(), 100);
		soldado.recibirDanio(50);
		assertEquals(soldado.getVida(), 50);
	}
}
