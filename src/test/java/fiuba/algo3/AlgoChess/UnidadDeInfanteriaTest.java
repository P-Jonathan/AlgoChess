package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

public class UnidadDeInfanteriaTest {
	@Test
	public void creoUnidadYAlQuitarle50DeVidaLeQuedan50() {
		UnidadDeInfanteria soldado = new UnidadDeInfanteria("Test", new Tablero(), new Posicion2D(0, 0));
		assertEquals(100, soldado.getVida());
		soldado.recibirDanio(50);
		assertEquals(50, soldado.getVida());
	}

	@Test
	void creoUnidadLeAumentoLaVidaEn20YSuVidaEs120() {
		UnidadDeInfanteria soldado = new UnidadDeInfanteria("Test", new Tablero(), new Posicion2D(0, 0));

		assertEquals(100, soldado.getVida());
		soldado.aumentarVida(50);
		assertEquals(150, soldado.getVida());
	}
}