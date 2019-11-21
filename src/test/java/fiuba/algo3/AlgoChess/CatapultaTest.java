package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.unidades.Catapulta;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatapultaTest {
	@Test
	public void creoCatapultaLeAumentoLaVidaEn20PeroSuVidaSigueSiendoLaMisma() {
		Catapulta catapulta = new Catapulta();
		
		int vidaPrevia = catapulta.getVida();
		
		catapulta.aumentarVida(50);
		
		assertEquals(vidaPrevia, catapulta.getVida());
	}
	
	@Test
	public void catapultaIntentaAtacarAUnObjetivoPeroNoEstaEnRango() {
		Tablero tablero = new Tablero();

		Catapulta catapulta = new Catapulta();
		tablero.posicionarUnidad(catapulta, 0,0);

		UnidadDeInfanteria objetivo = new UnidadDeInfanteria();
        tablero.posicionarUnidad(objetivo, 1, 1);

		int vidaPrevia = objetivo.getVida();
		
		tablero.atacarConUnidadAUnidad(catapulta, objetivo);
		
		assertEquals(objetivo.getVida(), vidaPrevia);
	}
	
	@Test
	public void catapultaAtacaAUnObjetivoYLeResta20DeVidaAlObjetivoYAUnaUnidadQueEstaJuntoAElla() {
		Tablero tablero = new Tablero();

		Catapulta catapulta = new Catapulta();
		tablero.posicionarUnidad(catapulta, 0,0);

		UnidadDeInfanteria objetivo = new UnidadDeInfanteria();
		UnidadDeInfanteria adyacente = new UnidadDeInfanteria();
		tablero.posicionarUnidad(objetivo, 11, 11);
		tablero.posicionarUnidad(adyacente, 12, 11);

		int vidaPreviaObjetivo = objetivo.getVida();
		int vidaPreviaAdyacente = adyacente.getVida();
		tablero.atacarConUnidadAUnidad(catapulta,objetivo);
		
		
		assertEquals(objetivo.getVida(), vidaPreviaObjetivo - 20);
		assertEquals(adyacente.getVida(), vidaPreviaAdyacente - 20);
	}

}
