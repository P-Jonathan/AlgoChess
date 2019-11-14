package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Catapulta;
import fiuba.algo3.AlgoChess.unidades.Unidad;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

public class CatapultaTest {
	@Test
	public void creoCatapultaLeAumentoLaVidaEn20PeroSuVidaSigueSiendoLaMisma() {
		Catapulta catapulta = new Catapulta("Test", new Posicion2D(0, 0));
		
		int vidaPrevia = catapulta.getVida();
		
		catapulta.aumentarVida(50);
		
		assertEquals(vidaPrevia, catapulta.getVida());
	}
	
	@Test
	public void catapultaIntentaAtacarAUnObjetivoPeroNoEstaEnRango() {
		Tablero tablero = new Tablero("Test", "Enemigo", 2, 5);
		Catapulta catapulta = new Catapulta("Test", new Posicion2D(0, 0));
		tablero.posicionarUnidad(catapulta);
		Unidad objetivo = new UnidadDeInfanteria("Enemigo", new Posicion2D(1, 0));
        tablero.posicionarUnidad(objetivo);
		int vidaPrevia = objetivo.getVida();
		
		catapulta.atacar(objetivo);
		
		assertEquals(objetivo.getVida(), vidaPrevia);
	}
	
	@Test
	public void catapultaAtacaAUnObjetivoYLeResta20DeVidaAlObjetivo() {
		Tablero tablero = new Tablero("Test", "Enemigo", 2, 10);
		Catapulta catapulta = new Catapulta("Test", new Posicion2D(0, 0));
		tablero.posicionarUnidad(catapulta);
		Unidad objetivo = new UnidadDeInfanteria("Enemigo", new Posicion2D(1, 9));
		tablero.posicionarUnidad(objetivo);
		int vidaPrevia = objetivo.getVida();
		
		catapulta.atacar(objetivo);
		
		assertEquals(objetivo.getVida(), vidaPrevia - 20);
	}

}
