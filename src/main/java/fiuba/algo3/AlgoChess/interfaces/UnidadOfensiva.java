package fiuba.algo3.AlgoChess.interfaces;

import fiuba.algo3.AlgoChess.unidades.Unidad;

public interface UnidadOfensiva {
	public void atacar(Unidad objetivo);
	public void prepararAtaqueADistancia(double distancia);
}
