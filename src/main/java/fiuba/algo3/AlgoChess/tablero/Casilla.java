package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.unidades.Unidad;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

public class Casilla {
	private boolean ocupada;
	private Unidad unidad;
	private String bando;

	public Casilla() {
		ocupada = false;
	}

	public boolean ocupada() {
		return ocupada;
	}

	public void setUnidad(Unidad unidad) {
		if (ocupada) {
			throw new RuntimeException();
		}
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

	public void setBando(String bando) {
		this.bando = bando;
	}

	public String getBando() {
		return bando;
	}

}