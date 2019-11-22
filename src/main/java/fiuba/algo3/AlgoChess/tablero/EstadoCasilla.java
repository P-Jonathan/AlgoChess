package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public abstract class EstadoCasilla {
    public abstract EstadoCasilla ocuparCon(Casilla casilla, Unidad unidad);
    public abstract EstadoCasilla desocupar();
    public abstract Unidad ocupante();
}
