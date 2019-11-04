package fiuba.algo3.AlgoChess.unidades;

import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.AlgoChess.Posicion2D;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public abstract class Unidad {
	protected int vida;
	protected String bando;
	protected Tablero tablero;
	protected Posicion2D posicion;

	public Unidad(String bando, Tablero tablero, Posicion2D posicion, int vida) {
		this.vida = vida;
		this.bando = bando;
		this.tablero = tablero;
		this.posicion = posicion;
		tablero.posicionarUnidad(this, posicion);
	}

	public void setPosicion(Posicion2D posicion) {
		this.posicion = posicion;
	}

	public Posicion2D getPosicion() {
		return posicion;
	}

	public void recibirDanio(int danio) {
		this.vida -= danio;
	};

	public void aumentarVida(int vida) {
		this.vida += vida;
	};

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVida() {
		return vida;
	};

	public boolean aliado(Unidad unidad) {
		return this.bando == unidad.bando;
	}

	public boolean esAdyacente(Unidad unidad) {
		return this.getPosicion().adyacente(unidad.getPosicion());
	}

	public List<Unidad> unidadesAdyacentes() {
		List<Unidad> unidades = new LinkedList<Unidad>();
		
		for (int i = posicion.getX() - 1; i < posicion.getX() + 1; i++) {
			for (int j = posicion.getY() - 1; j < posicion.getY() + 1; j++) {
				Unidad unidad = tablero.getUnidad(new Posicion2D(i, j));
				unidades.add(unidad);
			}
		}

		return unidades;
	}
}