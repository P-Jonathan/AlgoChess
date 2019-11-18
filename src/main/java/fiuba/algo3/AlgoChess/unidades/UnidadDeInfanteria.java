package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.ataques.*;
import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.tablero.Casilla;

public class UnidadDeInfanteria extends Unidad implements UnidadMovible, UnidadOfensiva {
	private final static int VIDA_INICIAL = 100;
	private final static int DANIO_INICIAL = 10;
	private final static int COSTO = 1;

	private Ataque ataque;

	public UnidadDeInfanteria(String bando) {
		super(bando, VIDA_INICIAL, COSTO);
		ataque = new AtaqueACortaDistancia(DANIO_INICIAL);
	}

	public UnidadDeInfanteria() {
		super("", VIDA_INICIAL, COSTO);
		ataque = new AtaqueACortaDistancia(DANIO_INICIAL);
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


	public void prepararAtaqueADistancia(double distancia) {
		if(distancia > 6)
			ataque = new AtaqueEncadenadoADistancia();
		else
			ataque = new AtaqueNull();
	}

	@Override
	public void prepararAtaque(Casilla[][] casillas, Unidad objetivo) {
		double distanciaAObjetivo = casillaActual.distanciaAUnidad(casillas, objetivo);

		if(distanciaAObjetivo > 0 && distanciaAObjetivo <= 3)
			ataque = new AtaqueACortaDistancia(DANIO_INICIAL);
		else
			ataque = new AtaqueNull();
	}

	@Override
	public void atacar(Unidad objetivo) {
		ataque.atacar(objetivo);
	}
}
