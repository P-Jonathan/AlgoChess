package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

public class UnidadDeInfanteriaTest {
	@Test
	public void unidadAtacaAUnidadEnemigaYLeQuitaVida() {
		Tablero tablero = new Tablero();
		UnidadDeInfanteria unidadOfensiva = new UnidadDeInfanteria("Test", tablero, new Posicion2D(1, 1));
		UnidadDeInfanteria unidadEnemiga = new UnidadDeInfanteria("Enemigo", tablero, new Posicion2D(2, 2));

		int vidaPrevia = unidadEnemiga.getVida();

		unidadOfensiva.atacar(unidadEnemiga);

		assertEquals(vidaPrevia - 10, unidadEnemiga.getVida());
	}
}