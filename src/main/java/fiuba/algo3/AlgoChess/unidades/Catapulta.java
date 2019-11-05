package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.ataques.*;
import fiuba.algo3.AlgoChess.Posicion2D;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class Catapulta extends Unidad implements UnidadOfensiva {
	private Ataque ataque;

	public Catapulta(String bando, Tablero tablero, Posicion2D posicion) {
		super(bando, tablero, posicion, 50,  5);
		ataque = new AtaqueEncadenadoADistancia();
	}

	public void atacar(Unidad objetivo) {
		ataque.atacar(this, objetivo);
	}
	
	public void aumentarVida(int vida) {
		//Habria que tirar una Excepción.
	}


	@Override
	public void setAtaqueStrategy(Ataque ataque) {
		this.ataque = ataque;
	}
}
