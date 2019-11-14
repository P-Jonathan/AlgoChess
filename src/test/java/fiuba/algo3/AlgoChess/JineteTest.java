package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Jinete;
import fiuba.algo3.AlgoChess.unidades.Unidad;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JineteTest {
	@Test
	public void unJineteAtacaUnaUnidadADistanciaYDeberiaRestarle15DeVida() {
		Tablero tablero = new Tablero("Test", "Enemigo", 2, 5);
		Jinete jinete = new Jinete("Test", new Posicion2D(0, 0));
		Unidad objetivo = new UnidadDeInfanteria("Enemigo", new Posicion2D(1, 4));
		tablero.posicionarUnidad(jinete);
		tablero.posicionarUnidad(objetivo);
		int vidaPrevia = objetivo.getVida();

		jinete.atacar(objetivo);

		assertEquals(vidaPrevia - 15, objetivo.getVida());
	}

	@Test
	public void unJineteAtacaUnaUnidadCuerpoACuerpoYDeberiaRestarle5DeVida() {
		Tablero tablero = new Tablero("Test", "Enemigo", 2, 5);
		Jinete jinete = new Jinete("Test", new Posicion2D(0, 0));
		Unidad objetivo = new UnidadDeInfanteria("Enemigo",  new Posicion2D(1, 1));
		tablero.posicionarUnidad(jinete);
		tablero.posicionarUnidad(objetivo);
		int vidaPrevia = objetivo.getVida();

		jinete.atacar(objetivo);

		assertEquals(vidaPrevia - 5, objetivo.getVida());
	}
}
