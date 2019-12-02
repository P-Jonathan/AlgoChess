package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.excepciones.GestorDeComprasBloqueado;
import fiuba.algo3.algochess.modelo.unidades.Unidad;

public class GestosDeComprasBloqueado extends GestorDeCompras {

    GestosDeComprasBloqueado(Jugador propietario) {
        super(propietario);
    }

    @Override
    public void comprarUnidad(Unidad unidad, Billetera billetera) {
        throw new GestorDeComprasBloqueado();
    }

    @Override
    public boolean puedeComprar() {
        return false;
    }
}
