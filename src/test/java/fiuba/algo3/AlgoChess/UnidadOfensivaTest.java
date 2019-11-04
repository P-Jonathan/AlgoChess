package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.unidades.Unidad;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

public class UnidadOfensivaTest {
	@Test
	public void unidadOfensivaAtacaAUnidadOfensivaEnemigaYLeQuitaVida() {
		Tablero tablero = new Tablero();
		UnidadOfensiva soldadoAliado = new UnidadDeInfanteria("Test", tablero, new Posicion2D(1, 1));
		Unidad soldadoEnemigo = new UnidadDeInfanteria("Enemigo", tablero, new Posicion2D(2, 2));

		assertEquals(soldadoEnemigo.getVida(), 100);

		soldadoAliado.atacar(soldadoEnemigo);

		assertEquals(soldadoEnemigo.getVida(), 90);
	}
}
