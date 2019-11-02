package fiuba.algo3.AlgoChess;

public class UnidadDeInfanteria extends Unidad {
	private int danio;
	
	public UnidadDeInfanteria() {
		vida = 100;
		danio = 10;
	}

	public void atacar(Unidad objetivo) {
		objetivo.recibirDanio(danio);
	}

}
