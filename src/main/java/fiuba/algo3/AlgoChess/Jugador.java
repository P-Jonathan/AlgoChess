package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public class Jugador {
    private int puntos ;

    public Jugador(){
        puntos = 20;

    }
    public void comprarUnidad(Unidad unidad){
        this.puntos = this.puntos - unidad.getCosto();
    }

    public int getPuntos(){
        return puntos;
    }
}
