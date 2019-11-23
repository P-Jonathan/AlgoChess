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

    private String bandoA;
    private String bandoB;

    public Tablero(String bandoA, String bandoB) {
        this.bandoA = bandoA;
        this.bandoB = bandoB;
        inicializarCasillas();
    }

    public Tablero() {
        this.bandoA = "";
        this.bandoB = "";
        inicializarCasillas();
    }

    public void posicionarUnidad(Unidad unidad, int fila, int columna) {
        if(!unidad.pertenceA(casillas[fila][columna].getBando())) {
            throw new RuntimeException();
        }

        casillas[fila][columna].ocuparCon(unidad);
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
        atacante.prepararAtaque(casillas, objetivo);
        atacante.atacar(objetivo);
    }
}
