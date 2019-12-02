package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.unidades.Unidad;

public class TurnoInvalido extends Turno {


    TurnoInvalido(){};

    @Override
    public boolean turnoValido() {
        return false;
    }

    @Override
    public void setTurno() {

    }

    @Override
    public void comprarUnidadConTurno(GestorDeCompras gestorDeCompras, Unidad unidad, Billetera billetera) {
        throw new RuntimeException();
    }
    @Override
    public Turno cambiarTurno(){
        return new TurnoValido();
    }

    @Override
    public void moverHaciaAdelanteConTurno(Unidad unidad){

        throw new RuntimeException();

    }
}
