package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.unidades.Unidad;

public class EstadoCasillaOcupada extends EstadoCasilla {
    private Unidad ocupante;

    public EstadoCasillaOcupada(Unidad ocupante) {
        this.ocupante = ocupante;
    }

    @Override
    public Unidad ocupante() {
        return ocupante;
    }

    @Override
    public EstadoCasilla ocuparCon(Unidad ocupante) {
        return this;
    }

    @Override
    public EstadoCasilla desocupar() {
        return new EstadoCasillaVacia();
    }
}
