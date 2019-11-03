package fiuba.algo3.AlgoChess;

public class Casilla {
	private boolean ocupada;
	private Unidad unidad;
	
	public Casilla() {
		ocupada = false;
	}
	
	public boolean ocupada() {
		return ocupada;
	}
	
	public void agregarUnidad(Unidad unidad) {
		this.unidad = unidad;
		ocupada = true;
	}

	public void quitarUnidad() {
		this.unidad = null;
		ocupada = false;
	}
	
	public Unidad obtenerUnidad() {
		return unidad;
	}
}
