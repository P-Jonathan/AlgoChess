package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CatapultaTest {

	@Test
	public void creoCatapultaYAlQuitarle25DeVidaLeQuedan25() {
		Catapulta catapulta = new Catapulta();
		assertEquals(catapulta.getVida(), 50);
		catapulta.recibirDanio(25);
		assertEquals(catapulta.getVida(), 25);
	}
	
	@Test 
	public void creoCatapultaLeAumentoLaVidaEn20PeroSuVidaSigueSiendo50() {
		Catapulta catapulta = new Catapulta();
		assertEquals(catapulta.getVida(), 50);
		catapulta.aumentarVida(20);
		assertEquals(catapulta.getVida(), 50);
	}
	
	@Test
	public void CatapultaAtacaAUnObjetivoYLeResta20DeVidaAlObjetivo() {
		Catapulta catapulta = new Catapulta();
		Unidad objetivo = new UnidadDeInfanteria();
		assertEquals(objetivo.getVida(),100);
		catapulta.atacarADistancia(objetivo);
		assertEquals(objetivo.getVida(),80);
	}



}
