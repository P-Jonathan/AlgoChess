package fiuba.algo3.AlgoChess.ataques;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public class AtaqueEncadenadoADistancia extends Ataque {
	private final int DANIO = 50;

	@Override
	public void atacar(Unidad atacante, Unidad objetivo) {
		objetivo.recibirDanio(DANIO);
	}
}
