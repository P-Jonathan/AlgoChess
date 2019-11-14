package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.Posicion2D;
import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.unidades.Unidad;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class Tablero {
	private final int FILAS_DEFAULT = 20;
	private final int COLUMNAS_DEFUALT = 20;

	private Casilla[][] tablero;
	private int columnas;
	private int filas;
	
	private String bandoA;
	private String bandoB;

	public Tablero(String bandoA, String bandoB) {
		this.bandoA = bandoA;
		this.bandoB = bandoB;
		this.filas = FILAS_DEFAULT;
		this.columnas = COLUMNAS_DEFUALT;
		setTablero();
	}

	public Tablero(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		setTablero();
	}
	
	public Tablero(String bandoA, String bandoB, int filas, int columnas) {
		this.bandoA = bandoA;
		this.bandoB = bandoB;
		this.filas = filas;
		this.columnas = columnas;
		setTablero();
	}

	private void setTablero() {
		tablero = new Casilla[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = new Casilla();

				if(i < filas/2) {
					tablero[i][j].setBando(bandoA);
				} else {
					tablero[i][j].setBando(bandoB);
				}
			}
		}
	}

	public void posicionarUnidad(Unidad unidad) {
        Posicion2D posicion = unidad.getPosicion();
		Casilla casilla = getCasilla(posicion);
		if(unidad.getBando() != casilla.getBando()) {
			throw new RuntimeException();
		}
		casilla.setUnidad(unidad);
		unidad.setPosicion(posicion);
	}

	public Unidad getUnidad(Posicion2D posicion) {
		return getCasilla(posicion).getUnidad();
	}

	public Casilla getCasilla(Posicion2D posicion) {
		return tablero[posicion.getX()][posicion.getY()];
	}

	public void moverUnidad(Unidad unidad, Posicion2D posicion) {
		if(posicion.getX() > filas || posicion.getY() > columnas){
			throw new RuntimeException();
		}
		Casilla origen = getCasilla(unidad.getPosicion());
		Casilla destino = getCasilla(posicion);

		if (destino.ocupada()) {
			throw new CasillaOcupadaException("Esta casilla ya tiene una unidad en ella");
		}

		origen.popUnidad();
		destino.setUnidad(unidad);
		unidad.setPosicion(posicion);
	}
	public List<Unidad> unidadesAdyacentes(Unidad unidad) {
		List<Unidad> unidades = new LinkedList<Unidad>();
		Posicion2D posicion = unidad.getPosicion();
		for (int i = posicion.getX() - 1; i <= posicion.getX() + 1; i++) {
			for (int j = posicion.getY() - 1; j <= posicion.getY() + 1; j++) {

				Unidad unidad2 = this.getUnidad(new Posicion2D(i, j));
				if(unidad2 != null && unidad2 != unidad) {
					unidades.add(unidad2);
				}
			}
		}

		return unidades;
	}
}
