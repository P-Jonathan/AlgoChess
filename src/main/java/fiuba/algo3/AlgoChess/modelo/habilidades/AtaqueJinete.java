package fiuba.algo3.AlgoChess.modelo.habilidades;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;

public class AtaqueJinete extends Habilidad {
    private final static int DANIO_CUERPO_A_CUERPO = 5;
    private final static int DANIO_A_DISTANCIA = 15;

    private Habilidad habilidad;

    public AtaqueJinete(Unidad portador) {
        super(portador);
    }

    private Habilidad getAtaque(Unidad objetivo) {
        if (portador.estaACortaDistancia(objetivo) && portador.noTieneAliadosCerca())
            return new AtaqueACortaDistancia(portador, DANIO_CUERPO_A_CUERPO);

        if (portador.estaAMediaDistancia(objetivo) && portador.tieneAliadosCerca())
            return new AtaqueAMediaDistancia(portador, DANIO_A_DISTANCIA);

        return new HabilidadNull(portador);
    }

    @Override
    public void usarHabilidad(Unidad objetivo) {
        if (portador.soyAliadoDe(objetivo))
            throw new RuntimeException();

        habilidad = getAtaque(objetivo);

        habilidad.usarHabilidad(objetivo);
    }
}
