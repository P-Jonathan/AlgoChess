package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.Posicion2D;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class Curandero extends Unidad {
	private int curacion;

	public Curandero(String bando, Tablero tablero, Posicion2D posicion) {
		super(bando, tablero, posicion, 75);
		curacion = 15;
	}

	public void curar(Unidad objetivo) {
		objetivo.aumentarVida(curacion);
	}

}