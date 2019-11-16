package fiuba.algo3.AlgoChess.unidades;

import fiuba.algo3.AlgoChess.ataques.Ataque2;
import fiuba.algo3.AlgoChess.ataques.AtaqueACortaDistancia2;
import fiuba.algo3.AlgoChess.ataques.AtaqueAMediaDistancia2;
import fiuba.algo3.AlgoChess.ataques.AtaqueNull;
import fiuba.algo3.AlgoChess.tablero.Casilla2;

public class Unidad2 {
    private Casilla2 casillaActual;
    private int filaActual;
    private int columnaActual;
    private int hp = 100;
    private Ataque2 ataqueStrategy = new AtaqueACortaDistancia2(10);

    public int getHp() {
        return hp;
    }

    public void atacar(Unidad2 objetivo, Casilla2[][] casillas) {
        casillaActual.distanciaA(objetivo, casillas);
        ataqueStrategy.atacar(objetivo);
    }

    public void recibirDanio(int danio) {
        hp -= danio;
    }

    public void setAtaqueStrategyParaObjetivoADistancia(double distancia) {
        if(distancia > 0 && distancia <= 3)
            ataqueStrategy = new AtaqueACortaDistancia2(10);
        else if(distancia > 3 && distancia <= 6)
            ataqueStrategy = new AtaqueAMediaDistancia2(20);
        else
            ataqueStrategy = new AtaqueNull();
    }

    public void setCasillaActual(Casilla2 casilla){
        casillaActual = casilla;
    }

    public void setCoords(int fila, int columna) {
        filaActual = fila;
        columnaActual = columna;
    }

    public String getCoords(){
        return (filaActual + " ; " + columnaActual);
    }

    public void moverAdelante(Casilla2[][] casillas) {
        Casilla2 destino = casillaActual.casillaAdelante(casillas);

        if(destino != null){
            casillaActual.desocupar();
            destino.ocuparCon(this);
            casillaActual = destino;
            filaActual++;
        }
    }

    public void moverDerecha(Casilla2[][] casillas) {
        Casilla2 destino = casillaActual.casillaDerecha(casillas);

        if(destino != null){
            casillaActual.desocupar();
            destino.ocuparCon(this);
            casillaActual = destino;
            columnaActual++;
        }
    }

    public void moverAbajo(Casilla2[][] casillas) {
        Casilla2 destino = casillaActual.casillaTrasera(casillas);

        if(destino != null){
            casillaActual.desocupar();
            destino.ocuparCon(this);
            casillaActual = destino;
            filaActual--;
        }
    }

    public void moverIzquierda(Casilla2[][] casillas) {
        Casilla2 destino = casillaActual.casillaIzquierda(casillas);

        if(destino != null){
            casillaActual.desocupar();
            destino.ocuparCon(this);
            casillaActual = destino;
            columnaActual--;
        }
    }
}
