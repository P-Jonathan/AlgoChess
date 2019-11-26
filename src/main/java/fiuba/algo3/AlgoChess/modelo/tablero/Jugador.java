package fiuba.algo3.AlgoChess.modelo.tablero;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private static final int PUNTOS_INICIALES = 20;

    private String nombre;
    private List<Unidad> unidades;
    private Billetera billetera;
    private GestorDeCompras gestorDeCompras;

    protected Jugador(String nombre) {
        this.nombre = nombre;
        unidades = new ArrayList<>();
        billetera = new Billetera(PUNTOS_INICIALES);
        gestorDeCompras = new GestorDeComprasNormal(this);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return billetera.getPuntos();
    }

    public List<Unidad> getUnidades() {
        return unidades;
    }

    void agregarUnidad(Unidad unidad) {
        unidad.setPropietario(this);
        unidades.add(unidad);
    }

    public void comprarUnidad(Unidad unidad) {
        gestorDeCompras.comprarUnidad(unidad, billetera);
    }

    public void quitarUnidad(Unidad unidad) {
        unidades.remove(unidad);
    }

    public void finalizarCompras() {
        gestorDeCompras = new GestosDeComprasBloqueado(this);
    }

    public void reanudarCompras() {
        gestorDeCompras = new GestorDeComprasNormal(this);
    }

    public boolean perdioElJuego() {
        return getUnidades().size() == 0 && !gestorDeCompras.puedeComprar();
    }

    public boolean esMiUnidad(Unidad unidad) {
        return unidades.contains(unidad);
    }

    public boolean noEsMiUnidad(Unidad unidad) {
        return !esMiUnidad(unidad);
    }
}
