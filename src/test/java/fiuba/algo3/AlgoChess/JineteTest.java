package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Jinete;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JineteTest {
	@Test
	public void creoUnidadYAlQuitarle50DeVidaLeQuedan50() {
		Jinete jinete = new Jinete("Prueba", new Tablero(), new Posicion2D(0, 0));
		assertEquals(jinete.getVida(), 100);
		jinete.recibirDanio(50);
		assertEquals(jinete.getVida(), 50);
	}

	@Test
	void creoUnidadLeAumentoLaVidaEn20YSuVidaEs120() {
		Jinete jinete = new Jinete("Prueba", new Tablero(), new Posicion2D(0, 0));
		assertEquals(jinete.getVida(), 100);
		jinete.aumentarVida(20);
		assertEquals(jinete.getVida(), 120);
	}

	@Test
	public void unJineteAtacaUnaUnidadDeInfanteriaADistanciaYDeberiaRestarle15DeVida() {
		Tablero tablero = new Tablero();
		Jinete jinete = new Jinete("Prueba", tablero, new Posicion2D(0, 0));
		UnidadDeInfanteria soldado = new UnidadDeInfanteria("Enemigo", tablero, new Posicion2D(10, 10));

		assertEquals(soldado.getVida(), 100);

		jinete.atacarADistancia(soldado);

		assertEquals(soldado.getVida(), 85);
	}

	@Test
	public void unJineteAtacaUnaUnidadDeInfanteriaCuerpoACuerpoYDeberiaRestarle5DeVida() {
		Tablero tablero = new Tablero();
		Jinete jinete = new Jinete("Prueba", tablero, new Posicion2D(0, 0));
		UnidadDeInfanteria soldado = new UnidadDeInfanteria("Enemigo", tablero, new Posicion2D(1, 1));

		assertEquals(soldado.getVida(), 100);

		jinete.atacarAMelee(soldado);

		assertEquals(soldado.getVida(), 95);
	}

}
