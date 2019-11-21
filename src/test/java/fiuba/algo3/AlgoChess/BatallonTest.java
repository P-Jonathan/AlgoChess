package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BatallonTest {
    @Test
    public void armoUnBatallonEnFilaYAlMoverLaUnidadDelMedioAdelanteDeberiaMoverseTodoElBatallon() {
        Tablero t = new Tablero();
        UnidadDeInfanteria u1 = new UnidadDeInfanteria();
        UnidadDeInfanteria u2 = new UnidadDeInfanteria();
        UnidadDeInfanteria u3 = new UnidadDeInfanteria();
        UnidadDeInfanteria u4 = new UnidadDeInfanteria();
        UnidadDeInfanteria u5 = new UnidadDeInfanteria();
        UnidadDeInfanteria u6 = new UnidadDeInfanteria();

        t.posicionarUnidad(u1, 2,3);
        t.posicionarUnidad(u2, 2,2);
        t.posicionarUnidad(u3, 2,1);

        t.moverUnidadAdelante(u2);

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u4, 2, 3);
        });

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u5, 2, 2);
        });

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u6, 2, 1);
        });
    }

    @Test
    public void armoUnBatallonEnFilaYAlMoverLaUnidadDelMedioAtrasDeberiaMoverseTodoElBatallon() {
        Tablero t = new Tablero();
        UnidadDeInfanteria u1 = new UnidadDeInfanteria();
        UnidadDeInfanteria u2 = new UnidadDeInfanteria();
        UnidadDeInfanteria u3 = new UnidadDeInfanteria();
        UnidadDeInfanteria u4 = new UnidadDeInfanteria();
        UnidadDeInfanteria u5 = new UnidadDeInfanteria();
        UnidadDeInfanteria u6 = new UnidadDeInfanteria();

        t.posicionarUnidad(u1, 2,3);
        t.posicionarUnidad(u2, 2,2);
        t.posicionarUnidad(u3, 2,1);

        t.moverUnidadAtras(u2);

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u4, 2, 3);
        });

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u5, 2, 2);
        });

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u6, 2, 1);
        });
    }

    @Test
    public void armoUnBatallonEnColumnaYAlMoverLaUnidadDelMedioHaciaLaDerechaDeberiaMoverseTodoElBatallon() {
        Tablero t = new Tablero();
        UnidadDeInfanteria u1 = new UnidadDeInfanteria();
        UnidadDeInfanteria u2 = new UnidadDeInfanteria();
        UnidadDeInfanteria u3 = new UnidadDeInfanteria();
        UnidadDeInfanteria u4 = new UnidadDeInfanteria();
        UnidadDeInfanteria u5 = new UnidadDeInfanteria();
        UnidadDeInfanteria u6 = new UnidadDeInfanteria();

        t.posicionarUnidad(u1, 3,2);
        t.posicionarUnidad(u2, 2,2);
        t.posicionarUnidad(u3, 1,2);

        t.moverUnidadDerecha(u2);

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u4, 3, 2);
        });

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u5, 2, 2);
        });

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u6, 1, 2);
        });
    }

    @Test
    public void armoUnBatallonEnColumnaYAlMoverLaUnidadDelMedioHaciaLaIzquierdaDeberiaMoverseTodoElBatallon() {
        Tablero t = new Tablero();
        UnidadDeInfanteria u1 = new UnidadDeInfanteria();
        UnidadDeInfanteria u2 = new UnidadDeInfanteria();
        UnidadDeInfanteria u3 = new UnidadDeInfanteria();
        UnidadDeInfanteria u4 = new UnidadDeInfanteria();
        UnidadDeInfanteria u5 = new UnidadDeInfanteria();
        UnidadDeInfanteria u6 = new UnidadDeInfanteria();

        t.posicionarUnidad(u1, 3,2);
        t.posicionarUnidad(u2, 2,2);
        t.posicionarUnidad(u3, 1,2);

        t.moverUnidadIzquierda(u2);

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u4, 3, 2);
        });

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u5, 2, 2);
        });

        assertDoesNotThrow( ()-> {
            t.posicionarUnidad(u6, 1, 2);
        });
    }
}
