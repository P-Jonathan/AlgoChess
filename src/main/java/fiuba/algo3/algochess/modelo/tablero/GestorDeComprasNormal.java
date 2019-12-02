package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.unidades.Unidad;

public class GestorDeComprasNormal extends GestorDeCompras {

    GestorDeComprasNormal(Jugador propietario) {
        super(propietario);
    }

    @Override
    public void comprarUnidad(Unidad unidad, Billetera billetera) {
        billetera.pagar(unidad.getCosto());
        propietario.agregarUnidad(unidad);
    }

    @Override
    public boolean puedeComprar() {
        return true;
    }
}
