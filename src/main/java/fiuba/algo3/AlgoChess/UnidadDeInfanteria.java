package fiuba.algo3.AlgoChess;

public class UnidadDeInfanteria extends Unidad {
	
	public UnidadDeInfanteria() {
		vida = 100;
	}
	
	@Override
	public int getVida() {
		return vida;
	}
	
	@Override
	public void recibirDanio(int danio) {
		vida -= danio;
	}

	@Override
	public void aumentarVida(int vida) {
		this.vida += vida;
	}
}
