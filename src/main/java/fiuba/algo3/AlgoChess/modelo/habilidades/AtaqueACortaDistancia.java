package fiuba.algo3.AlgoChess.modelo.habilidades;

import fiuba.algo3.AlgoChess.modelo.excepciones.UnidadFueraDeRango;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;

public class AtaqueACortaDistancia extends Habilidad {
    private int danio;

    public AtaqueACortaDistancia(Unidad portador, int danio) {
        super(portador);
        this.danio = danio;
    }

    @Override
    public void usarHabilidad(Unidad objetivo) {
        if(!objetivo.estaACortaDistancia(portador))
            throw new UnidadFueraDeRango();

        objetivo.disminuirVida(danio);
    }
}
