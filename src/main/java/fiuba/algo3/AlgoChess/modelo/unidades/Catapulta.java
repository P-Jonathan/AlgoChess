package fiuba.algo3.AlgoChess.modelo.unidades;

import fiuba.algo3.AlgoChess.modelo.habilidades.Habilidad;
import fiuba.algo3.AlgoChess.modelo.habilidades.AtaqueEncadenadoADistancia;
import fiuba.algo3.AlgoChess.modelo.tablero.Jugador;

public class Catapulta extends Unidad {
	private final static int VIDA_INICIAL = 50;
	private final static int COSTO = 5;

	private Habilidad habilidad;

	public Catapulta(Jugador propietario) {
		super(propietario, VIDA_INICIAL, COSTO);
		habilidad = new AtaqueEncadenadoADistancia(this);
	}

	public Catapulta() {
		super(VIDA_INICIAL, COSTO);
		habilidad = new AtaqueEncadenadoADistancia(this);
	}

	// Esta unidad no puede curarse.
	@Override
	public void aumentarVida(int vida) {
		throw new RuntimeException();
	}

	@Override
	public void usarHabilidad(Unidad objetivo) {
		habilidad.usarHabilidad(objetivo);
	}

	// Esta unidad no puede moverse.
	@Override
	public void moverHaciaAdelante() {
		throw new RuntimeException();
	}

	@Override
	public void moverALaDerecha() {
		throw new RuntimeException();
	}

	@Override
	public void moverHaciaAtras() {
		throw new RuntimeException();
	}

	@Override
	public void moverALaIzquierda() {
		throw new RuntimeException();
	}
}
