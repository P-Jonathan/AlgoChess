package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Jinete;
import fiuba.algo3.AlgoChess.unidades.Unidad;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JineteTest {
    @Test
    public void unJineteAtacaUnaUnidadEnemigaADistanciaMediaYDeberiaRestarle15DeVida() {
        Tablero tablero = new Tablero("P1", "P2");

        Jinete jinete = new Jinete("P1");
        Unidad objetivo = new UnidadDeInfanteria("P2");

        tablero.posicionarUnidad(jinete, 8,8);
        tablero.posicionarUnidad(objetivo, 12,12);

        tablero.atacarConUnidadAUnidad(jinete,objetivo);

        assertEquals(objetivo.getVida(), 85);
    }

    @Test
    public void unJineteAtacaUnaUnidadCuerpoACuerpoAUnaUnidadEnemigaYDeberiaRestarle5DeVida() {
        Tablero tablero = new Tablero("P1", "P2");

        Jinete jinete = new Jinete("P1");
        Unidad objetivo = new UnidadDeInfanteria("P2");

        tablero.posicionarUnidad(jinete, 9,9);
        tablero.posicionarUnidad(objetivo, 10,10);

        tablero.moverUnidadAdelante(jinete);

        int vidaPrevia = objetivo.getVida();

        tablero.atacarConUnidadAUnidad(jinete, objetivo);

        assertEquals(vidaPrevia - 5, objetivo.getVida());
    }

    @Test
    public void unJineteAtacaAUnEnemigoADistanciaMediaTeniendoUnSoldadoAliadoCercaYDeberiaQuitarle15DeVida() {
        Tablero tablero = new Tablero("P1", "P2");

        Jinete jinete = new Jinete("P1");
        Unidad infanteriaAliada = new UnidadDeInfanteria("P1");
        Unidad infanteriaEnemiga = new UnidadDeInfanteria("P2");

        tablero.posicionarUnidad(jinete, 9,9);
        tablero.posicionarUnidad(infanteriaAliada, 8,9);
        tablero.posicionarUnidad(infanteriaEnemiga, 10,13);


        int vidaPrevia = infanteriaEnemiga.getVida();

        tablero.atacarConUnidadAUnidad(jinete, infanteriaEnemiga);

        assertEquals(vidaPrevia - 15, infanteriaEnemiga.getVida());
    }

    @Test
    public void unJineteAtacaAUnEnemigoADistanciaMediaTeniendoUnSoldadoEnemigoCercaYNoDeberiaQuitarlePuntosDeVida() {
        Tablero tablero = new Tablero("P1", "P2");

        Jinete jinete = new Jinete("P1");
        Unidad infanteriaEnemiga1 = new UnidadDeInfanteria("P2");
        Unidad infanteriaEnemiga2 = new UnidadDeInfanteria("P2");

        tablero.posicionarUnidad(jinete, 9,9);
        tablero.posicionarUnidad(infanteriaEnemiga1, 11,10);
        tablero.posicionarUnidad(infanteriaEnemiga2, 10,15);

        tablero.moverUnidadAdelante(jinete);

        int vidaPrevia = infanteriaEnemiga2.getVida();

        tablero.atacarConUnidadAUnidad(jinete, infanteriaEnemiga2);

        assertEquals(vidaPrevia, infanteriaEnemiga2.getVida());
    }

    @Test
    public void unJineteAtacaAUnEnemigoADistanciaCortaTeniendoUnSoldadoEnemigoCercaYDeberiaQuitarle5PuntosDeVida() {
        Tablero tablero = new Tablero("P1", "P2");

        Jinete jinete = new Jinete("P1");
        Unidad infanteriaEnemiga1 = new UnidadDeInfanteria("P2");
        Unidad infanteriaEnemiga2 = new UnidadDeInfanteria("P2");

        tablero.posicionarUnidad(jinete, 9,9);
        tablero.posicionarUnidad(infanteriaEnemiga1, 10,10);
        tablero.posicionarUnidad(infanteriaEnemiga2, 10,11);


        int vidaPrevia = infanteriaEnemiga2.getVida();

        tablero.atacarConUnidadAUnidad(jinete, infanteriaEnemiga2);

        assertEquals(vidaPrevia - 5, infanteriaEnemiga2.getVida());
    }
}
