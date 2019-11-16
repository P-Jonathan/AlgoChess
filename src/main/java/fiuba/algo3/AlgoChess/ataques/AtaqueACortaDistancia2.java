package fiuba.algo3.AlgoChess.ataques;

import fiuba.algo3.AlgoChess.unidades.Unidad2;

public class AtaqueACortaDistancia2 extends Ataque2{
    private int danio;

    public AtaqueACortaDistancia2(int danio) {
        this.danio = danio;
    }

    @Override
    public void atacar(Unidad2 objetivo) {
        objetivo.recibirDanio(danio);
    }

}
