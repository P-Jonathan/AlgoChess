package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.tablero.Casilla;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Unidad;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {
	@Test
	public void creoUnTableroDe1x1NuevoYAlObtenerLaCasillaDeberiaEstarVacia() {
		Tablero tablero = new Tablero(1, 1);
		Casilla casilla = tablero.getCasilla(new Posicion2D(0, 0));

		assertFalse(casilla.ocupada());
	}

	@Test
	public void seColocaUnaUnidadAliadaEnUnCasilleroDelSectorAliadoVacioConExito() {
		Tablero tablero = new Tablero("Aliado", "Enemigo", 2, 5);
		Posicion2D posicion = new Posicion2D(0, 2);
		Unidad unidad = new UnidadDeInfanteria("Aliado", posicion);
		tablero.posicionarUnidad(unidad);

		assertEquals(unidad, tablero.getUnidad(posicion));
	}
	
	@Test
	public void seVerificaQueNoSePuedeColocarUnaUnidadAliadaEnUnCasilleroOcupadoEnElSectorAliado() {
		Tablero tablero = new Tablero("Aliado", "Enemigo", 2, 5);
		Posicion2D posicion = new Posicion2D(0, 2);
		@SuppressWarnings("unused")
		Unidad unidad = new UnidadDeInfanteria("Aliado", posicion);
		tablero.posicionarUnidad(unidad);
		Unidad unidad2 = new UnidadDeInfanteria("Aliado", posicion);

		assertThrows(RuntimeException.class, ()->{

			tablero.posicionarUnidad(unidad2);
		});
	}
	
	@Test
	public void seVerificaQueNoSePuedeColocarUnaPiezaAliadaEnUnCasilleroDelSectorEnemigo() {
		Tablero tablero = new Tablero("Aliado", "Enemigo", 2, 5);
		@SuppressWarnings("unused")
		Unidad unidad = new UnidadDeInfanteria("Aliado", new Posicion2D(0, 2));
		tablero.posicionarUnidad(unidad);
		Unidad unidad2 = new UnidadDeInfanteria("Enemigo", new Posicion2D(0, 3));
		assertThrows(RuntimeException.class, ()->{

			tablero.posicionarUnidad(unidad2);
		});
	}
}
