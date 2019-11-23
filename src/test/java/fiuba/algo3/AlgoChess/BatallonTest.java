package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Curandero;
import fiuba.algo3.AlgoChess.unidades.Jinete;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BatallonTest {
    @Test
    public void armoUnBatallonEnFilaYAlMoverLaUnidadDelMedioAdelanteDeberiaMoverseTodoElBatallon() {
        Tablero t = new Tablero();
        UnidadDeInfanteria u1 = new UnidadDeInfanteria();
        UnidadDeInfanteria u2 = new UnidadDeInfanteria();
        UnidadDeInfanteria u3 = new UnidadDeInfanteria();


        t.posicionarUnidad(u1, 2,3);
        t.posicionarUnidad(u2, 2,2);
        t.posicionarUnidad(u3, 2,1);

        t.moverUnidadAdelante(u2);

        assertEquals(u1.posicion(), "3;3");
        assertEquals(u2.posicion(), "3;2");
        assertEquals(u3.posicion(), "3;1");
    }

    @Test
    public void armoUnBatallonEnFilaYAlMoverLaUnidadDelMedioAtrasDeberiaMoverseTodoElBatallon() {
        Tablero t = new Tablero();
        UnidadDeInfanteria u1 = new UnidadDeInfanteria();
        UnidadDeInfanteria u2 = new UnidadDeInfanteria();
        UnidadDeInfanteria u3 = new UnidadDeInfanteria();

        t.posicionarUnidad(u1, 2,3);
        t.posicionarUnidad(u2, 2,2);
        t.posicionarUnidad(u3, 2,1);

        t.moverUnidadAtras(u2);

        assertEquals(u1.posicion(), "1;3");
        assertEquals(u2.posicion(), "1;2");
        assertEquals(u3.posicion(), "1;1");
    }

    @Test
    public void armoUnBatallonEnColumnaYAlMoverLaUnidadDelMedioHaciaLaDerechaDeberiaMoverseTodoElBatallon() {
        Tablero t = new Tablero();
        UnidadDeInfanteria u1 = new UnidadDeInfanteria();
        UnidadDeInfanteria u2 = new UnidadDeInfanteria();
        UnidadDeInfanteria u3 = new UnidadDeInfanteria();

        t.posicionarUnidad(u1, 3,2);
        t.posicionarUnidad(u2, 2,2);
        t.posicionarUnidad(u3, 1,2);

        t.moverUnidadDerecha(u2);

        assertEquals(u1.posicion(), "3;3");
        assertEquals(u2.posicion(), "2;3");
        assertEquals(u3.posicion(), "1;3");
    }

    @Test
    public void armoUnBatallonEnColumnaYAlMoverLaUnidadDelMedioHaciaLaIzquierdaDeberiaMoverseTodoElBatallon() {
        Tablero t = new Tablero();
        UnidadDeInfanteria u1 = new UnidadDeInfanteria();
        UnidadDeInfanteria u2 = new UnidadDeInfanteria();
        UnidadDeInfanteria u3 = new UnidadDeInfanteria();

        t.posicionarUnidad(u1, 3,2);
        t.posicionarUnidad(u2, 2,2);
        t.posicionarUnidad(u3, 1,2);

        t.moverUnidadIzquierda(u2);

        assertEquals(u1.posicion(), "3;1");
        assertEquals(u2.posicion(), "2;1");
        assertEquals(u3.posicion(), "1;1");
    }

    @Test
    public void posiciono4UnidadesDeInfanteriaJuntasYDeberianMoverseSolo3() {
        Tablero t = new Tablero();
        UnidadDeInfanteria u1 = new UnidadDeInfanteria();
        UnidadDeInfanteria u2 = new UnidadDeInfanteria();
        UnidadDeInfanteria u3 = new UnidadDeInfanteria();
        UnidadDeInfanteria u4 = new UnidadDeInfanteria();
        UnidadDeInfanteria u5 = new UnidadDeInfanteria();

        t.posicionarUnidad(u1, 5,5);
        t.posicionarUnidad(u2, 5,4);
        t.posicionarUnidad(u3, 5,3);
        t.posicionarUnidad(u4, 5,2);

        t.moverUnidadAdelante(u3);

        assertEquals(u1.posicion(), "5;5");
        assertEquals(u2.posicion(), "6;4");
        assertEquals(u3.posicion(), "6;3");
        assertEquals(u4.posicion(), "6;2");
    }


    @Test
    public void verificoQueNoSeArmaUnBatallonConUnidadesQueNoSeanDeInfanteria() {
        Tablero t = new Tablero();

        UnidadDeInfanteria u = new UnidadDeInfanteria();
        Curandero c = new Curandero();
        Jinete j = new Jinete();

        t.posicionarUnidad(c, 3,4);
        t.posicionarUnidad(u, 3,3);
        t.posicionarUnidad(j, 3,2);

        t.moverUnidadAdelante(u);

        assertEquals(c.posicion(), "3;4");
        assertEquals(u.posicion(), "4;3");
        assertEquals(j.posicion(), "3;2");
    }

}
