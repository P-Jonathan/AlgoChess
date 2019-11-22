package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.ataques.*;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.tablero.Casilla;

import java.util.ArrayList;

public class Catapulta extends Unidad implements UnidadOfensiva {
	private final static int VIDA_INICIAL = 50;
	private final static int COSTO = 5;

	private Ataque ataque;

	public Catapulta(String bando) {
		super(bando, VIDA_INICIAL, COSTO);
		ataque = new AtaqueEncadenadoADistancia();
	}

	public Catapulta() {
		super("", VIDA_INICIAL, COSTO);
		ataque = new AtaqueEncadenadoADistancia();
	}

	@Override
	public void prepararAtaque(Casilla[][] casillas, Unidad objetivo) {
		double distanciaAObjetivo = casillaActual.distanciaAUnidad(casillas, objetivo);
		ArrayList<Unidad> enemigosAdyacentes = objetivo.getUnidadesAdyacentes(casillas);
		if(distanciaAObjetivo > 6)
			ataque = new AtaqueEncadenadoADistancia(enemigosAdyacentes);
		else
			ataque = new AtaqueNull();
	}

	@Override
	public void atacar(Unidad objetivo) {
		ataque.atacar(objetivo);
	}
	
	@Override
	public void aumentarVida(int vida) {
	}
}
