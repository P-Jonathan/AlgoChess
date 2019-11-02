package fiuba.algo3.AlgoChess;

public class Casilla {
	boolean ocupada;
	Unidad unidad;
	
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
	
	public Unidad obtenerUnidad() {
		return unidad;
	}
}
