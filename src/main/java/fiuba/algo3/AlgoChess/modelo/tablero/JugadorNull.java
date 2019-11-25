package fiuba.algo3.AlgoChess.modelo.tablero;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;

public class JugadorNull extends Jugador {

    private static final String DEFAULT_NAME = "Null Player";

    public JugadorNull() {
        super(DEFAULT_NAME);
    }

    @Override
    public void comprarUnidad(Unidad unidad) {
    }

    @Override
    public void quitarUnidad(Unidad unidad) {
    }
}
