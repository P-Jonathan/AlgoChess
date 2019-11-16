package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.tablero.Tablero2;
import fiuba.algo3.AlgoChess.unidades.Unidad2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Unidad2Test {
    @Test
    public void muevoUnaUnidadUbicadaEnElTablero() {
        Tablero2 t = new Tablero2();
        Unidad2 unidad = new Unidad2();
        t.posicionarUnidad(unidad, 5,5);

        t.moverUnidadAdelante(unidad);

        assertEquals(unidad.getCoords(), "6 ; 5");

        t.moverUnidadDerecha(unidad);

        assertEquals(unidad.getCoords(), "6 ; 6");

        t.moverUnidadAtras(unidad);
        t.moverUnidadAtras(unidad);

        assertEquals(unidad.getCoords(), "4 ; 6");

        t.moverUnidadIzquierda(unidad);
        t.moverUnidadIzquierda(unidad);
        t.moverUnidadIzquierda(unidad);
        t.moverUnidadIzquierda(unidad);

        assertEquals(unidad.getCoords(), "4 ; 2");
    }

    @Test
    public void muevoUnaUnidadAlBordeDelTableroYNoSeMueveNiLanzaExcepcion() {
        Tablero2 t = new Tablero2();
        Unidad2 unidad = new Unidad2();
        t.posicionarUnidad(unidad, 19,19);

        t.moverUnidadDerecha(unidad);

        assertEquals(unidad.getCoords(), "19 ; 19");
    }

    @Test
    public void atacoAUnaUnidadPosiccionadaEnElTableroADistanciaCortaYDeberiaRestarle10DeVidaALaAtacada() {
        Tablero2 t = new Tablero2();
        Unidad2 u1 = new Unidad2();
        Unidad2 u2 = new Unidad2();

        t.posicionarUnidad(u1, 5,5);
        t.posicionarUnidad(u2, 5,6);

        t.atacarConUnidadA(u1,u2);

        assertEquals(u2.getHp(), 90);
    }

    @Test
    public void atacoAUnaUnidadPosiccionadaEnElTableroADistanciaMediaYDeberiaRestarle20DeVidaALaAtacada() {
        Tablero2 t = new Tablero2();
        Unidad2 u1 = new Unidad2();
        Unidad2 u2 = new Unidad2();

        t.posicionarUnidad(u1, 5,5);
        t.posicionarUnidad(u2, 9,9);

        t.atacarConUnidadA(u1,u2);

        assertEquals(u2.getHp(), 80);
    }

    @Test
    public void atacoAUnaUnidadPosicionadaEnElTableroADistanciaLargaYNoDeberiaQuitarleVida() {
        Tablero2 t = new Tablero2();
        Unidad2 u1 = new Unidad2();
        Unidad2 u2 = new Unidad2();

        t.posicionarUnidad(u1, 5,5);
        t.posicionarUnidad(u2, 19,19);

        t.atacarConUnidadA(u1,u2);

        assertEquals(u2.getHp(), 100);
    }

}
