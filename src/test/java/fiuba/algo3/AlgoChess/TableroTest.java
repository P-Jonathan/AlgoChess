package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.Unidad;
import fiuba.algo3.AlgoChess.unidades.UnidadDeInfanteria;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {
    @Test
    public void seColocaUnaUnidadAliadaEnUnCasilleroDelSectorAliadoVacioConExito() {
        Tablero tablero = new Tablero("Aliado", "Enemigo");

        Unidad unidad = new UnidadDeInfanteria("Aliado");

        assertDoesNotThrow( ()->{
            tablero.posicionarUnidad(unidad,2,2);
        });
    }

    @Test
    public void seVerificaQueNoSePuedeColocarUnaUnidadAliadaEnUnCasilleroOcupadoEnElSectorAliado() {
        Tablero tablero = new Tablero("Aliado", "Enemigo");

        @SuppressWarnings("unused")
        Unidad unidad = new UnidadDeInfanteria("Aliado");
        tablero.posicionarUnidad(unidad, 5,5);
        Unidad unidad2 = new UnidadDeInfanteria("Aliado");


    }

    @Test
    public void seVerificaQueNoSePuedeColocarUnaPiezaAliadaEnUnCasilleroDelSectorEnemigo() {
        Tablero tablero = new Tablero("Aliado", "Enemigo");
        @SuppressWarnings("unused")
        Unidad unidad = new UnidadDeInfanteria("Aliado");
        tablero.posicionarUnidad(unidad, 5,5);
        Unidad unidad2 = new UnidadDeInfanteria("Enemigo");
        assertThrows(RuntimeException.class, ()->{

            tablero.posicionarUnidad(unidad2,5,6);
        });
    }
}
