package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.Posicion2D;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class Jinete extends Unidad {
	private int danioMelee;
	private int danioADistancia;

	public Jinete(String bando, Tablero tablero, Posicion2D posicion) {
		super(bando, tablero, posicion, 100);
		danioADistancia = 15;
		danioMelee = 5;
	}

	public void atacarAMelee(Unidad objetivo) {
		objetivo.recibirDanio(danioMelee);
	}

	public void atacarADistancia(Unidad objetivo) {
		objetivo.recibirDanio(danioADistancia);
	}

}
