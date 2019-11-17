package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.unidades.Unidad;

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
/*
    public ArrayList<Casilla> getAdyacentes(Casilla[][] casillas) {
        ArrayList<Casilla> adyacentes = new ArrayList<Casilla>();

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
    public Casilla casillaAdelante(Casilla[][] casillas) {
        if(fila+1 < 20)
            return casillas[fila+1][columna];
        return null;
    }

    public Casilla casillaTrasera(Casilla[][] casillas) {
        if(fila-1 >= 0)
            return casillas[fila-1][columna];
        return null;
    }

    public Casilla casillaDerecha(Casilla[][] casillas) {
        if(columna+1 < 20)
            return casillas[fila][columna+1];
        return null;
    }

    public Casilla casillaIzquierda(Casilla[][] casillas) {
        if(columna-1 >= 0)
            return casillas[fila][columna-1];
        return null;
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

    public void setBando(String bando) {
        this.bando = bando;
    }

    public String getBando() {
        return bando;
    }

}
