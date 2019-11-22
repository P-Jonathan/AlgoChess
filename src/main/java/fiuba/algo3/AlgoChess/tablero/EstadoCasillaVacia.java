package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.unidades.Unidad;
import fiuba.algo3.AlgoChess.unidades.UnidadNull;

public class EstadoCasillaVacia extends EstadoCasilla {
    private Unidad ocupante = new UnidadNull();

    @Override
    public Unidad ocupante() {
        return null;
    }

    @Override
    public EstadoCasilla ocuparCon(Casilla casilla, Unidad ocupante) {
        ocupante.setCasillaActual(casilla);
        return new EstadoCasillaOcupada(ocupante);
    }

    @Override
    public EstadoCasilla desocupar() {
        return this;
    }
}
