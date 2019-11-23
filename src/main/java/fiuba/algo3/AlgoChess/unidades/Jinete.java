package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.ataques.*;
import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.tablero.Casilla;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Jinete extends Unidad implements UnidadMovible, UnidadOfensiva {
	private final static int VIDA_INICIAL = 100;
	private final static int COSTO = 3;

	private Ataque ataque;

	private final static int DANIO_CORTA_DISTANCIA = 5;
	private final static int DANIO_MEDIA_DISTANCIA = 15;

	public Jinete(String bando) {
		super(bando, VIDA_INICIAL, COSTO);
		ataque = new AtaqueACortaDistancia(DANIO_CORTA_DISTANCIA);
	}

	public Jinete() {
		super("", VIDA_INICIAL, COSTO);
		ataque = new AtaqueACortaDistancia(DANIO_CORTA_DISTANCIA);
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

	@Override
	public void prepararAtaque(Casilla[][] casillas, Unidad objetivo) {
		double distanciaAObjetivo = casillaActual.distanciaAUnidad(casillas, objetivo);

		if(distanciaAObjetivo > 6) {
			ataque = new AtaqueNull();
		} else {
		    ArrayList<Unidad> unidadesCerca = casillaActual.unidadesCercanas(casillas);
		    unidadesCerca.remove(this);
		    Iterator<Unidad> iter = unidadesCerca.iterator();
		    boolean enemigosCerca = false;

		   while(iter.hasNext() && !enemigosCerca) {
				Unidad unidadCerca = iter.next();
				enemigosCerca = unidadCerca.noPertenceA(bando);
		   }

			if(enemigosCerca && distanciaAObjetivo <= 3){
				ataque = new AtaqueACortaDistancia(DANIO_CORTA_DISTANCIA);
			} else if(enemigosCerca && distanciaAObjetivo > 3){
				ataque = new AtaqueNull();
			} else if (!enemigosCerca && distanciaAObjetivo > 3){
				ataque = new AtaqueAMediaDistancia(DANIO_MEDIA_DISTANCIA);
			}
		}
	}

	@Override
	public void atacar(Unidad objetivo) {
		ataque.atacar(objetivo);
	}
}
