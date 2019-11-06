package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.Movimiento;
import fiuba.algo3.AlgoChess.Posicion2D;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class Curandero extends Unidad {
	private final static int VIDA_INICIAL = 75;
	private final static int COSTO = 2;
	
	private Movimiento movimientoStrategy;
	private int curacion;

	public Curandero(String bando, Tablero tablero, Posicion2D posicion) {
		super(bando, tablero, posicion, VIDA_INICIAL, COSTO);
		movimientoStrategy = new Movimiento(tablero, this);
		curacion = 15;
	}
	
	public void mover(Posicion2D posicion) {
		movimientoStrategy.mover(posicion);
	}

	public void curar(Unidad objetivo) {
		objetivo.aumentarVida(curacion);
	}
}