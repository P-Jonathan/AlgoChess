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

}
