package fiuba.algo3.AlgoChess;

public abstract class Unidad {
	int vida;
	public abstract void recibirDanio(int danio);
	public abstract void aumentarVida(int vida);
	public abstract int getVida();
}