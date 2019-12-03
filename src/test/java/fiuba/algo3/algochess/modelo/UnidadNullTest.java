package fiuba.algo3.algochess.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fiuba.algo3.algochess.modelo.unidades.Unidad;
import fiuba.algo3.algochess.modelo.unidades.UnidadDeInfanteria;
import fiuba.algo3.algochess.modelo.unidades.UnidadNull;

public class UnidadNullTest {
    @Test
    void creoUnidadNullYNoPuedoBajarleNiSubirleLaVida() {
    	Unidad unidad = new UnidadNull();
    	double vidaActual = unidad.getVida();
    	unidad.disminuirVida(20);    	
    	assertEquals(unidad.getVida(), vidaActual);
    	unidad.aumentarVida(20);
    	assertEquals(unidad.getVida(), vidaActual);
    }
    @Test
    void creoUnidadNullYNoEsAliadoNiEnemigoDeOtraUnidad() {
    	Unidad unidad = new UnidadNull();
    	Unidad unidad2 = new UnidadDeInfanteria();
    	
    	assertTrue(!(unidad.soyAliadoDe(unidad2)));
    	assertTrue(!(unidad.soyEnemigoDe(unidad2)));

    }

}
