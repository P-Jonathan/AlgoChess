package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fiuba.algo3.AlgoChess.unidades.Unidad;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

public class UnidadMovibleTest {
	@Test
	public void creoUnaUnidadMovibleNoLaMuevoYSuPosicionNoDeberiaCambiar() {
		Tablero tablero = new Tablero("Test", "Enemigo");
		Unidad soldado = new UnidadDeInfanteria("Test", new Posicion2D(2, 2));
        tablero.posicionarUnidad(soldado);
		assertEquals(soldado.getPosicion().getX(), 2);
		assertEquals(soldado.getPosicion().getY(), 2);
	}
	
	@Test
	public void creoUnaUnidadMovibleLaMuevoYSuPosicionDeberiaCambiar() {
		Tablero tablero = new Tablero("Test", "Enemigo");
		UnidadDeInfanteria soldado = new UnidadDeInfanteria("Test", new Posicion2D(2, 2));
        tablero.posicionarUnidad(soldado);
		tablero.moverUnidad(soldado,new Posicion2D(1, 1));

		assertEquals(soldado.getPosicion().getX(), 1);
		assertEquals(soldado.getPosicion().getY(), 1);
	}
	
	@Test
	public void unaUnidadMovibleNoDeberiaMoverseMasDeUnCasillero() {
		Tablero tablero = new Tablero("Test", "Enemigo",4,4);
		UnidadDeInfanteria soldado = new UnidadDeInfanteria("Test", new Posicion2D(1, 2));
        tablero.posicionarUnidad(soldado);
		assertThrows(RuntimeException.class, ()->{
			tablero.moverUnidad(soldado,new Posicion2D(5, 5));
		});
	}
	
	@Test
	public void unaUnidadMovibleNoDeberiaMoverseAUnCasilleroOcupado() {
		Tablero tablero = new Tablero("Test", "Enemigo");
		UnidadDeInfanteria soldado1 = new UnidadDeInfanteria("Test", new Posicion2D(2, 2));
		tablero.posicionarUnidad(soldado1);
		UnidadDeInfanteria soldado2 = new UnidadDeInfanteria("Test", new Posicion2D(2, 3));
        tablero.posicionarUnidad(soldado2);
		assertThrows(RuntimeException.class, ()->{
			tablero.moverUnidad(soldado1,new Posicion2D(2, 3));
		});
	}
}
