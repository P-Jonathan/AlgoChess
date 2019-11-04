package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.unidades.Unidad;

public class Tablero {
	private final int FILAS_DEFAULT = 20;
	private final int COLUMNAS_DEFUALT = 20;

	private Casilla[][] tablero;
	private int columnas;
	private int filas;

	public Tablero() {
		this.filas = FILAS_DEFAULT;
		this.columnas = COLUMNAS_DEFUALT;
		setTablero();
	}

	public Tablero(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		setTablero();
	}

	private void setTablero() {
		tablero = new Casilla[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = new Casilla();
			}
		}
	}

	public void posicionarUnidad(Unidad unidad, Posicion2D posicion) {
		Casilla casilla = getCasilla(posicion);
		casilla.setUnidad(unidad);
		unidad.setPosicion(posicion);
	}

	public Unidad getUnidad(Posicion2D posicion) {
		return getCasilla(posicion).getUnidad();
	}

	public Casilla getCasilla(Posicion2D posicion) {
		return tablero[posicion.getX() - 1][posicion.getY() - 1];
	}

	public void moverUnidad(Unidad unidad, Posicion2D posicion) {
		Casilla origen = getCasilla(unidad.getPosicion());
		Casilla destino = getCasilla(posicion);

		if (destino.ocupada()) {
			throw new CasillaOcupadaException("Esta casilla ya tiene una unidad en ella");
		}

		origen.popUnidad();
		destino.setUnidad(unidad);
		unidad.setPosicion(posicion);
	}

}
