package fiuba.algo3.algochess.modelo.unidades;

import fiuba.algo3.algochess.modelo.habilidades.AtaqueACortaDistancia;
import fiuba.algo3.algochess.modelo.tablero.Jugador;
import fiuba.algo3.algochess.modelo.habilidades.Habilidad;

import java.util.List;

public class UnidadDeInfanteria extends Unidad {
    private final static int CANTIDAD_DE_UNIDADES_DEL_BATALLON = 3;
    private final static int VIDA_INICIAL = 100;
    private final static int DANIO_INICIAL = 10;
    private final static int COSTO = 1;

    private Habilidad habilidad;
    private Batallon miBatallon;

    public UnidadDeInfanteria(Jugador propietario) {
        super(propietario, VIDA_INICIAL, COSTO);
        habilidad = new AtaqueACortaDistancia(this, DANIO_INICIAL);
        miBatallon = new Batallon(this, CANTIDAD_DE_UNIDADES_DEL_BATALLON);
    }

    public UnidadDeInfanteria() {
        super(VIDA_INICIAL, COSTO);
        habilidad = new AtaqueACortaDistancia(this, DANIO_INICIAL);
        miBatallon = new Batallon(this, CANTIDAD_DE_UNIDADES_DEL_BATALLON);
    }

    public void usarHabilidad(Unidad objetivo) {
        habilidad.usarHabilidad(objetivo);
    }

    @Override
    public void enlistarse(Batallon batallon) {
        batallon.enlistarUnidad(this);
    }

    private void reclutarUnidades() {
        List<Unidad> unidadesAdyacentes = casilla.getUnidadesAdyacentes();
        miBatallon.enlistarUnidades(unidadesAdyacentes);
    }

    @Override
    public void moverHaciaAdelante() {
        reclutarUnidades();
        miBatallon.moverHaciaAdelante();
    }

    @Override
    public void moverALaDerecha() {
        reclutarUnidades();
        miBatallon.moverALaDerecha();
    }

    @Override
    public void moverHaciaAtras() {
        reclutarUnidades();
        miBatallon.moverHaciaAtras();
    }

    @Override
    public void moverALaIzquierda() {
        reclutarUnidades();
        miBatallon.moverALaIzquierda();
    }

    @Override
    protected void moverEnBatallonHaciaAdelante() {
        super.moverHaciaAdelante();
    }

    @Override
    protected void moverEnBatallonALaDerecha() {
        super.moverALaDerecha();
    }

    @Override
    protected void moverEnBatallonHaciaAtras() {
        super.moverHaciaAtras();
    }

    @Override
    protected void moverEnBatallonALaIzquierda() {
        super.moverALaIzquierda();
    }
}
