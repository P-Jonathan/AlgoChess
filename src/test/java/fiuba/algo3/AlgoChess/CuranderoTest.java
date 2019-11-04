package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Curandero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuranderoTest {
	@Test
	public void creoUnidadCUranderoYAlQuitarle50DeVidaLeQuedan25() {
		Curandero curandero = new Curandero("Test", new Tablero(), new Posicion2D(0, 0));
		assertEquals(curandero.getVida(), 75);
		curandero.recibirDanio(50);
		assertEquals(curandero.getVida(), 25);
	}

	@Test
	void creoUnidadCUranderoLeAumentoLaVidaEn20YSuVidaEs95() {
		Curandero curandero = new Curandero("Test", new Tablero(), new Posicion2D(0, 0));
		assertEquals(curandero.getVida(), 75);
		curandero.aumentarVida(20);
		assertEquals(curandero.getVida(), 95);
	}

	@Test
	void creoCUranderoLeQuito25DeVidaYSuVidaEs50() {
		Curandero curandero = new Curandero("Test", new Tablero(), new Posicion2D(0, 0));
		assertEquals(curandero.getVida(), 75);
		curandero.recibirDanio(25);
		assertEquals(curandero.getVida(), 50);
	}

	@Test
	public void unCuranderoCuraAUnaUNidadDeInfanteriaYSuVidaDeberiaAumentarEn15() {
		Curandero curandero = new Curandero("Test", new Tablero(), new Posicion2D(0, 0));
		UnidadDeInfanteria soldado = new UnidadDeInfanteria("Test", new Tablero(), new Posicion2D(1, 1));
		assertEquals(soldado.getVida(), 100);
		curandero.curar(soldado);
		assertEquals(soldado.getVida(), 115);
	}
}