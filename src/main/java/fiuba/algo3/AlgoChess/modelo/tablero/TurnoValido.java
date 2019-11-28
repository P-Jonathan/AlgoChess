package fiuba.algo3.AlgoChess.modelo.tablero;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;

public class TurnoValido extends Turno {

    TurnoValido(){};

    @Override
    public boolean turnoValido() {
        return true;
    }

    @Override
    public void setTurno() {

    }

    @Override
    public void comprarUnidadConTurno(GestorDeCompras gestorDeCompras, Unidad unidad, Billetera billetera){
        gestorDeCompras.comprarUnidad(unidad,billetera);
    }
    @Override
    public Turno cambiarTurno(){
        return new TurnoInvalido();
    };

    @Override
    public void moverHaciaAdelanteConTurno(Unidad unidad){

        unidad.moverHaciaAdelante();
        unidad.avisarlesALasUnidadesQueCambienElturno();

    }
}
