package fiuba.algo3.AlgoChess.modelo.habilidades;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;

public abstract class Habilidad {
	Unidad portador;

	public Habilidad(Unidad portador){
		this.portador = portador;
	}

	public abstract void usarHabilidad(Unidad objetivo);
}
