package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;

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
	
	public void posicionarUnidad(Unidad unidad, Posicion2D posicion) {
		if(!tablero[ posicion.getX() - 1 ][ posicion.getY() - 1 ].ocupada()) {
			tablero[ posicion.getX() - 1 ][ posicion.getY() - 1 ].agregarUnidad(unidad);
			unidad.setPosicion(posicion);
		}
	}
	
	public Unidad obtenerUnidad(int fila, int columna) {
		return tablero[fila][columna].obtenerUnidad();
	}

	public Casilla getCasilla(Posicion2D posicion) {
	    return tablero[ posicion.getX() - 1 ][ posicion.getY() - 1 ];
	}

	public void moverUnidad(Unidad unidad, Posicion2D posicion) {
	    Casilla destino = getCasilla(posicion);

	    if(destino.ocupada()) {
	        throw new CasillaOcupadaException("Esta casilla ya tiene una unidad en ella");
        }

        Casilla origen = getCasilla(unidad.getPosicion());

        origen.quitarUnidad();
	    destino.agregarUnidad(unidad);
	    unidad.setPosicion(posicion);
    }

}
