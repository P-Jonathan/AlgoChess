package fiuba.algo3.AlgoChess.ataques;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public class AtaqueALargaDistanciaMedio extends Ataque {
	private final int DANIO = 15;

	@Override
	public void atacar(Unidad atacante, Unidad objetivo) {
		if (!atacante.aliado(objetivo) && atacante.estaALargaDistancia(objetivo)) {
			objetivo.recibirDanio(DANIO);
		}
	}
}
