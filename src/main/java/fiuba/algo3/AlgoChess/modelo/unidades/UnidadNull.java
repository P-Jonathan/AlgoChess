package fiuba.algo3.AlgoChess.modelo.unidades;

import fiuba.algo3.AlgoChess.modelo.tablero.Jugador;
import fiuba.algo3.AlgoChess.modelo.tablero.JugadorNull;

public class UnidadNull extends Unidad {
    private static final int VIDA_DEFAULT = 100;
    private static final int COSTO_DEFAULT = 0;

    public UnidadNull() {
        super(new JugadorNull(), VIDA_DEFAULT, COSTO_DEFAULT);
    }

    @Override
    public boolean soyAliadoDe(Unidad unidad) {
        return true;
    }

    @Override
    public void disminuirVida(int danio) {
        //No tiene vida que disminuir.
    }

    @Override
    public void usarHabilidad(Unidad objetivo) {
        // No realiza ninguna accion.
    }

    @Override
    public void aumentarVida(int vida) {
        // No se aumneta la vida.
    }
}
