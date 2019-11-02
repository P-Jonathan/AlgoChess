package fiuba.algo3.AlgoChess;

public class UnidadDeInfanteria {
	private int vida;
	
	public UnidadDeInfanteria() {
		this.vida = 100;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public void recibirDanio(int danio) {
		this.vida -= danio;
	}
}
