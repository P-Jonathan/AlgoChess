package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fiuba.algo3.AlgoChess.excepciones.CasillaOcupadaException;
import fiuba.algo3.AlgoChess.unidades.Curandero;
import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

public class UnidadMovibleTest {
    @Test
    public void creoUnaUnidadMovibleLaMuevoYSuPosicionDeberiaCambiar() {
        Tablero tablero = new Tablero();
        UnidadDeInfanteria soldado = new UnidadDeInfanteria();

        tablero.posicionarUnidad(soldado, 2, 2);

        tablero.moverUnidadAdelante(soldado);

        UnidadDeInfanteria soldado2 = new UnidadDeInfanteria();

        assertDoesNotThrow( ()-> {
                tablero.posicionarUnidad(soldado2, 2, 2);
        });
    }

    @Test
    public void creoUnaUnidadMovibleLaMuevoAUnaCasillaOcupadaEIntentoPonerUnaUnidadEnSuPosicionYDeberiaLanzarUnaException() {
        Tablero tablero = new Tablero();
        UnidadDeInfanteria soldado1 = new UnidadDeInfanteria();
        UnidadDeInfanteria soldado2 = new UnidadDeInfanteria();
        UnidadDeInfanteria soldado3 = new UnidadDeInfanteria();

        tablero.posicionarUnidad(soldado1, 2, 2);
        tablero.posicionarUnidad(soldado2, 3, 2);

        try {
            tablero.moverUnidadAdelante(soldado1);
        } catch(CasillaOcupadaException e){
            // No hago nada
        }

        assertThrows(CasillaOcupadaException.class, ()-> {
            tablero.posicionarUnidad(soldado3, 2, 2);
        });
    }

    @Test
    public void unaUnidadMovibleNoDeberiaMoverseAUnCasilleroOcupado() {
        Tablero tablero = new Tablero();

        UnidadDeInfanteria soldado1 = new UnidadDeInfanteria();
        UnidadDeInfanteria soldado2 = new UnidadDeInfanteria();

        tablero.posicionarUnidad(soldado1, 2,2);
        tablero.posicionarUnidad(soldado2, 1,2);

        assertThrows(CasillaOcupadaException.class, ()->{
            tablero.moverUnidadAdelante(soldado2);
        });
    }

    @Test
    public void muevoUnCuranderoAdelanteYSuPosicionDeberiaCambiar() {
        Tablero t = new Tablero();
        Curandero c1 = new Curandero();
        Curandero c2 = new Curandero();

        t.posicionarUnidad(c1, 5, 5);
        t.moverUnidadAdelante(c1);

        assertDoesNotThrow( ()->{
            t.posicionarUnidad(c2, 5, 5);
        });
    }

    @Test
    public void muevoUnCuranderoAtrasYSuPosicionDeberiaCambiar() {
        Tablero t = new Tablero();
        Curandero c1 = new Curandero();
        Curandero c2 = new Curandero();

        t.posicionarUnidad(c1, 5, 5);
        t.moverUnidadAtras(c1);

        assertDoesNotThrow( ()->{
            t.posicionarUnidad(c2, 5, 5);
        });
    }

    @Test
    public void muevoUnCuranderoHaciaLaDerechaYSuPosicionDeberiaCambiar() {
        Tablero t = new Tablero();
        Curandero c1 = new Curandero();
        Curandero c2 = new Curandero();

        t.posicionarUnidad(c1, 5, 5);
        t.moverUnidadDerecha(c1);

        assertDoesNotThrow( ()->{
            t.posicionarUnidad(c2, 5, 5);
        });
    }

}
