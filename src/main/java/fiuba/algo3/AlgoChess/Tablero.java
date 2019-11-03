package fiuba.algo3.AlgoChess;

public class Tablero {
	private int filas;
	private int columnas;
	private Casilla[][] tablero;
	
	public Tablero(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
        setTablero();
	}

	private void setTablero() {
        tablero = new Casilla[filas][columnas];

	    for(int i = 0; i < filas; i++) {
	        for(int j = 0; j < columnas; j++) {
	            tablero[i][j] = new Casilla();
            }
        }
    }
	
	public void posicionarUnidad(Unidad unidad, int fila, int columna) {
		if(!tablero[fila][columna].ocupada()) {
			tablero[fila][columna].agregarUnidad(unidad);
		}
	}
	
	public Unidad obtenerUnidad(int fila, int columna) {
		return tablero[fila][columna].obtenerUnidad();
	}

	public Casilla getCasilla(Posicion2D posicion) {
	    return tablero[ posicion.getX() - 1 ][ posicion.getY() - 1 ];
	}

}
