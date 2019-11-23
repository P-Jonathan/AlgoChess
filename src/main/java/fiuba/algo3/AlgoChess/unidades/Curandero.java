package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;
import fiuba.algo3.AlgoChess.tablero.Casilla;

import java.util.ArrayList;

public class Curandero extends Unidad implements UnidadMovible {
	private final static int VIDA_INICIAL = 75;
	private final static int COSTO = 2;

	private int curacion;

	public Curandero(String bando) {
		super(bando, VIDA_INICIAL, COSTO);
		curacion = 15;
	}

	public Curandero() {
		super("", VIDA_INICIAL, COSTO);
		curacion = 15;
	}

    @Override
    public void agregateA(ArrayList<Unidad> unidades){
        unidades.add(this);
    }

    @Override
    public void moverAdelante(Casilla[][] casillas) {
        Casilla casillaDestino = casillaActual.casillaAdelante(casillas);
        Casilla casillaAnterior = casillaActual;

        casillaDestino.ocuparCon(this);
        casillaAnterior.desocupar();
    }

    @Override
    public void moverDerecha(Casilla[][] casillas) {
        Casilla casillaDestino = casillaActual.casillaDerecha(casillas);
        Casilla casillaAnterior = casillaActual;

        casillaDestino.ocuparCon(this);
        casillaAnterior.desocupar();
    }

    @Override
    public void moverAbajo(Casilla[][] casillas) {
        Casilla casillaDestino = casillaActual.casillaTrasera(casillas);
        Casilla casillaAnterior = casillaActual;

        casillaDestino.ocuparCon(this);
        casillaAnterior.desocupar();
    }

    @Override
    public void moverIzquierda(Casilla[][] casillas) {
        Casilla casillaDestino = casillaActual.casillaIzquierda(casillas);
        Casilla casillaAnterior = casillaActual;

        casillaDestino.ocuparCon(this);
        casillaAnterior.desocupar();
    }

	public void curar(Unidad objetivo) {
		objetivo.aumentarVida(curacion);
	}
}