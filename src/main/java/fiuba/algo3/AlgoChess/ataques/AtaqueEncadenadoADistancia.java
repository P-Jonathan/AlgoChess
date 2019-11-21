package fiuba.algo3.AlgoChess.ataques;

import java.util.ArrayList;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public class AtaqueEncadenadoADistancia extends Ataque {
	private final static int DANIO = 20;
	private ArrayList<Unidad> unidadesAdyacentes;

	public AtaqueEncadenadoADistancia() {}
	
	
	public AtaqueEncadenadoADistancia(ArrayList<Unidad> enemigosAdyacentes) {
		unidadesAdyacentes = enemigosAdyacentes;
	}

	@Override
	public void atacar(Unidad objetivo) {
		objetivo.recibirDanio(DANIO);
		unidadesAdyacentes.forEach((n) -> n.recibirDanio(DANIO));
	}
}
