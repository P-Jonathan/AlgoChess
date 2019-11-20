package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.tablero.Casilla;

import java.util.ArrayList;

public class Batallon {
    private ArrayList<UnidadDeInfanteria> unidades;

    public Batallon() {
        unidades = new ArrayList<UnidadDeInfanteria>();
    }

    public void agregar(UnidadDeInfanteria unidad) {
        try {
            if(unidades.size() < 3)
                unidades.add(unidad);
        } catch(Error e){}
    }

    public void moverAdelante(Casilla[][] casillas) {
        for(UnidadDeInfanteria unidad : unidades) {
            unidad.avanzarNorte(casillas);
        }
    }

    public void moverDerecha(Casilla[][] casillas) {
        for(UnidadDeInfanteria unidad : unidades) {
            unidad.avanzarEste(casillas);
        }
    }

    public void moverIzquierda(Casilla[][] casillas) {
        for(UnidadDeInfanteria unidad : unidades) {
            unidad.avanzarOeste(casillas);
        }
    }

    public void moverAbajo(Casilla[][] casillas) {
        for(UnidadDeInfanteria unidad : unidades) {
            unidad.avanzarSur(casillas);
        }
    }

    public boolean lleno() {
        return unidades.size() == 3;
    }

    public void vaciar() {
        unidades.removeAll(unidades);
    }


}
