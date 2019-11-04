package fiuba.algo3.AlgoChess.ataques;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public class AtaqueEncadenadoADistancia extends Ataque {
	private final int DANIO = 20;

	@Override
	public void atacar(Unidad atacante, Unidad objetivo) {
		objetivo.recibirDanio(DANIO);
	}
}
