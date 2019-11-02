package fiuba.algo3.AlgoChess;

public class Tablero {
	private int filas;
	private int columnas;
	private Casilla[][] tablero;
	
	public Tablero(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		tablero = new Casilla[filas][columnas];
	}
	
	public void posicionarUnidad(Unidad unidad, int fila, int columna) {
		if(!tablero[fila][columna].ocupada()) {
			tablero[fila][columna].agregarUnidad(unidad);
		}
	}
	
	public Unidad obtenerUnidad(int fila, int columna) {
		return tablero[fila][columna].obtenerUnidad();
	}
}
