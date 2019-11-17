package fiuba.algo3.AlgoChess.interfaces;

import fiuba.algo3.AlgoChess.tablero.Casilla;

public interface UnidadMovible {
	public void moverAdelante(Casilla[][] casillas);
	public void moverDerecha(Casilla[][] casillas);
	public void moverAbajo(Casilla[][] casillas);
	public void moverIzquierda(Casilla[][] casillas);
}