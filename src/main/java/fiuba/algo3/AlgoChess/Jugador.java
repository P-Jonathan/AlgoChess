package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.FinDelJuegoException;
import fiuba.algo3.AlgoChess.excepciones.PuntosInsuficientesException;
import fiuba.algo3.AlgoChess.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private int puntos ;
    private List<Unidad> unidades;
    private String nombre;

    public Jugador(String nombre){
        puntos = 20;
        unidades = new ArrayList<Unidad>();
        this.nombre = nombre;
    }

    public void comprarUnidad(Unidad unidad){
        if( puntos < unidad.getCosto() ) {
            throw new PuntosInsuficientesException("Puntos insuficientes");
        }

        puntos = puntos - unidad.getCosto();
        unidad.setJugador(this);
        unidades.add(unidad);
    }

    public int getPuntos(){
        return puntos;
    }

    public int cantidadUnidades() {
        return unidades.size();
    }

    public void descartarUnidad(Unidad unidad) {
        unidades.remove(unidad);

        if(unidades.isEmpty()) {
            System.out.println(nombre + " se ha quedado sin unidades y no puede continuar");
            throw new FinDelJuegoException("Fin del juego");
        }
    }
}
