package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

public class UnidadDeInfanteriaTest {
    @Test
    public void unidadAtacaAUnidadEnemigaYLeQuitaVida() {
    	UnidadDeInfanteria unidadOfensiva = new UnidadDeInfanteria();
        UnidadDeInfanteria unidadEnemiga = new UnidadDeInfanteria();

        int vidaPrevia = unidadEnemiga.getVida();

        unidadOfensiva.atacar(unidadEnemiga);

        assertEquals(vidaPrevia - 10, unidadEnemiga.getVida());
    }
    
    @Test
	public void unUnidadDeInfanteriaIntentaMoverseALaDerecha2VecesYNoPuedoPosicionarUnaUnidadEnLaNuevaPosicion() {
		Tablero tablero = new Tablero("P1", "P2");
	
		UnidadDeInfanteria unidad1 = new UnidadDeInfanteria("P1");
	    UnidadDeInfanteria unidad2 = new UnidadDeInfanteria("P1");
	
	    tablero.posicionarUnidad(unidad1, 7,5);
	    tablero.moverUnidadDerecha(unidad1);
	    tablero.moverUnidadDerecha(unidad1);
	
	    assertThrows(CasillaOcupadaException.class, () -> {
	    	tablero.posicionarUnidad(unidad2, 7,7);
		});
	}
	@Test
	public void unUnidadDeInfanteriaIntentaMoverseALaIzquierda2VecesYNoPuedoPosicionarUnaUnidadEnLaNuevaPosicion() {
		Tablero tablero = new Tablero("P1", "P2");
	
		UnidadDeInfanteria unidad1 = new UnidadDeInfanteria("P1");
	    UnidadDeInfanteria unidad2 = new UnidadDeInfanteria("P1");
	
	    tablero.posicionarUnidad(unidad1, 7,5);
	    tablero.moverUnidadIzquierda(unidad1);
	    tablero.moverUnidadIzquierda(unidad1);
	    
	    assertThrows(CasillaOcupadaException.class, () -> {
	    	tablero.posicionarUnidad(unidad2, 7,3);
		});
	}
	@Test
	public void unUnidadDeInfanteriaIntentaMoverseALaArriba2VecesYNoPuedoPosicionarUnaUnidadEnLaNuevaPosicion() {
		Tablero tablero = new Tablero("P1", "P2");
	
		UnidadDeInfanteria unidad1 = new UnidadDeInfanteria("P1");
	    UnidadDeInfanteria unidad2 = new UnidadDeInfanteria("P1");
	
	    tablero.posicionarUnidad(unidad1, 7,5);
	    tablero.moverUnidadAdelante(unidad1);
	    tablero.moverUnidadAdelante(unidad1);
	    
	    
	    assertThrows(CasillaOcupadaException.class, () -> {
	    	tablero.posicionarUnidad(unidad2, 9,5);
		});
	}
	@Test
	public void unUnidadDeInfanteriaIntentaMoverseALaAbajo2VecesYNoPuedoPosicionarUnaUnidadEnLaNuevaPosicion() {
		Tablero tablero = new Tablero("P1", "P2");
	
		UnidadDeInfanteria unidad1 = new UnidadDeInfanteria("P1");
	    UnidadDeInfanteria unidad2 = new UnidadDeInfanteria("P1");
	
	    tablero.posicionarUnidad(unidad1, 7,5);
	    tablero.moverUnidadAtras(unidad1);
	    tablero.moverUnidadAtras(unidad1);
	
	    assertThrows(CasillaOcupadaException.class ,() -> {
	    	tablero.posicionarUnidad(unidad2, 5,5);
		});
	}
}