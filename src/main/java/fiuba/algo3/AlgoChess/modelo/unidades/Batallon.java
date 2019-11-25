package fiuba.algo3.AlgoChess.modelo.unidades;

import java.util.ArrayList;
import java.util.List;

class Batallon {
    private int max_unidades;
    private List<Unidad> batallon;
    private Unidad capitan;

    Batallon(Unidad capitan, int max_unidades) {
        batallon = new ArrayList<>(max_unidades);
        batallon.add(capitan);
        this.capitan = capitan;
        this.max_unidades = max_unidades;
    }

    private boolean batallonCompleto() {
        return batallon.size() == max_unidades;
    }

    private boolean batallonIncompleto(){
        return batallon.size() < max_unidades;
    }

    private void limpiarBatallon() {
        batallon.clear();
        batallon.add(capitan);
    }

    private void disolverBatallonSiEstaIncompleto() {
        if(batallonIncompleto())
            limpiarBatallon();
    }

    void enlistarUnidad(Unidad unidad){
        if(batallonCompleto())
            throw new RuntimeException();
        batallon.add(unidad);
    }

    void enlistarUnidades(List<Unidad> unidades) {
        for(Unidad unidad : unidades){
            try {
                unidad.enlistarse(this);
            } catch(RuntimeException exception) {
                // Error al unirse al batallon.
            }
        }
        disolverBatallonSiEstaIncompleto();
    }

    private void moverUnidadAdelante(Unidad unidad) {
        try {
            unidad.moverHaciaAdelante();
        } catch (RuntimeException e) {
            // No se pudo mover.
        }
    }

    private void moverUnidadALaDerecha(Unidad unidad) {
        try {
            unidad.moverALaDerecha();
        } catch (RuntimeException e) {
            // No se pudo mover.
        }
    }

    private void moverUnidadHaciaAtras(Unidad unidad) {
        try {
            unidad.moverHaciaAtras();
        } catch (RuntimeException e) {
            // No se pudo mover.
        }
    }

    private void moverUnidadALaIzquierda(Unidad unidad) {
        try {
            unidad.moverALaIzquierda();
        } catch (RuntimeException e) {
            // No se pudo mover.
        }
    }

    // Cada movimiento desarma el batallon y solo queda su capitan.
    void moverHaciaAdelante() {
        batallon.forEach(this::moverUnidadAdelante);
        limpiarBatallon();
    }

    void moverALaDerecha() {
        batallon.forEach(this::moverUnidadALaDerecha);
        limpiarBatallon();
    }

    void moverHaciaAtras() {
        batallon.forEach(this::moverUnidadHaciaAtras);
        limpiarBatallon();
    }

    void moverALaIzquierda() {
        batallon.forEach(this::moverUnidadALaIzquierda);
        limpiarBatallon();
    }
}
