package fiuba.algo3.AlgoChess;

import static java.lang.Math.abs;

public class Posicion2D {
	private int x;
	private int y;
	
	public Posicion2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x; 
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isEquals(Posicion2D posicion) {
		return this.x == posicion.getX() && this.y == posicion.getY();
	}
	
	public boolean adyacente(Posicion2D posicion) {
		int distanciaEnX = abs(this.x - posicion.getX());
		int distanciaEnY = abs(this.y - posicion.getY());
		return distanciaEnX <= 1 && distanciaEnY <= 1;
	}

	/* Redondea para arriba (2.8 es 3) */
	public int distanciaA(Posicion2D posicion) {
		int cateto1 = this.x - posicion.getX();
		int cateto2 = this.y - posicion.getY();
		double hipotenusa = Math.sqrt(cateto1*cateto1 + cateto2*cateto2);

		return (int) Math.round(hipotenusa);
	}
}