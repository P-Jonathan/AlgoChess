package fiuba.algo3.algochess.modelo.habilidades;

import fiuba.algo3.algochess.modelo.excepciones.UnidadFueraDeRango;
import fiuba.algo3.algochess.modelo.unidades.Unidad;

public class AtaqueALargaDistancia extends Habilidad {
	private int danio;

	public AtaqueALargaDistancia(Unidad portador, int danio) {
		super(portador);
		this.danio = danio;
	}

	@Override
	public void usarHabilidad(Unidad objetivo) {
		if(!objetivo.estaALargaDistancia(portador))
			throw new UnidadFueraDeRango();

		objetivo.disminuirVida(danio);
	}
}
