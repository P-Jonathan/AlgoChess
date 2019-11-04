package fiuba.algo3.AlgoChess;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.unidades.*;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class UnidadTest {
	@Test
	public void creoUnidadYAlQuitarle10DeVidaSuVidaSeReduceEn10Puntos() {
		Unidad unidad = new Curandero("Test", new Tablero(), new Posicion2D(0, 0));
		
		int vidaPrevia = unidad.getVida();
		
		unidad.recibirDanio(10);
		
		assertEquals(vidaPrevia - 10, unidad.getVida());
	}
	
	@Test
	public void creoUnidadYAlQuitarle40DeVidaSuVidaSeReduceEn40Puntos() {
		Unidad unidad = new UnidadDeInfanteria("Test", new Tablero(), new Posicion2D(0, 0));
		
		int vidaPrevia = unidad.getVida();
		
		unidad.recibirDanio(40);
		
		assertEquals(vidaPrevia - 40, unidad.getVida());
	}
	
	@Test
	public void creoUnidadYAlAumentarSuVidaEn50SuVidaAumenta50Puntos() {
		Unidad unidad = new Curandero("Test", new Tablero(), new Posicion2D(0, 0));
		
		int vidaPrevia = unidad.getVida();
		
		unidad.aumentarVida(50);
		
		assertEquals(vidaPrevia + 50, unidad.getVida());
	}
	
	@Test
	public void creoUnidadYAlAumentarSuVidaEn100SuVidaAumenta100Puntos() {
		Unidad unidad = new UnidadDeInfanteria("Test", new Tablero(), new Posicion2D(0, 0));
		
		int vidaPrevia = unidad.getVida();
		
		unidad.aumentarVida(100);
		
		assertEquals(vidaPrevia + 100, unidad.getVida());
	}
}