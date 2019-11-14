package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.Movimiento;
import fiuba.algo3.AlgoChess.Posicion2D;
import fiuba.algo3.AlgoChess.ataques.Ataque;
import fiuba.algo3.AlgoChess.ataques.AtaqueJinete;
import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class Jinete extends Unidad implements UnidadMovible, UnidadOfensiva {
	private final static int VIDA_INICIAL = 100;
	private final static int COSTO = 3;

	private Movimiento movimientoStrategy;
	private Ataque ataqueStrategy;

	public Jinete(String bando, Posicion2D posicion) {
		super(bando, posicion, VIDA_INICIAL, COSTO);
		setAtaqueStrategy(new AtaqueJinete());
		movimientoStrategy = new Movimiento(tablero, this);
	}

	@Override
	public void atacar(Unidad enemigo) {
		ataqueStrategy.atacar(this, enemigo);
	}

	@Override
	public void setAtaqueStrategy(Ataque ataque) {
		ataqueStrategy = ataque;
	}

	@Override
	public void mover(Posicion2D posicion) {
		movimientoStrategy.mover(posicion);
	}

}
