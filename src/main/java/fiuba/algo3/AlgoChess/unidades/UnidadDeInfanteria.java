package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.Movimiento;
import fiuba.algo3.AlgoChess.Posicion2D;
import fiuba.algo3.AlgoChess.Tablero;
import fiuba.algo3.AlgoChess.ataques.Ataque;
import fiuba.algo3.AlgoChess.ataques.AtaqueCuerpoACuerpoMedio;
import fiuba.algo3.AlgoChess.interfaces.*;

public class UnidadDeInfanteria extends Unidad implements UnidadMovible, UnidadOfensiva {
	private Movimiento movimientoStrategy;
	private Ataque ataqueStrategy;
	
	public UnidadDeInfanteria(String bando, Tablero tablero, Posicion2D posicion) {
		super(bando, tablero, posicion, 100);
		movimientoStrategy = new Movimiento(tablero, this);
		ataqueStrategy = new AtaqueCuerpoACuerpoMedio();
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
