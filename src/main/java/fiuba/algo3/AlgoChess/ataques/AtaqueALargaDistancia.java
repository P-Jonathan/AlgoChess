package fiuba.algo3.AlgoChess.ataques;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public class AtaqueALargaDistancia extends Ataque {
	private int danio;
	
	public AtaqueALargaDistancia(int danio) {
		this.danio = danio;
	}

	@Override
	public void atacar(Unidad atacante, Unidad objetivo) {
		if (!atacante.aliado(objetivo) && atacante.estaALargaDistancia(objetivo)) {
			objetivo.recibirDanio(this.danio);
		}
	}
}
