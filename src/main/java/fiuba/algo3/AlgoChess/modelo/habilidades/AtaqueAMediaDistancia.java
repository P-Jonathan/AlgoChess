package fiuba.algo3.AlgoChess.modelo.habilidades;

import fiuba.algo3.AlgoChess.modelo.excepciones.UnidadFueraDeRango;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;

public class AtaqueAMediaDistancia extends Habilidad {
	private int danio;

	AtaqueAMediaDistancia(Unidad portador, int danio) {
		super(portador);
		this.danio = danio;
	}

	@Override
	public void usarHabilidad(Unidad objetivo) {
		if(!objetivo.estaAMediaDistancia(portador))
			throw new UnidadFueraDeRango();

		objetivo.disminuirVida(danio);
	}
}
