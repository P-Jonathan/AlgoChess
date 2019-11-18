package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.unidades.Unidad;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

import java.util.ArrayList;

public class Casilla {
    private Unidad ocupante;
    private String bando;
    private int fila;
    private int columna;

    public Casilla(Unidad unOcupante) {
        ocupante = unOcupante;
    }

    public Casilla(int fila, int columna) {
        ocupante = null;
        this.bando = "";
        this.fila = fila;
        this.columna = columna;
    }

    public Casilla() {
        this.ocupante = null;
    }

    public void ocuparCon(Unidad ocupante) {
        if ( this.ocupante != null && this !=null )
            throw new CasillaOcupadaException();
        this.ocupante = ocupante;
        ocupante.setCasillaActual(this);
    }

    public void desocupar() {
        this.ocupante = null;
    }

    public ArrayList<Casilla> getCasillasCercanas(Casilla[][] casillas) { //Casillas a distancia <= 3
        ArrayList<Casilla> casillasCercanas = new ArrayList<Casilla>();

        for(int i = ((fila - 3 >= 0)?(fila - 3):0) ; i < ((fila + 3 < 20)?(fila + 3):20) ; i++){
            for(int j = ((columna - 3 >= 0)?(columna - 3):0) ; j < ((columna + 3 < 20)?(columna + 3):20) ; j++){
                casillasCercanas.add(casillas[i][j]);
            }
        }

        return casillasCercanas;
    }

    public boolean ocupadaConUnidadAliada(String bando){
        return (ocupante != null) && (ocupante.getBando().equals(bando));
    }

    public boolean ocupadaConUnidadEnemiga(String bando){
        return (ocupante != null) && (!ocupante.getBando().equals(bando));
    }

    public Casilla casillaAdelante(Casilla[][] casillas) {
        return ( (fila+1 < 20)?(casillas[fila+1][columna]):null );
    }

    public Casilla casillaTrasera(Casilla[][] casillas) {
        return ( (fila-1 >= 0)?(casillas[fila-1][columna]):null );
    }

    public Casilla casillaDerecha(Casilla[][] casillas) {
        return ( (columna+1 < 20)?(casillas[fila][columna+1]):null );
    }

    public Casilla casillaIzquierda(Casilla[][] casillas) {
        return ( (columna-1 < 20)?(casillas[fila][columna-1]):null );
    }

    public boolean ocupadaCon(Unidad ocupante) {
        return this.ocupante == ocupante;
    }
    public boolean ocupadaCon(UnidadOfensiva ocupante) {
        return this.ocupante == ocupante;
    }

    public double distanciaA(int fila, int columna) {
        int distanciaEnFilas = Math.abs(this.fila - fila);
        int distanciaEnColumnas = Math.abs(this.columna - columna);

        int distancia = distanciaEnFilas * distanciaEnFilas + distanciaEnColumnas * distanciaEnColumnas;

        return Math.sqrt(distancia);
    }

    public double distanciaAUnidad(Casilla[][] casillas, Unidad unidad) {
        int filaUnidad = 0;
        int columnaUnidad = 0;

        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++) {
                if (casillas[i][j].ocupadaCon(unidad)) {
                    filaUnidad = i;
                    columnaUnidad = j;
                }
            }
        }

        return distanciaA(filaUnidad,columnaUnidad);
    }

    public void setBando(String bando) {
        this.bando = bando;
    }

    public String getBando() {
        return bando;
    }

}
