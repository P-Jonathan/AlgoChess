package fiuba.algo3.AlgoChess;

public abstract class Unidad {
	protected int vida;
	protected Tablero tablero;
	protected Posicion2D posicion;

	public Unidad() {}

	public Unidad (Tablero tablero) {
		this.tablero = tablero;
	}

	public void recibirDanio(int danio) { this.vida -= danio; };

	public void aumentarVida(int vida) { this.vida += vida; };

	public int getVida() { return vida; };

	public void setPosicion(Posicion2D posicion) {
		this.posicion = posicion;
	}

	public Posicion2D getPosicion() {
		return posicion;
	}
}