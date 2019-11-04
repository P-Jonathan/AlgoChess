package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Unidad;

public class Movimiento {
	private Tablero tablero;
	private Unidad unidad;

	public Movimiento(Tablero tablero, Unidad unidad) {
		this.tablero = tablero;
		this.unidad = unidad;
	}

	public void mover(Posicion2D posicion) {
		if (unidad.getPosicion().adyacente(posicion)) {
			tablero.moverUnidad(unidad, posicion);
		} else {
			throw new RuntimeException();
		}
	}
}
