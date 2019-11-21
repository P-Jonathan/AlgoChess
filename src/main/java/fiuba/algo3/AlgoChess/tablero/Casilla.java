package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.unidades.Batallon;
import fiuba.algo3.AlgoChess.unidades.Unidad;

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
        if ( this.ocupante != null )
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
    
/*
    public ArrayList<Casilla> getCasillasAdyacentes(Casilla[][] casillas) {
        ArrayList<Casilla> casillasAdyacentes = new ArrayList<Casilla>();

        for(int i = ((fila - 1 >= 0)?(fila - 1):0) ; i < ((fila + 1 < 20)?(fila + 1):20) ; i++){
            for(int j = ((columna - 1 >= 0)?(columna - 1):0) ; j < ((columna + 1 < 20)?(columna + 1):20) ; j++){
                casillasAdyacentes.add(casillas[i][j]);
            }
        }

        return casillasAdyacentes;
    }
*/
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

    public Batallon armarBatallon(Casilla[][] casillas) {
        Batallon batallon = new Batallon();

        for(int i = ((fila-2>0)?(fila-2):0); i < ((fila+2<20)?(fila+2):20); i++){
            casillas[i][columna].agregarOcupante(batallon);
        }

        if(!batallon.lleno()) {
            batallon = new Batallon();

            for (int j = ((columna - 2 > 0) ? (columna - 2) : 0); j < ((columna + 2 < 20) ? (columna + 2) : 20); j++) {
                casillas[fila][j].agregarOcupante(batallon);
            }
        }

        if(!batallon.lleno()) {
            batallon = new Batallon();

            agregarOcupante(batallon);
        }

        return batallon;
        /*

        agregarOcupante(batallon);

        casillaDerecha(casillas).agregarOcupante(batallon);
        casillaIzquierda(casillas).agregarOcupante(batallon);
        casillaDerecha(casillas).casillaDerecha(casillas).agregarOcupante(batallon);

        if(!batallon.lleno()) {
            batallon.vaciar();
            agregarOcupante(batallon);
            casillaIzquierda(casillas).agregarOcupante(batallon);
            casillaDerecha(casillas).agregarOcupante(batallon);
            casillaIzquierda(casillas).casillaIzquierda(casillas).agregarOcupante(batallon);
        }

        if(!batallon.lleno()) {
            batallon.vaciar();
            agregarOcupante(batallon);
            casillaAdelante(casillas).agregarOcupante(batallon);
            casillaTrasera(casillas).agregarOcupante(batallon);
            casillaAdelante(casillas).casillaAdelante(casillas).agregarOcupante(batallon);
        }

        if(!batallon.lleno()) {
            batallon.vaciar();
            agregarOcupante(batallon);
            casillaTrasera(casillas).agregarOcupante(batallon);
            casillaAdelante(casillas).agregarOcupante(batallon);
            casillaTrasera(casillas).casillaTrasera(casillas).agregarOcupante(batallon);
        }

        if(!batallon.lleno()) {
            return null;
        }
        return batallon;
        */
    }

    public void agregarOcupante(Batallon batallon) {
        if(ocupante != null)
            ocupante.agregateA(batallon);
    }
    

	
    public ArrayList<Unidad> getUnidadesAdyacentes(Casilla[][] casillas,Unidad unidad) {
    	ArrayList<Unidad> unidadesAdyacentes = new ArrayList<Unidad>();
    	
        for(int i = fila-1; i <= ((fila + 1 < 20)?(fila + 1):20) ; i++){
            for(int j = columna-1 ; j <= ((columna + 1 < 20)?(columna + 1):20) ; j++){
            	unidadesAdyacentes.add(casillas[i][j].ocupante);
            	unidadesAdyacentes.remove(null);
            }
        }
        unidadesAdyacentes.remove(unidad);
        return unidadesAdyacentes;
	}
}
