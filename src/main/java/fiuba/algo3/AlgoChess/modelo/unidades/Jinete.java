package fiuba.algo3.AlgoChess.modelo.unidades;

import fiuba.algo3.AlgoChess.modelo.tablero.Jugador;
import fiuba.algo3.AlgoChess.modelo.habilidades.Habilidad;
import fiuba.algo3.AlgoChess.modelo.habilidades.AtaqueJinete;

public class Jinete extends Unidad {
	private final static int VIDA_INICIAL = 100;
	private final static int COSTO = 3;

	private Habilidad habilidad;

	public Jinete(Jugador propietario) {
		super(propietario, VIDA_INICIAL, COSTO);
		habilidad = new AtaqueJinete(this);
	}

	public Jinete() {
		super(VIDA_INICIAL, COSTO);
		habilidad = new AtaqueJinete(this);
	}

	@Override
	public void usarHabilidad(Unidad objetivo) {
		habilidad.usarHabilidad(objetivo);
	}
}
