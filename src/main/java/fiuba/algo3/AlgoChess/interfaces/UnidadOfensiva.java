package fiuba.algo3.AlgoChess.interfaces;

import fiuba.algo3.AlgoChess.ataques.Ataque;
import fiuba.algo3.AlgoChess.unidades.Unidad;

public interface UnidadOfensiva {
	public void atacar(Unidad enemigo);
	public void setAtaqueStrategy(Ataque ataque);
}
