package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.ataques.*;
import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.tablero.Casilla;

public class Jinete extends Unidad implements UnidadMovible, UnidadOfensiva {
	private final static int VIDA_INICIAL = 100;
	private final static int COSTO = 3;

	private Ataque ataque;

	private final static int DANIO_CORTA_DISTANCIA = 5;
	private final static int DANIO_MEDIA_DISTANCIA = 15;

	public Jinete(String bando) {
		super(bando, VIDA_INICIAL, COSTO);
		ataque = new AtaqueACortaDistancia(DANIO_CORTA_DISTANCIA);
	}

	public Jinete() {
		super("", VIDA_INICIAL, COSTO);
		ataque = new AtaqueACortaDistancia(DANIO_CORTA_DISTANCIA);
	}

	@Override
	public void moverAdelante(Casilla[][] casillas) {
		Casilla destino = casillaActual.casillaAdelante(casillas);

		destino.ocuparCon(this);
		casillaActual.desocupar();
		casillaActual = destino;
		filaActual++;
	}

	@Override
	public void moverDerecha(Casilla[][] casillas) {
		Casilla destino = casillaActual.casillaDerecha(casillas);

		destino.ocuparCon(this);
		casillaActual.desocupar();
		casillaActual = destino;
		columnaActual++;
	}

	@Override
	public void moverAbajo(Casilla[][] casillas) {
		Casilla destino = casillaActual.casillaTrasera(casillas);

		destino.ocuparCon(this);
		casillaActual.desocupar();
		casillaActual = destino;
		filaActual--;
	}

	@Override
	public void moverIzquierda(Casilla[][] casillas) {
		Casilla destino = casillaActual.casillaIzquierda(casillas);

		destino.ocuparCon(this);
		casillaActual.desocupar();
		casillaActual = destino;
		columnaActual--;
	}

	@Override
	public void prepararAtaqueADistancia(double distancia) {
		if(distancia > 0 && distancia <= 3)
			ataque = new AtaqueACortaDistancia(DANIO_CORTA_DISTANCIA);
		else if(distancia > 3 && distancia <= 6)
			ataque = new AtaqueAMediaDistancia(DANIO_MEDIA_DISTANCIA);
		else
			ataque = new AtaqueNull();
	}

	@Override
	public void atacar(Unidad enemigo) {
		ataque.atacar(enemigo);
	}
}
