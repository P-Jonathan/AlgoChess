package fiuba.algo3.AlgoChess;

public abstract class Unidad {
	protected int vida;

	public void recibirDanio(int danio) { this.vida -= danio; };

	public void aumentarVida(int vida) { this.vida += vida; };

	public int getVida() { return vida; };
}