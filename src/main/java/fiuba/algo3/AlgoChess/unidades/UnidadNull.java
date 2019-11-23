package fiuba.algo3.AlgoChess.unidades;

import java.util.ArrayList;

public class UnidadNull extends Unidad {
    public UnidadNull(){
        super("",0,0);
    }

    @Override
    public void agregateA(ArrayList<Unidad> unidades){}

    @Override
    public void recibirDanio(int danio) {}

    @Override
    public void aumentarVida(int vida) {}
}
