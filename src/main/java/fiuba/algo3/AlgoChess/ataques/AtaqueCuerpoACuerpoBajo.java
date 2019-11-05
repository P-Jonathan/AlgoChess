package fiuba.algo3.AlgoChess.ataques;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public class AtaqueCuerpoACuerpoBajo extends Ataque {
	private final int DANIO = 5;
	
	@Override
	public void atacar(Unidad atacante, Unidad objetivo) {
		if(!atacante.aliado(objetivo) && atacante.estaACortaDistancia(objetivo)) {
			objetivo.recibirDanio(DANIO);
		}
	}
}
