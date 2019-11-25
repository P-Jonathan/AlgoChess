package fiuba.algo3.AlgoChess.modelo.unidades;

import fiuba.algo3.AlgoChess.modelo.habilidades.AtaqueACortaDistancia;
import fiuba.algo3.AlgoChess.modelo.tablero.Casilla;
import fiuba.algo3.AlgoChess.modelo.tablero.Jugador;
import fiuba.algo3.AlgoChess.modelo.habilidades.Habilidad;

import java.util.List;

public class UnidadDeInfanteria extends Unidad {
    private final static int CANTIDAD_DE_UNIDADES_DEL_BATALLON = 3;
    private final static int VIDA_INICIAL = 100;
    private final static int DANIO_INICIAL = 10;
    private final static int COSTO = 1;

    private Habilidad habilidad;
    private Batallon batallon;

    public UnidadDeInfanteria(Jugador propietario) {
        super(propietario, VIDA_INICIAL, COSTO);
        habilidad = new AtaqueACortaDistancia(this, DANIO_INICIAL);
        batallon = new Batallon(this, CANTIDAD_DE_UNIDADES_DEL_BATALLON);
    }

    public UnidadDeInfanteria() {
        super(VIDA_INICIAL, COSTO);
        habilidad = new AtaqueACortaDistancia(this, DANIO_INICIAL);
        batallon = new Batallon(this, CANTIDAD_DE_UNIDADES_DEL_BATALLON);
    }

    public void usarHabilidad(Unidad objetivo) {
        habilidad.usarHabilidad(objetivo);
    }

    @Override
    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
        reclutarUnidades();
    }

    @Override
    public void enlistarse(Batallon batallon) {
        batallon.enlistarUnidad(this);
    }

    private void reclutarUnidades() {
        List<Unidad> unidadesAdyacentes = casilla.getUnidadesAdyacentes();
        batallon.enlistarUnidades(unidadesAdyacentes);
    }

    @Override
    public void moverHaciaAdelante() {
        reclutarUnidades();
        batallon.moverHaciaAdelante();
    }

    @Override
    public void moverALaDerecha() {
        reclutarUnidades();
        batallon.moverALaDerecha();
    }

    @Override
    public void moverHaciaAtras() {
        reclutarUnidades();
        batallon.moverHaciaAtras();
    }

    @Override
    public void moverALaIzquierda() {
        reclutarUnidades();
        batallon.moverALaIzquierda();
    }
}
