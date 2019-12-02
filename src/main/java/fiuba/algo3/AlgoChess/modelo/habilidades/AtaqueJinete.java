package fiuba.algo3.AlgoChess.modelo.habilidades;

import fiuba.algo3.AlgoChess.modelo.excepciones.NoSePuedeAtacarAAliados;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;

public class AtaqueJinete extends Habilidad {
    private final static int DANIO_CUERPO_A_CUERPO = 5;
    private final static int DANIO_A_DISTANCIA = 15;

    public AtaqueJinete(Unidad portador) {
        super(portador);
    }

    private Habilidad getAtaque(Unidad objetivo) {
        if (portador.tieneEnemigosCerca() && portador.noTieneAliadosCerca())
            return new AtaqueACortaDistancia(portador, DANIO_CUERPO_A_CUERPO);

        if (portador.noTieneEnemigosCerca() || portador.tieneAliadosCerca())
            return new AtaqueAMediaDistancia(portador, DANIO_A_DISTANCIA);

        return new HabilidadNull(portador);
    }

    @Override
    public void usarHabilidad(Unidad objetivo) {
        if (portador.soyAliadoDe(objetivo))
            throw new NoSePuedeAtacarAAliados();

        Habilidad habilidad = getAtaque(objetivo);

        habilidad.usarHabilidad(objetivo);
    }
}
