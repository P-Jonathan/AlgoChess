package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtaquesUnidadesTest {

    @Test
    public void unaUnidadDeInfanteriaAtacaAOtraUnidadDeInfanteriaYDeberiaRestarle10DeVida() {
        UnidadDeInfanteria soldadoAliado = new UnidadDeInfanteria();
        UnidadDeInfanteria soldadoEnemigo = new UnidadDeInfanteria();

        assertEquals(soldadoEnemigo.getVida(), 100);

        soldadoAliado.atacar(soldadoEnemigo);

        assertEquals(soldadoEnemigo.getVida(), 90);
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
