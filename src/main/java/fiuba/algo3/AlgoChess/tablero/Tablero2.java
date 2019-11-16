package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.unidades.Unidad2;

import java.util.ArrayList;
import java.util.List;

public class Tablero2 {
    private final int FILAS = 20;
    private final int COLUMNAS = 20;

    private Casilla2[][] casillas;
    private List<Unidad2> unidades;

    public Tablero2() {
        unidades = new ArrayList<Unidad2>();
        inicializarCasillas();
    }

    public void posicionarUnidad(Unidad2 unidad, int fila, int columna) {
        unidades.add(unidad);
        unidad.setCoords(fila, columna);
        casillas[fila][columna].ocuparCon(unidad);
        unidad.setCasillaActual(casillas[fila][columna]);
    }

    public void moverUnidadAdelante(Unidad2 unidad) {
        unidad.moverAdelante(casillas);
    }

    public void moverUnidadAtras(Unidad2 unidad) {
        unidad.moverAbajo(casillas);
    }

    public void moverUnidadDerecha(Unidad2 unidad) {
        unidad.moverDerecha(casillas);
    }

    public void moverUnidadIzquierda(Unidad2 unidad) {
        unidad.moverIzquierda(casillas);
    }

    private void inicializarCasillas() {
        casillas = new Casilla2[FILAS][COLUMNAS];

        for(int i = 0; i < FILAS; i++){
            for(int j = 0; j < COLUMNAS; j++){
                casillas[i][j] = new Casilla2(i,j);
            }
        }
    }

    public void atacarConUnidadA(Unidad2 atacante, Unidad2 objetivo) {
        atacante.atacar(objetivo, casillas);
    }
}
