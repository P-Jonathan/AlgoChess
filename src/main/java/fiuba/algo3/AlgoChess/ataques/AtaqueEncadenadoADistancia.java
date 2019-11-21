package fiuba.algo3.AlgoChess.ataques;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public class AtaqueEncadenadoADistancia extends Ataque {
	private final static int DANIO = 20;
	private final static int DANIO_DE_PROPAGACION = 15;

	@Override
	public void atacar(Unidad objetivo) {
		objetivo.recibirDanio(DANIO);
	}
}
