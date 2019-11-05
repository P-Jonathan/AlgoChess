package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.Posicion2D;
import fiuba.algo3.AlgoChess.ataques.*;
import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class Jinete extends Unidad implements UnidadMovible, UnidadOfensiva {
	private Ataque ataqueCuerpoACuerpoStrategy;
	private Ataque ataqueADistanciaStrategy;

	public Jinete(String bando, Tablero tablero, Posicion2D posicion) {
		super(bando, tablero, posicion, 100);
		ataqueCuerpoACuerpoStrategy = new AtaqueCuerpoACuerpoBajo();
		ataqueADistanciaStrategy = new AtaqueALargaDistanciaMedio();
	}

	@Override
	public void atacar(Unidad enemigo) {
		if(this.estaACortaDistancia(enemigo)) {
			ataqueCuerpoACuerpoStrategy.atacar(this, enemigo);
		} else if (this.estaALargaDistancia(enemigo)) {
			ataqueADistanciaStrategy.atacar(this, enemigo);
		}
	}

	@Override
	public void setAtaqueStrategy(Ataque ataque) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(Posicion2D posicion) {
		// TODO Auto-generated method stub
		
	}

}
