package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.ataques.*;
import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.interfaces.UnidadMovible;
import fiuba.algo3.AlgoChess.interfaces.UnidadOfensiva;
import fiuba.algo3.AlgoChess.tablero.Casilla;

import java.util.ArrayList;

public class UnidadDeInfanteria extends Unidad implements UnidadMovible, UnidadOfensiva {
	private final static int VIDA_INICIAL = 100;
	private final static int DANIO_INICIAL = 10;
	private final static int COSTO = 1;

	private Ataque ataque;

	public UnidadDeInfanteria(String bando) {
		super(bando, VIDA_INICIAL, COSTO);
		ataque = new AtaqueACortaDistancia(DANIO_INICIAL);
	}

	public UnidadDeInfanteria() {
		super("", VIDA_INICIAL, COSTO);
		ataque = new AtaqueACortaDistancia(DANIO_INICIAL);
	}

	@Override
	public void agregateA(ArrayList<Unidad> unidades){
		unidades.add(this);
	}

	@Override
	public void reclutar(Batallon batallon) {
		batallon.agregar(this);
	}

	public Batallon armarBatallon(UnidadDeInfanteria capitan, ArrayList<Unidad> unidades) {
		Batallon batallon = new Batallon();
		batallon.agregar(capitan);

		for(Unidad unidad : unidades) {
			unidad.reclutar(batallon);
		}

		return batallon;
	}

	@Override
    public void moverAdelante(Casilla[][] casillas) {
		ArrayList<Unidad> unidades = casillaActual.getUnidadesAdyacentes(casillas, this);
        Batallon batallon = armarBatallon(this, unidades);

        if(batallon.lleno())
        	batallon.moverAdelante(casillas);
        else
			avanzarNorte(casillas);
	}

	public void avanzarNorte(Casilla[][] casillas) {
		Casilla casillaDestino = casillaActual.casillaAdelante(casillas);
		Casilla casillaAnterior = casillaActual;

		casillaDestino.ocuparCon(this);
		casillaAnterior.desocupar();
	}

	@Override
	public void moverDerecha(Casilla[][] casillas) {
		ArrayList<Unidad> unidades = casillaActual.getUnidadesAdyacentes(casillas, this);
		Batallon batallon = armarBatallon(this, unidades);

		if(batallon.lleno())
			batallon.moverDerecha(casillas);
		else
			avanzarEste(casillas);
	}

	public void avanzarEste(Casilla[][] casillas) {
		Casilla casillaDestino = casillaActual.casillaDerecha(casillas);
        Casilla casillaAnterior = casillaActual;

        casillaDestino.ocuparCon(this);
        casillaAnterior.desocupar();
	}

	@Override
	public void moverAbajo(Casilla[][] casillas) {
		ArrayList<Unidad> unidades = casillaActual.getUnidadesAdyacentes(casillas, this);
		Batallon batallon = armarBatallon(this, unidades);

		if(batallon.lleno())
			batallon.moverAbajo(casillas);
		else
			avanzarSur(casillas);
	}

	public void avanzarSur(Casilla[][] casillas) {
		Casilla casillaDestino = casillaActual.casillaTrasera(casillas);
        Casilla casillaAnterior = casillaActual;

        casillaDestino.ocuparCon(this);
        casillaAnterior.desocupar();
	}

	@Override
	public void moverIzquierda(Casilla[][] casillas) {
		ArrayList<Unidad> unidades = casillaActual.getUnidadesAdyacentes(casillas, this);
		Batallon batallon = armarBatallon(this, unidades);

		if(batallon.lleno())
			batallon.moverIzquierda(casillas);
		else
			avanzarOeste(casillas);
	}

	public void avanzarOeste(Casilla[][] casillas) {
		Casilla casillaDestino = casillaActual.casillaIzquierda(casillas);
        Casilla casillaAnterior = casillaActual;

        casillaDestino.ocuparCon(this);
        casillaAnterior.desocupar();
	}

	@Override
	public void prepararAtaque(Casilla[][] casillas, Unidad objetivo) {
		double distanciaAObjetivo = casillaActual.distanciaAUnidad(casillas, objetivo);

		if(distanciaAObjetivo > 0 && distanciaAObjetivo <= 3)
			ataque = new AtaqueACortaDistancia(DANIO_INICIAL);
		else
			ataque = new AtaqueNull();
	}

	@Override
	public void atacar(Unidad objetivo) {
		ataque.atacar(objetivo);
	}
}
