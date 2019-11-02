package fiuba.algo3.AlgoChess;

public class Catapulta extends Unidad {
	private int danio;
	
	public Catapulta() {
		vida = 50;
		danio = 20;
	}

	public void atacarADistancia(Unidad objetivo) {
		objetivo.recibirDanio(danio);
	}
	
	public void aumentarVida(int vida) {
		//Habria que tirar una Excepción.
	}
}
