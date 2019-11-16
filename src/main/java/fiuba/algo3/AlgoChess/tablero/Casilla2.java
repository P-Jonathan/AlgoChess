package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.unidades.Unidad2;

import java.util.ArrayList;
import java.util.List;

public class Casilla2 {
    private Unidad2 ocupante;
    private int fila;
    private int columna;

    public Casilla2(Unidad2 unOcupante) {
        ocupante = unOcupante;
    }

    public Casilla2(int fila, int columna) {
        ocupante = null;
        this.fila = fila;
        this.columna = columna;
    }

    public Casilla2() {
        this.ocupante = null;
    }

    public void ocuparCon(Unidad2 ocupante) {
        if ( this.ocupante != null )
            throw new CasillaOcupadaException("KKKK");
        this.ocupante = ocupante;
        ocupante.setCasillaActual(this);
    }

    public void desocupar() {
        this.ocupante = null;
    }
/*
    public ArrayList<Casilla2> getAdyacentes(Casilla2[][] casillas) {
        ArrayList<Casilla2> adyacentes = new ArrayList<Casilla2>();

        if(fila + 1 < 20)
            adyacentes.add(casillas[fila+1][columna]);
        if(fila - 1 >= 0)
            adyacentes.add(casillas[fila-1][columna]);
        if(columna + 1 < 20)
            adyacentes.add(casillas[fila][columna+1]);
        if(columna - 1 >= 0)
            adyacentes.add(casillas[fila][columna-1]);

        return adyacentes;
    }
*/
    public Casilla2 casillaAdelante(Casilla2[][] casillas) {
        if(fila+1 < 20)
            return casillas[fila+1][columna];
        return null;
    }

    public Casilla2 casillaTrasera(Casilla2[][] casillas) {
        if(fila-1 >= 0)
            return casillas[fila-1][columna];
        return null;
    }

    public Casilla2 casillaDerecha(Casilla2[][] casillas) {
        if(columna+1 < 20)
            return casillas[fila][columna+1];
        return null;
    }

    public Casilla2 casillaIzquierda(Casilla2[][] casillas) {
        if(columna-1 >= 0)
            return casillas[fila][columna-1];
        return null;
    }

    private boolean ocupadaCon(Unidad2 ocupante) {
        return this.ocupante == ocupante;
    }

    private double distanciaA(int fila, int columna) {
        int distanciaEnFilas = Math.abs(this.fila - fila);
        int distanciaEnColumnas = Math.abs(this.columna - columna);

        int distancia = distanciaEnFilas * distanciaEnFilas + distanciaEnColumnas * distanciaEnColumnas;

        return Math.sqrt(distancia);
    }

    public void distanciaA(Unidad2 objetivo, Casilla2[][] casillas) {
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(casillas[i][j].ocupadaCon(objetivo)){
                    ocupante.setAtaqueStrategyParaObjetivoADistancia(distanciaA(i,j));
                }
            }
        }
    }

}
