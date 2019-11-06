package fiuba.algo3.AlgoChess.ataques;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public class AtaqueJinete extends Ataque {
	private final static int DANIO_A_CORTA_DISTANCIA = 5;
	private final static int DANIO_A_MEDIA_DISTANCIA = 15;

	private final static Ataque ataqueACortaDistancia = new AtaqueACortaDistancia(DANIO_A_CORTA_DISTANCIA);
	private final static Ataque ataqueAMediaDistancia = new AtaqueAMediaDistancia(DANIO_A_MEDIA_DISTANCIA);

	@Override
	public void atacar(Unidad atacante, Unidad objetivo) {
		if (atacante.estaAMediaDistancia(objetivo)) {
			ataqueAMediaDistancia.atacar(atacante, objetivo);
		} else if (atacante.estaACortaDistancia(objetivo)) {
			ataqueACortaDistancia.atacar(atacante, objetivo);
		}
	}
}
