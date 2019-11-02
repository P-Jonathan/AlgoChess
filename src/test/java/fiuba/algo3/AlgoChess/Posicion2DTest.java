package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Posicion2DTest {
	@Test
	public void crearPosicionConFila1YColumna2() {
		Posicion2D posicion = new Posicion2D(1, 2);
		assertEquals(posicion.getX(), 1);
		assertEquals(posicion.getY(), 2);
	}
	
	@Test
	public void posicionConFila1YColumna1EsAdyacenteAPosicionConFila2YColumna2() {
		Posicion2D posicion1 = new Posicion2D(1, 1);
		Posicion2D posicion2 = new Posicion2D(2, 2);
		assertTrue(posicion1.adyacente(posicion2));
	}
	
	@Test
	public void posicionConFila1YColumna1NoEsAdyacenteAPosicionConFila3YColumna3() {
		Posicion2D posicion1 = new Posicion2D(1, 1);
		Posicion2D posicion2 = new Posicion2D(3, 3);
		assertFalse(posicion1.adyacente(posicion2));
	}
	
	@Test
	public void posicionesConFilas1YColumna22SonIguales() {
		Posicion2D posicion1 = new Posicion2D(1, 22);
		Posicion2D posicion2 = new Posicion2D(1, 22);
		assertTrue(posicion1.isEquals(posicion2));
	}
	
	@Test
	public void posicionConFila1YColumna1NoEsIgualAPosicionConFila3YColumna3() {
		Posicion2D posicion1 = new Posicion2D(1, 1);
		Posicion2D posicion2 = new Posicion2D(3, 3);
		assertFalse(posicion1.isEquals(posicion2));
	}
	
	@Test
	public void leCambioAPosicionConFila2YColumna2LaFilaPor3() {
		Posicion2D posicion1 = new Posicion2D(2, 2);
		posicion1.setX(3);
		assertEquals(posicion1.getX(), 3);
	}
	
	@Test
	public void leCambioAPosicionConFila2YColumna2LaColumnaPor3() {
		Posicion2D posicion1 = new Posicion2D(2, 2);
		posicion1.setY(3);
		assertEquals(posicion1.getY(), 3);
	}
}
