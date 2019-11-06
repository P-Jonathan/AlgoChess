package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.ataques.*;
import fiuba.algo3.AlgoChess.Posicion2D;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class Catapulta extends Unidad implements UnidadOfensiva {
	private final static int VIDA_INICIAL = 50;
	private final static int COSTO = 5;

	private Ataque ataqueStrategy;

	public Catapulta(String bando, Tablero tablero, Posicion2D posicion) {
		super(bando, tablero, posicion, VIDA_INICIAL, COSTO);
		ataqueStrategy = new AtaqueEncadenadoADistancia();
	}

	public void atacar(Unidad objetivo) {
		ataqueStrategy.atacar(this, objetivo);
	}

	public void aumentarVida(int vida) {
		// Habria que tirar una Excepción.
	}

	@Override
	public void setAtaqueStrategy(Ataque ataque) {
		this.ataqueStrategy = ataque;
	}
}
