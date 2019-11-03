package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;

public class UnidadDeInfanteria extends Unidad implements UnidadMovible {
	private int danio;

	public UnidadDeInfanteria() {
		vida = 100;
		danio = 10;
	}
	
	public UnidadDeInfanteria(Tablero tablero) {
		super(tablero);
		vida = 100;
		danio = 10;
	}

	public void mover(Posicion2D posicion) {
		tablero.moverUnidad(this, posicion);
	}

	public void atacar(Unidad objetivo) {
		objetivo.recibirDanio(danio);
	}

}
