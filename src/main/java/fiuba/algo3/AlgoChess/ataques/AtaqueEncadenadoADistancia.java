package fiuba.algo3.AlgoChess.ataques;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public class AtaqueEncadenadoADistancia extends Ataque {
	private final static int DANIO = 20;
	
	private final static Ataque ataque = new AtaqueALargaDistancia(DANIO);
	@Override
	public void atacar(Unidad atacante, Unidad objetivo) {
		ataque.atacar(atacante,objetivo);
	}
}
