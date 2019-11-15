package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.tablero.Casilla2;

import java.util.ArrayList;

public class Unidad2 {
    private Casilla2 casillaActual;
    private int filaActual;
    private int columnaActual;

    public void setCasillaActual(Casilla2 casilla){
        casillaActual = casilla;
    }

    public void setCoords(int fila, int columna) {
        filaActual = fila;
        columnaActual = columna;
    }

    public String getCoords(){
        return (filaActual + " ; " + columnaActual);
    }

    public void moverAdelante(Casilla2[][] casillas) {
        ArrayList<Casilla2> casillasPosible = casillaActual.getAdyacentes(casillas);
        Casilla2 destino = casillaActual.casillaAdelante(casillas);

        if(casillasPosible.contains(destino)){
            casillaActual.desocupar();
            destino.ocuparCon(this);
            casillaActual = destino;
            filaActual++;
        }
    }

    public void moverDerecha(Casilla2[][] casillas) {
        ArrayList<Casilla2> casillasPosible = casillaActual.getAdyacentes(casillas);
        Casilla2 destino = casillaActual.casillaDerecha(casillas);

        if(casillasPosible.contains(destino)){
            casillaActual.desocupar();
            destino.ocuparCon(this);
            casillaActual = destino;
            columnaActual++;
        }
    }

    public void moverAbajo(Casilla2[][] casillas) {
        ArrayList<Casilla2> casillasPosible = casillaActual.getAdyacentes(casillas);
        Casilla2 destino = casillaActual.casillaTrasera(casillas);

        if(casillasPosible.contains(destino)){
            casillaActual.desocupar();
            destino.ocuparCon(this);
            casillaActual = destino;
            filaActual--;
        }
    }

    public void moverIzquierda(Casilla2[][] casillas) {
        ArrayList<Casilla2> casillasPosible = casillaActual.getAdyacentes(casillas);
        Casilla2 destino = casillaActual.casillaIzquierda(casillas);

        if(casillasPosible.contains(destino)){
            casillaActual.desocupar();
            destino.ocuparCon(this);
            casillaActual = destino;
            columnaActual--;
        }
    }
}
