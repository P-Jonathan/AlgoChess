package fiuba.algo3.AlgoChess.modelo.unidades;

import fiuba.algo3.AlgoChess.modelo.habilidades.Curacion;
import fiuba.algo3.AlgoChess.modelo.habilidades.Habilidad;
import fiuba.algo3.AlgoChess.modelo.tablero.Jugador;

public class Curandero extends Unidad {
	private final static int VIDA_INICIAL = 75;
	private final static int COSTO = 2;

	private Habilidad habilidad;

	public Curandero(Jugador propietario) {
		super(propietario, VIDA_INICIAL, COSTO);
		habilidad = new Curacion(this);
	}

	public Curandero() {
		super(VIDA_INICIAL, COSTO);
		habilidad = new Curacion(this);
	}

    @Override
    public void usarHabilidad(Unidad objetivo) {
		habilidad.usarHabilidad(objetivo);
    }
}