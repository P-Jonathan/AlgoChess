package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.unidades.Unidad;

public abstract class Turno {
    public abstract boolean turnoValido();
    public abstract void setTurno();
    public abstract void comprarUnidadConTurno(GestorDeCompras gestorDeCompras, Unidad unidad, Billetera billetera);
    public abstract Turno cambiarTurno();
    public abstract void moverHaciaAdelanteConTurno(Unidad unidad);
}
