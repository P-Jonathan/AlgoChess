package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuranderoTest {
    @Test
    public void creoUnidadCUranderoYAlQuitarle50DeVidaLeQuedan25() {
        Curandero curandero = new Curandero();
        assertEquals(curandero.getVida(), 75);
        curandero.recibirDanio(50);
        assertEquals(curandero.getVida(), 50);
    }

    @Test
    void creoUnidadCUranderoLeAumentoLaVidaEn20YSuVidaEs95() {
        Curandero curandero = new Curandero();
        assertEquals(curandero.getVida(), 75);
        curandero.aumentarVida(20);
        assertEquals(curandero.getVida(), 120);
    }

    @Test
    void creoCUranderoLeQuito25DeVidaYSuVidaEs50() {
        Curandero curandero = new Curandero();
        assertEquals(curandero.getVida(), 75);
        curandero.recibirDanio(25);
        assertEquals(curandero.getVida(), 50);
    }


    @Test
    public void unCuranderoCuraAUnaUNidadDeInfanteriaYSuVidaDeberiaAumentarEn15() {
        Curander curandero = new Curandero();
        UnidadDeInfanteria soldado = new UnidadDeInfanteria();
        assertEquals(soldado.getVida(), 100);
        curandero.curar(soldado);
        assertEquals(soldado.getVida(), 115);
    }

}