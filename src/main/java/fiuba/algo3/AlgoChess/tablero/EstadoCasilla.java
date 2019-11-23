package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.unidades.Unidad;

import java.util.List;

public abstract class EstadoCasilla {
    public abstract EstadoCasilla ocuparCon(Casilla casilla, Unidad ocupante);
    public abstract EstadoCasilla desocupar();
    public abstract Unidad ocupante();
}
