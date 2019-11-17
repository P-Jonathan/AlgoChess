package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;
import fiuba.algo3.AlgoChess.tablero.Casilla;

public class Curandero extends Unidad implements UnidadMovible {
	private final static int VIDA_INICIAL = 75;
	private final static int COSTO = 2;

	private int curacion;

	public Curandero(String bando) {
		super(bando, VIDA_INICIAL, COSTO);
		curacion = 15;
	}

	public Curandero() {
		super("", VIDA_INICIAL, COSTO);
		curacion = 15;
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

	public void curar(Unidad objetivo) {
		objetivo.aumentarVida(curacion);
	}
}