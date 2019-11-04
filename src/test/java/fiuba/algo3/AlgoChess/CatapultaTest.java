package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Catapulta;
import fiuba.algo3.AlgoChess.unidades.Unidad;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

public class CatapultaTest {

	@Test
	public void creoCatapultaYAlQuitarle25DeVidaLeQuedan25() {
		Catapulta catapulta = new Catapulta("Test", new Tablero(), new Posicion2D(0, 0));
		
		assertEquals(catapulta.getVida(), 50);
		catapulta.recibirDanio(25);
		assertEquals(catapulta.getVida(), 25);
	}

	@Test
	public void creoCatapultaLeAumentoLaVidaEn20PeroSuVidaSigueSiendo50() {
		Catapulta catapulta = new Catapulta("Test", new Tablero(), new Posicion2D(0, 0));
		
		assertEquals(catapulta.getVida(), 50);
		catapulta.aumentarVida(20);
		assertEquals(catapulta.getVida(), 50);
	}

	@Test
	public void catapultaAtacaAUnObjetivoYLeResta20DeVidaAlObjetivo() {
		Tablero tablero = new Tablero();
		Catapulta catapulta = new Catapulta("Test", tablero, new Posicion2D(0, 0));
		Unidad objetivo = new UnidadDeInfanteria("Objetivo", tablero, new Posicion2D(0, 0));
		
		int vidaPrevia = objetivo.getVida();
		
		catapulta.atacar(objetivo);
		
		assertEquals(objetivo.getVida(), vidaPrevia - 20);
	}

}
