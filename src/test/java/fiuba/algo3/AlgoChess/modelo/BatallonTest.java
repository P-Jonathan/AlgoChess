package fiuba.algo3.AlgoChess.modelo;

import fiuba.algo3.AlgoChess.modelo.unidades.UnidadDeInfanteria;
import fiuba.algo3.AlgoChess.modelo.tablero.Posicion;
import fiuba.algo3.AlgoChess.modelo.tablero.Tablero;
import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BatallonTest {
    @Test
    void armoUnBatallonEnFilaYAlMoverLaUnidadDelMedioAdelanteDeberiaMoverseTodoElBatallon() {
        Tablero tablero = new Tablero();
        Unidad unidad1 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad3 = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(unidad1, new Posicion(2,3));
        tablero.posicionarUnidad(unidad2, new Posicion(2,2));
        tablero.posicionarUnidad(unidad3, new Posicion(2,1));

        unidad2.moverHaciaAdelante();

        assertEquals(unidad1, tablero.getUnidadEnPosicion(new Posicion(3, 3)));
        assertEquals(unidad2, tablero.getUnidadEnPosicion(new Posicion(3, 2)));
        assertEquals(unidad3, tablero.getUnidadEnPosicion(new Posicion(3, 1)));
    }

    @Test
    void armoUnBatallonEnFilaYAlMoverLaUnidadDelMedioAtrasDeberiaMoverseTodoElBatallon() {
        Tablero tablero = new Tablero();
        Unidad unidad1 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad3 = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(unidad1, new Posicion(2,3));
        tablero.posicionarUnidad(unidad2, new Posicion(2,2));
        tablero.posicionarUnidad(unidad3, new Posicion(2,1));

        unidad2.moverHaciaAtras();

        assertEquals(unidad1, tablero.getUnidadEnPosicion(new Posicion(1, 3)));
        assertEquals(unidad2, tablero.getUnidadEnPosicion(new Posicion(1, 3)));
        assertEquals(unidad3, tablero.getUnidadEnPosicion(new Posicion(1, 3)));
    }

    @Test
    void armoUnBatallonEnColumnaYAlMoverLaUnidadDelMedioHaciaLaDerechaDeberiaMoverseTodoElBatallon() {
        Tablero tablero = new Tablero();
        Unidad unidad1 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad3 = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(unidad1, new Posicion(3,2));
        tablero.posicionarUnidad(unidad2, new Posicion(2,2));
        tablero.posicionarUnidad(unidad3, new Posicion(1,2));

        unidad2.moverALaDerecha();

        assertEquals(unidad1, tablero.getUnidadEnPosicion(new Posicion(3, 3)));
        assertEquals(unidad2, tablero.getUnidadEnPosicion(new Posicion(2, 3)));
        assertEquals(unidad3, tablero.getUnidadEnPosicion(new Posicion(1, 3)));
    }

    @Test
    void armoUnBatallonEnColumnaYAlMoverLaUnidadDelMedioHaciaLaIzquierdaDeberiaMoverseTodoElBatallon() {
        Tablero tablero = new Tablero();
        Unidad unidad1 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad3 = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(unidad1, new Posicion(3,2));
        tablero.posicionarUnidad(unidad2, new Posicion(2,2));
        tablero.posicionarUnidad(unidad3, new Posicion(1,2));

        unidad2.moverHaciaAtras();

        assertEquals(unidad1, tablero.getUnidadEnPosicion(new Posicion(3, 1)));
        assertEquals(unidad2, tablero.getUnidadEnPosicion(new Posicion(2, 1)));
        assertEquals(unidad3, tablero.getUnidadEnPosicion(new Posicion(1, 1)));
    }

    @Test
    void posiciono4UnidadesDeInfanteriaJuntasYDeberianMoverseSolo3() {
        Tablero tablero = new Tablero();
        Unidad unidad1 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad3 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad4 = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(unidad1, new Posicion(5,5));
        tablero.posicionarUnidad(unidad2, new Posicion(5,4));
        tablero.posicionarUnidad(unidad3, new Posicion(5,3));
        tablero.posicionarUnidad(unidad4, new Posicion(5,2));

        unidad2.moverHaciaAdelante();

        assertEquals(unidad1, tablero.getUnidadEnPosicion(new Posicion(5, 5)));
        assertEquals(unidad2, tablero.getUnidadEnPosicion(new Posicion(6, 4)));
        assertEquals(unidad3, tablero.getUnidadEnPosicion(new Posicion(6, 3)));
        assertEquals(unidad4, tablero.getUnidadEnPosicion(new Posicion(6, 2)));
    }


    @Test
    void verificoQueNoSeArmaUnBatallonConUnidadesQueNoSeanDeInfanteria() {
        Tablero tablero = new Tablero();
        Unidad unidad1 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad2 = new UnidadDeInfanteria(tablero.getJugadorA());
        Unidad unidad3 = new UnidadDeInfanteria(tablero.getJugadorA());

        tablero.posicionarUnidad(unidad1, new Posicion(3,4));
        tablero.posicionarUnidad(unidad2, new Posicion(3,3));
        tablero.posicionarUnidad(unidad3, new Posicion(3,2));

        unidad2.moverHaciaAtras();

        assertEquals(unidad1, tablero.getUnidadEnPosicion(new Posicion(3, 4)));
        assertEquals(unidad2, tablero.getUnidadEnPosicion(new Posicion(4, 3)));
        assertEquals(unidad3, tablero.getUnidadEnPosicion(new Posicion(3, 2)));
    }
}
