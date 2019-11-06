package fiuba.algo3.AlgoChess;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

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
	
	@Test
	public void coloco2UnidadesAdyacentesYPuedoComprobarQueEstanAdyacentes() {
		Tablero tablero = new Tablero();
		Unidad unidad1 = new Jinete("Test", tablero, new Posicion2D(1, 1));
		Unidad unidad2 = new Jinete("Test", tablero, new Posicion2D(1, 2));
		assertTrue(unidad1.esAdyacente(unidad2));
	}
	
	@Test
	public void coloco3UnidadesAdyacentesYAlComprobarUnaTieneALasOtrasAdyacentes() {
		Tablero tablero = new Tablero();
		Unidad unidad1 = new Jinete("Test", tablero, new Posicion2D(1, 1));
		Unidad unidad2 = new Jinete("Test", tablero, new Posicion2D(1, 2));
		Unidad unidad3 = new Jinete("Test", tablero, new Posicion2D(1, 0));
		List<Unidad> unidades = unidad1.unidadesAdyacentes();
		List<Unidad> unidadesTest = new LinkedList<Unidad>();
		unidadesTest.add(unidad2);
		unidadesTest.add(unidad3);
		assertTrue(unidades.containsAll(unidadesTest));
	}
	
}
	
	