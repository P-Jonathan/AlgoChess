package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Unidad;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.unidades.Curandero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CuranderoTest {
    @Test
    public void unCuranderoCuraAUnaUNidadDeInfanteriaYSuVidaDeberiaAumentarEn15() {
        Curandero curandero = new Curandero();
        UnidadDeInfanteria soldado = new UnidadDeInfanteria();

        assertEquals(soldado.getVida(), 100);

        curandero.curar(soldado);

        assertEquals(soldado.getVida(), 115);
    }

    @Test
    public void unCuranderoQueEsUnidadMoviblePuedeMoverseEnCualquierDireccion() {
        Tablero t = new Tablero();
        Curandero c = new Curandero();
        Unidad u = new UnidadDeInfanteria();

        t.posicionarUnidad(c,10,10);

        t.moverUnidadAdelante(c);
        t.moverUnidadAdelante(c);
        t.moverUnidadAdelante(c);
        assertThrows(CasillaOcupadaException.class, ()->{
            t.posicionarUnidad(u, 13,10);
        });

        t.moverUnidadDerecha(c);
        assertThrows(CasillaOcupadaException.class, ()->{
            t.posicionarUnidad(u, 13,11);
        });

        t.moverUnidadIzquierda(c);
        t.moverUnidadIzquierda(c);
        t.moverUnidadIzquierda(c);
        t.moverUnidadIzquierda(c);
        t.moverUnidadIzquierda(c);
        assertThrows(CasillaOcupadaException.class, ()->{
            t.posicionarUnidad(u, 13,6);
        });

        t.moverUnidadAtras(c);
        assertThrows(CasillaOcupadaException.class, ()->{
            t.posicionarUnidad(u, 12,6);
        });
    }
}