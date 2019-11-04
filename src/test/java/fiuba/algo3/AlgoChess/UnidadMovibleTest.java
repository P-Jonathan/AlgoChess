package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

public class UnidadMovibleTest {
	@Test
	public void creoUnaUnidadMovibleLaColocoEnElTableroNoLaMuevoYSuPosicionNoDeberiaCambiar() {
		Tablero tablero = new Tablero();
		UnidadMovible soldado = new UnidadDeInfanteria("Test", tablero, new Posicion2D(2, 2));

		assertEquals(soldado.getPosicion().getX(), 2);
		assertEquals(soldado.getPosicion().getY(), 2);
	}
	
	@Test
	public void creoUnaUnidadMovibleLaColocoEnElTableroLaMuevoYSuPosicionDeberiaCambiar() {
		Tablero tablero = new Tablero();
		UnidadMovible soldado = new UnidadDeInfanteria("Test", tablero, new Posicion2D(2, 2));

		soldado.mover(new Posicion2D(1, 1));

		assertEquals(soldado.getPosicion().getX(), 1);
		assertEquals(soldado.getPosicion().getY(), 1);
	}
	
	@Test
	public void unaUnidadMovibleNoDeberiaMoverseMasDeUnCasillero() {
		Tablero tablero = new Tablero();
		UnidadMovible soldado = new UnidadDeInfanteria("Test", tablero, new Posicion2D(2, 2));

		assertThrows(RuntimeException.class, ()->{
			soldado.mover(new Posicion2D(5, 5));
		});
	}
	
	@Test
	public void unaUnidadMovibleNoDeberiaMoverseAUnCasilleroOcupado() {
		Tablero tablero = new Tablero();
		UnidadMovible soldado1 = new UnidadDeInfanteria("Test", tablero, new Posicion2D(2, 2));
		@SuppressWarnings("unused")
		UnidadMovible soldado2 = new UnidadDeInfanteria("Test", tablero, new Posicion2D(2, 3));

		assertThrows(RuntimeException.class, ()->{
			soldado1.mover(new Posicion2D(2, 3));
		});
	}
}
