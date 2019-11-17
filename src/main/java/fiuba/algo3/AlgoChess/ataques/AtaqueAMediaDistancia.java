package fiuba.algo3.AlgoChess.ataques;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public class AtaqueAMediaDistancia extends Ataque {
	private int danio;

	public AtaqueAMediaDistancia(int danio) {
		this.danio = danio;
	}

	@Override
	public void atacar(Unidad objetivo) {
		objetivo.recibirDanio(danio);
	}
}
