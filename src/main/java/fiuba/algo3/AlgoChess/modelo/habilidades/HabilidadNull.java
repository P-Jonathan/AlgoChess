package fiuba.algo3.AlgoChess.modelo.habilidades;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;

public class HabilidadNull extends Habilidad {

    HabilidadNull(Unidad portador) {
        super(portador);
    }

    @Override
    public void usarHabilidad(Unidad objetivo) {
        // No activa ninguna habilidad
    }

}
