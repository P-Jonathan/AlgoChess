package fiuba.algo3.AlgoChess.ataques;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public class AtaqueACortaDistancia extends Ataque {
	private int danio;

	public AtaqueACortaDistancia(int danio) {
		this.danio = danio;
	}

	@Override
	public void atacar(Unidad atacante, Unidad objetivo) {
		if (!atacante.aliado(objetivo) && atacante.estaACortaDistancia(objetivo)) {
			objetivo.recibirDanio(this.danio);
		}
	}
}
