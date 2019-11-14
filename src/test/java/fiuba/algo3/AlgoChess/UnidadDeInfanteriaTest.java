package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

public class UnidadDeInfanteriaTest {
	@Test
	public void unidadAtacaAUnidadEnemigaYLeQuitaVida() {
		Tablero tablero = new Tablero("Test", "Enemigo", 2, 5);
		UnidadDeInfanteria unidadOfensiva = new UnidadDeInfanteria("Test",  new Posicion2D(0, 1));
		UnidadDeInfanteria unidadEnemiga = new UnidadDeInfanteria("Enemigo", new Posicion2D(1, 2));
		tablero.posicionarUnidad(unidadOfensiva);
		tablero.posicionarUnidad(unidadEnemiga);
		int vidaPrevia = unidadEnemiga.getVida();

		unidadOfensiva.atacar(unidadEnemiga);

		assertEquals(vidaPrevia - 10, unidadEnemiga.getVida());
	}
}