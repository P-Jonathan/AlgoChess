package fiuba.algo3.AlgoChess.modelo.tablero;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;

import java.util.List;

public class Casilla {
    private static final int RANGO_CORTO_MIN = 1;
    private static final int RANGO_CORTO_MAX = 2;
    private static final int RANGO_MEDIO_MAX = 5;
    private static final int MULTIPLICADOR_DE_DANIO_ALIADO = 0;
    private static final int MULTIPLICADOR_DE_DANIO_ENEMIGO = 5;

    private Tablero tablero;
    private Jugador propietario;
    private Posicion posicion;
    private EstadoCasilla estado;

    protected Casilla(Tablero tablero, Posicion posicion, Unidad ocupante) {
        this.tablero = tablero;
        this.posicion = posicion;
        propietario = new JugadorNull();
        setEstado(new EstadoCasillaOcupada(this, ocupante));
    }

    Casilla(Tablero tablero, Posicion posicion) {
        this.tablero = tablero;
        this.posicion = posicion;
        propietario = new JugadorNull();
        setEstado(new EstadoCasillaVacia(this));
    }

    public Casilla() {
        propietario = new JugadorNull();
        posicion = new Posicion(0, 0);
        setEstado(new EstadoCasillaVacia(this));
    }

    private void aplicarMultiplicadorDeDanio() {
        if(getOcupante().esMiPropietario(propietario))
            getOcupante().setMultiplicadorDeDanio(MULTIPLICADOR_DE_DANIO_ALIADO);
        else
            getOcupante().setMultiplicadorDeDanio(MULTIPLICADOR_DE_DANIO_ENEMIGO);
    }

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    /************************************************/
    public Posicion getPosicion() { return posicion; }
    /************************************************/

    public void setOcupante(Unidad ocupante) {
        estado.setOcupante(ocupante);
        aplicarMultiplicadorDeDanio();
    }

    public Unidad getOcupante() {
        return estado.getOcupante();
    }

    Unidad removeOcupante() {
        return estado.removeOcupante();
    }

    void setEstado(EstadoCasilla nuevoEstado) {
        estado = nuevoEstado;
    }

    public int distanciaACasilla(Casilla casilla) {
        return casilla.distanciaAPosicion(posicion);
    }

    int distanciaAPosicion(Posicion posicion) {
        return posicion.distanciaAPosicion(this.posicion);
    }

    boolean esAdyacente(Casilla casilla){
        int distancia = casilla.distanciaACasilla(this);
        return distancia >= 1 && distancia <= 2;
    }

    public boolean estaEnPosicion(Posicion posicion) {
        return posicion.isEquals(this.posicion);
    }

    public List<Unidad> getUnidadesAdyacentes() {
        return tablero.getUnidadesAdyacencesAPosicion(posicion);
    }

    public List<Unidad> getUnidadesADistanciaCorta() {
        return tablero.getUnidadesADistanciaCorta(posicion);
    }

    public List<Unidad> getUnidadADistanciaMedia() {
        return tablero.getUnidadesADistanciaMedia(posicion);
    }

    public List<Unidad> getUnidadADistanciaLarga() {
        return tablero.getUnidadesADistanciaLarga(posicion);
    }

    public void moverUnidadHaciaAdelante() {
        moverUnidad(posicion.posicionAdelante());
    }

    public void moverUnidadALaDerecha() {
        moverUnidad(posicion.posicionADerecha());
    }

    public void moverUnidadHaciaAtras() {
        moverUnidad(posicion.posicionAtras());
    }

    public void moverUnidadALaIzquierda() {
        moverUnidad(posicion.posicionAIzquierda());
    }

    private void moverUnidad(Posicion posicionDestino) {
        Casilla destino = tablero.getCasillaEnPosicion(posicionDestino);
        destino.setOcupante(getOcupante()); // No poner removeOcupante dentro, porque si tira excepcion no queremos que se salga
        removeOcupante();                   // la unidad que estaba antes en esta casilla.
    }

    public boolean valorEnRangoCorto(int valor) {
        return valor >= RANGO_CORTO_MIN && valor <= RANGO_CORTO_MAX;
    }

    public boolean valorEnRangoMedio(int valor) {
        return valor > RANGO_CORTO_MAX && valor <= RANGO_MEDIO_MAX;
    }

    public boolean valorEnRangoLargo(int valor) {
        return valor > RANGO_MEDIO_MAX;
    }

    public boolean esTerrenoAliadoPara(Unidad unidad) {
        return unidad.esMiPropietario(propietario);
    }

    public boolean estaADistanciaCorta(Casilla casilla) {
        int distancia = casilla.distanciaACasilla(this);
        return valorEnRangoCorto(distancia);
    }

    public boolean estaADistanciaMedia(Casilla casilla) {
        int distancia = casilla.distanciaACasilla(this);
        return valorEnRangoMedio(distancia);
    }

    public boolean estaADistanciaLarga(Casilla casilla) {
        int distancia = casilla.distanciaACasilla(this);
        return valorEnRangoLargo(distancia);
    }
}
