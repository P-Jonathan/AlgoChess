package fiuba.algo3.AlgoChess;

public class Curandero extends Unidad {
    private int curacion;

    public Curandero() {
        vida = 75;
        curacion = 15;
    }

    public void curar(Unidad objetivo) {
        objetivo.aumentarVida(curacion);
    }

}