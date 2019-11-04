package fiuba.algo3.AlgoChess.interfaces;

import fiuba.algo3.AlgoChess.Posicion2D;

public interface UnidadMovible {
	public void mover(Posicion2D posicion);
	public Posicion2D getPosicion();
}