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
	public void moverAdelante(Casilla[][] casillas) {
		Casilla destino = casillaActual.casillaAdelante(casillas);

		destino.ocuparCon(this);
		casillaActual.desocupar();
		casillaActual = destino;
		filaActual++;
	}

	@Override
	public void moverDerecha(Casilla[][] casillas) {
		Casilla destino = casillaActual.casillaDerecha(casillas);

		destino.ocuparCon(this);
		casillaActual.desocupar();
		casillaActual = destino;
		columnaActual++;
	}

	@Override
	public void moverAbajo(Casilla[][] casillas) {
		Casilla destino = casillaActual.casillaTrasera(casillas);

		destino.ocuparCon(this);
		casillaActual.desocupar();
		casillaActual = destino;
		filaActual--;
	}

	@Override
	public void moverIzquierda(Casilla[][] casillas) {
		Casilla destino = casillaActual.casillaIzquierda(casillas);

		destino.ocuparCon(this);
		casillaActual.desocupar();
		casillaActual = destino;
		columnaActual--;
	}

	@Override
	public void prepararAtaque(Casilla[][] casillas, Unidad objetivo) {
		ArrayList<Casilla> casillasCercanas;
		double distanciaAObjetivo = casillaActual.distanciaAUnidad(casillas, objetivo);

		if(distanciaAObjetivo > 6) {
			ataque = new AtaqueNull();
		} else {
			casillasCercanas = casillaActual.getCasillasCercanas(casillas);
			ArrayList<Boolean> enemigosCerca = new ArrayList<Boolean>();
			ArrayList<Boolean> aliadosCerca = new ArrayList<Boolean>();

			for(Casilla casillaCercana : casillasCercanas){
				enemigosCerca.add(casillaCercana.ocupadaConUnidadEnemiga(bando));
				aliadosCerca.add(casillaCercana.ocupadaConUnidadAliada(bando));
			}

			if(enemigosCerca.contains(true) && distanciaAObjetivo <= 3){
				ataque = new AtaqueACortaDistancia(DANIO_CORTA_DISTANCIA);
			} else if(enemigosCerca.contains(true) && distanciaAObjetivo > 3){
				ataque = new AtaqueNull();
			} else if ((aliadosCerca.contains(true) || !enemigosCerca.contains(true)) && distanciaAObjetivo > 3){
				ataque = new AtaqueAMediaDistancia(DANIO_MEDIA_DISTANCIA);
			}
		}
	}

	@Override
	public void atacar(Unidad objetivo) {
		ataque.atacar(objetivo);
	}
}
