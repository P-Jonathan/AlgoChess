package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.unidades.Unidad;

public abstract class GestorDeCompras {

    protected Jugador propietario;

    GestorDeCompras(Jugador propietario) {
        this.propietario = propietario;
    }

    public abstract void comprarUnidad(Unidad unidad, Billetera billetera);

    public abstract boolean puedeComprar();
}
