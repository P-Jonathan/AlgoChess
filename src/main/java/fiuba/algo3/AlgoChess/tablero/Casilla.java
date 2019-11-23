package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.unidades.Unidad;

import java.util.ArrayList;

public class Casilla {
    static int ANCHO_TABLERO = 20;
    private EstadoCasilla estado;
    private String bando;
    private int fila;
    private int columna;

    public Casilla(Unidad ocupante) {
        estado = new EstadoCasillaOcupada(ocupante);
    }

    public Casilla(int fila, int columna) {
        estado = new EstadoCasillaVacia();
        this.bando = "";
        this.fila = fila;
        this.columna = columna;
    }

    public Casilla() {
        estado = new EstadoCasillaVacia();
    }

    public void ocuparCon(Unidad ocupante) {
        estado = estado.ocuparCon(this, ocupante);
    }

    public void desocupar() {
        estado = estado.desocupar();
    }

    public ArrayList<Casilla> getCasillasCercanas(Casilla[][] casillas) { //Casillas a distancia <= 3
        ArrayList<Casilla> casillasCercanas = new ArrayList<Casilla>();

        for (int i = noSesobrepasaLimiteTablero(fila); i < noSesobrepasaLimiteTableroSuperior(fila, 3); i++) {
            for (int j = (noSesobrepasaLimiteTablero(columna)); j < (noSesobrepasaLimiteTableroSuperior(columna, 3)); j++) {
                casillasCercanas.add(casillas[i][j]);
            }
        }

        return casillasCercanas;
    }

    private int noSesobrepasaLimiteTableroSuperior(int fila, int i) {
        return (fila + i < 20) ? (fila + i) : 20;
    }

    private int noSesobrepasaLimiteTablero(int fila) {
        return (fila - 3 >= 0) ? (fila - 3) : 0;
    }

    public ArrayList<Unidad> unidadesCercanas(Casilla[][] casillas) {
        ArrayList<Casilla> casillasCercanas = getCasillasCercanas(casillas);
        ArrayList<Unidad> unidadesCercanas = new ArrayList<Unidad>();

        for (Casilla casillaCercana : casillasCercanas) {
            casillaCercana.ocupante().agregateA(unidadesCercanas);
        }

        return unidadesCercanas;
    }

    public Casilla casillaAdelante(Casilla[][] casillas) {
        return ((fila + 1 < 20) ? (casillas[fila + 1][columna]) : null);
    }

    public Casilla casillaTrasera(Casilla[][] casillas) {
        return ((fila - 1 >= 0) ? (casillas[fila - 1][columna]) : null);
    }

    public Casilla casillaDerecha(Casilla[][] casillas) {
        return ((columna + 1 < 20) ? (casillas[fila][columna + 1]) : null);
    }

    public Casilla casillaIzquierda(Casilla[][] casillas) {
        return ((columna - 1 < 20) ? (casillas[fila][columna - 1]) : null);
    }

    public boolean ocupadaCon(Unidad ocupante) {
        return estado.ocupante() == ocupante;
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

        for (int i = 0; i < ANCHO_TABLERO; i++) {
            for (int j = 0; j < ANCHO_TABLERO; j++) {
                if (casillas[i][j].ocupadaCon(unidad)) {
                    filaUnidad = i;
                    columnaUnidad = j;
                }
            }
        }

        return distanciaA(filaUnidad, columnaUnidad);
    }

    public void setBando(String bando) {
        this.bando = bando;
    }

    public String getBando() {
        return bando;
    }

    public Unidad ocupante() {
        return estado.ocupante();
    }

    public String posicion() {
        return fila + ";" + columna;
    }
	
    public ArrayList<Unidad> getUnidadesAdyacentes(Casilla[][] casillas,Unidad unidad) {
    	ArrayList<Unidad> unidadesAdyacentes = new ArrayList<Unidad>();
    	
        for(int i = fila-1; i <= ((fila + 1 < 20)?(fila + 1):20) ; i++){
            for(int j = columna-1 ; j <= ((columna + 1 < 20)?(columna + 1):20) ; j++){
                casillas[i][j].ocupante().agregateA(unidadesAdyacentes);
            }
        }
        unidadesAdyacentes.remove(unidad);
        return unidadesAdyacentes;
	}
}
