package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public class Casilla {
	private boolean ocupada;
	private Unidad unidad;
	
	public Casilla() {
		ocupada = false;
	}
	
	public boolean ocupada() {
		return ocupada;
	}
	
	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
		ocupada = true;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void popUnidad() {
		this.unidad = null;
		ocupada = false;
	}
}
