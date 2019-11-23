package fiuba.algo3.AlgoChess.unidades;

import java.lang.reflect.Array;
import java.util.ArrayList;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.tablero.Casilla;

public abstract class Unidad {
    // Atributos de inicializacion
    private int vida;
    private int costo;
    protected String bando;

    // Atributos de posicionamiento
    protected Casilla casillaActual;

    private Jugador jugador;

    public Unidad(String bando, int vida, int costo) {
            this.vida = vida;
            this.costo = costo;
            this.bando = bando;
    }

    public String posicion() {
        return casillaActual.posicion();
    }

    public int getVida() {
        return vida;
    }

    public int getCosto() {
        return costo;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void recibirDanio(int danio) {
        vida -= danio;

        if( vida <= 0)
            notificarJugador(jugador);
    }

    public void notificarJugador(Jugador jugador) {
        jugador.remover(this);
    }

    public void setCasillaActual(Casilla casilla){
        casillaActual = casilla;
    }

    public void aumentarVida(int vida) {
        this.vida += vida;
    };

    public void setBando(String bando) {
        this.bando = bando;
    }

    public abstract void agregateA(ArrayList<Unidad> unidades);

    public boolean pertenceA(String bando) {
        return this.bando == bando;
    }

    public boolean noPertenceA(String bando) {
        return this.bando != bando;
    }

    public void reclutar(Batallon batallon) {}

	public ArrayList<Unidad> getUnidadesAdyacentes(Casilla[][] casillas) {
		ArrayList<Unidad> unidadesAdyacentes;
		unidadesAdyacentes = casillaActual.getUnidadesAdyacentes(casillas, this);
		return unidadesAdyacentes;
	}
}
