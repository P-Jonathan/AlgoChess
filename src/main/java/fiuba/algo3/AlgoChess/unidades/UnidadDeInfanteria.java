package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.Movimiento;
import fiuba.algo3.AlgoChess.Posicion2D;
import fiuba.algo3.AlgoChess.ataques.Ataque;
import fiuba.algo3.AlgoChess.ataques.AtaqueACortaDistancia;
import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class UnidadDeInfanteria extends Unidad implements UnidadMovible, UnidadOfensiva {
	private final static int VIDA_INICIAL = 100;
	private final static int DANIO_INICIAL = 10;
	private final static int COSTO = 1;
	
	private Movimiento movimientoStrategy;
	private Ataque ataqueStrategy;

	public UnidadDeInfanteria(String bando, Tablero tablero, Posicion2D posicion) {
		super(bando, tablero, posicion, VIDA_INICIAL, COSTO);
		movimientoStrategy = new Movimiento(tablero, this);
		ataqueStrategy = new AtaqueACortaDistancia(DANIO_INICIAL);
	}

	public void mover(Posicion2D posicion) {
		movimientoStrategy.mover(posicion);
	}

	public void atacar(Unidad objetivo) {
		ataqueStrategy.atacar(this, objetivo);
	}

	@Override
	public void setAtaqueStrategy(Ataque ataque) {
		ataqueStrategy = ataque;
	}
}
