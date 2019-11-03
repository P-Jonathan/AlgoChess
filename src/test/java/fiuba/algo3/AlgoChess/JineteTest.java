package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JineteTest {
    @Test
    public void creoUnidadYAlQuitarle50DeVidaLeQuedan50() {
        Jinete jinete = new Jinete();
        assertEquals(jinete.getVida(), 100);
        jinete.recibirDanio(50);
        assertEquals(jinete.getVida(), 50);
    }

    @Test
    void creoUnidadLeAumentoLaVidaEn20YSuVidaEs120() {
        Jinete jinete = new Jinete();
        assertEquals(jinete.getVida(), 100);
        jinete.aumentarVida(20);
        assertEquals(jinete.getVida(), 120);
    }

    @Test
    void creoJineteLeQuito80DeVidaYSuVidaEs20() {
        Jinete jinete = new Jinete();
        assertEquals(jinete.getVida(), 100);
        jinete.recibirDanio(80);
        assertEquals(jinete.getVida(), 20);
    }


    @Test
    public void unJineteAtacaUnaUnidadDeInfanteriaADistanciaYDeberiaRestarle15DeVida() {
        Jinete jinete = new Jinete();
        UnidadDeInfanteria soldado = new UnidadDeInfanteria();

        assertEquals(soldado.getVida(), 100);

        jinete.atacarADistancia(soldado);

        assertEquals(soldado.getVida(), 85);
    }

    @Test
    public void unJineteAtacaUnaUnidadDeInfanteriaCuerpoACuerpoYDeberiaRestarle5DeVida() {
        Jinete jinete = new Jinete();
        UnidadDeInfanteria soldado = new UnidadDeInfanteria();

        assertEquals(soldado.getVida(), 100);

        jinete.atacarAMelee(soldado);

        assertEquals(soldado.getVida(), 95);
    }

}
