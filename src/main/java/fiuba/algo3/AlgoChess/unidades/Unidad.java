package fiuba.algo3.AlgoChess.unidades;

import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.AlgoChess.Posicion2D;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public abstract class Unidad {
	protected int vida;
	protected int costo;
	protected String bando;
	protected Tablero tablero;
	protected Posicion2D posicion;
	
	protected int DISTANCIA_CERCANA_MAX = 2;
	protected int DISTANCIA_MEDIA_MAX = 5;

	public Unidad(String bando, Tablero tablero, Posicion2D posicion, int vida, int costo) {
		this.vida = vida;
		this.costo = costo;
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

	public int getCosto(){return costo;};

	public boolean aliado(Unidad unidad) {
		return this.bando == unidad.bando;
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
	
	public boolean esAdyacente(Unidad unidad) {
		return this.getPosicion().adyacente(unidad.getPosicion());
	}
	
	public boolean estaACortaDistancia(Unidad objetivo) {
		double distancia = this.getPosicion().distancia(objetivo.getPosicion());
		return distancia <= DISTANCIA_CERCANA_MAX;
	}

	public boolean estaAMediaDistancia(Unidad objetivo) {
		double distancia = this.getPosicion().distancia(objetivo.getPosicion());
		return distancia > DISTANCIA_CERCANA_MAX && distancia <= DISTANCIA_MEDIA_MAX;
	}
	
	public boolean estaALargaDistancia(Unidad objetivo) {
		double distancia = this.getPosicion().distancia(objetivo.getPosicion());
		return distancia > DISTANCIA_MEDIA_MAX;
	}
}