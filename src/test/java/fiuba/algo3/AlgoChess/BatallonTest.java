package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Unidad;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BatallonTest {
    @Test
    public void armoUnBatallonEnFilaYAlMoverLaUnidadAdelanteDeberiaMoverseTodoElBatallon() {
        Tablero t = new Tablero();
        UnidadDeInfanteria u1 = new UnidadDeInfanteria();
        UnidadDeInfanteria u2 = new UnidadDeInfanteria();
        UnidadDeInfanteria u3 = new UnidadDeInfanteria();
        UnidadDeInfanteria u4 = new UnidadDeInfanteria();
        UnidadDeInfanteria u5 = new UnidadDeInfanteria();
        UnidadDeInfanteria u6 = new UnidadDeInfanteria();

        t.posicionarUnidad(u1, 2,2);
        t.posicionarUnidad(u2, 2,3);
        t.posicionarUnidad(u3, 2,1);

        t.moverUnidadAdelante(u1);

        assertDoesNotThrow( ()-> {
           t.posicionarUnidad(u4, 2, 2);
           t.posicionarUnidad(u5, 2, 3);
           t.posicionarUnidad(u6, 2, 1);
        });
    }

    @Test
    public void armoUnBatallonEnFilaYAlMoverLaUnidadDeLaPuntaAdelanteDeberiaMoverseTodoElBatallon() {
        Tablero t = new Tablero();
        UnidadDeInfanteria u1 = new UnidadDeInfanteria();
        UnidadDeInfanteria u2 = new UnidadDeInfanteria();
        UnidadDeInfanteria u3 = new UnidadDeInfanteria();
        UnidadDeInfanteria u4 = new UnidadDeInfanteria();
        UnidadDeInfanteria u5 = new UnidadDeInfanteria();
        UnidadDeInfanteria u6 = new UnidadDeInfanteria();

        t.posicionarUnidad(u1, 2,2);
        t.posicionarUnidad(u2, 2,3);
        t.posicionarUnidad(u3, 2,1);

        t.moverUnidadAdelante(u3);

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u4, 2, 2);
            t.posicionarUnidad(u5, 2, 3);
            t.posicionarUnidad(u6, 2, 1);
        });
    }

    @Test
    public void armoUnBatallonEnColumnaYAlMoverLaUnidadAdelanteDeberiaMoverseTodoElBatallon() {
        Tablero t = new Tablero();
        UnidadDeInfanteria u1 = new UnidadDeInfanteria();
        UnidadDeInfanteria u2 = new UnidadDeInfanteria();
        UnidadDeInfanteria u3 = new UnidadDeInfanteria();
        UnidadDeInfanteria u4 = new UnidadDeInfanteria();

        t.posicionarUnidad(u1, 2,2);
        t.posicionarUnidad(u2, 3,2);
        t.posicionarUnidad(u3, 1,2);

        t.moverUnidadAdelante(u2);

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u4, 3, 2);
        });
    }

    @Test
    public void armoUnBatallonEnColumnaYAlMoverLaUnidadAtrasDeberiaMoverseTodoElBatallon() {
        Tablero t = new Tablero();
        UnidadDeInfanteria u1 = new UnidadDeInfanteria();
        UnidadDeInfanteria u2 = new UnidadDeInfanteria();
        UnidadDeInfanteria u3 = new UnidadDeInfanteria();
        UnidadDeInfanteria u4 = new UnidadDeInfanteria();

        t.posicionarUnidad(u1, 2,2);
        t.posicionarUnidad(u2, 3,2);
        t.posicionarUnidad(u3, 1,2);

        t.moverUnidadAtras(u3);

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u4, 3, 2);
        });
    }
}
