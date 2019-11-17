package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private final int FILAS = 20;
    private final int COLUMNAS = 20;

    private Casilla[][] casillas;
    private List<Unidad> unidades;

    private String bandoA;
    private String bandoB;

    public Tablero(String bandoA, String bandoB) {
        unidades = new ArrayList<Unidad>();
        this.bandoA = bandoA;
        this.bandoB = bandoB;
        inicializarCasillas();
    }

    public Tablero() {
        unidades = new ArrayList<Unidad>();
        this.bandoA = "";
        this.bandoB = "";
        inicializarCasillas();
    }

    public void posicionarUnidad(Unidad unidad, int fila, int columna) {
        if(unidad.getBando() != casillas[fila][columna].getBando()) {
            throw new RuntimeException();
        }

        unidades.add(unidad);
        unidad.setCoords(fila, columna);
        casillas[fila][columna].ocuparCon(unidad);
        unidad.setCasillaActual(casillas[fila][columna]);
    }

    public void moverUnidadAdelante(UnidadMovible unidad) {
        unidad.moverAdelante(casillas);
    }

    public void moverUnidadAtras(UnidadMovible unidad) {
        unidad.moverAbajo(casillas);
    }

    public void moverUnidadDerecha(UnidadMovible unidad) {
        unidad.moverDerecha(casillas);
    }

    public void moverUnidadIzquierda(UnidadMovible unidad) {
        unidad.moverIzquierda(casillas);
    }

    private void inicializarCasillas() {
        casillas = new Casilla[FILAS][COLUMNAS];

        for(int i = 0; i < FILAS; i++){
            for(int j = 0; j < COLUMNAS; j++){
                casillas[i][j] = new Casilla(i,j);

                if(i < FILAS/2) {
                    casillas[i][j].setBando(bandoA);
                } else {
                    casillas[i][j].setBando(bandoB);
                }
            }
        }
    }

    public void atacarConUnidadAUnidad(UnidadOfensiva atacante, Unidad objetivo) {
        Casilla casillaAtacante = new Casilla();
        int filaObjetivo = 0;
        int columnaObjetivo = 0;
        double distancia;

        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(casillas[i][j].ocupadaCon(atacante)){
                    casillaAtacante = casillas[i][j];
                }

                if(casillas[i][j].ocupadaCon(objetivo)){
                    filaObjetivo = i;
                    columnaObjetivo = j;
                }
            }
        }

        distancia = casillaAtacante.distanciaA(filaObjetivo, columnaObjetivo);
        atacante.prepararAtaqueADistancia(distancia);
        atacante.atacar(objetivo);
    }

    /*
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
     */
}
