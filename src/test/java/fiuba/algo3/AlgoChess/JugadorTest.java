package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.FinDelJuegoException;
import fiuba.algo3.AlgoChess.excepciones.PuntosInsuficientesException;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import fiuba.algo3.AlgoChess.unidades.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {
    @Test
    public void UnJugadorCompraUnaUnidadDeInfanteriaYBajaLaCantidadDePuntoQueTieneElJugadorEn1() {
        Jugador jugador = new Jugador("Test");
        Tablero tablero = new Tablero();

        UnidadDeInfanteria unidad = new UnidadDeInfanteria();

        int puntosPrevios = jugador.getPuntos();

        jugador.comprarUnidad(unidad);

        assertEquals(puntosPrevios - 1, jugador.getPuntos());
    }

    @Test
    public void UnJugadorCompraUnJineteYBajaLaCantidadDePuntoQueTieneElJugadorEn3() {
        Jugador jugador = new Jugador("Test");

        Jinete jinete = new Jinete();
        int puntosPrevios = jugador.getPuntos();
        jugador.comprarUnidad(jinete);

        assertEquals(puntosPrevios - 3, jugador.getPuntos());
    }

    @Test
    public void UnJugadorCompraUnCuranderoYBajaLaCantidadDePuntoQueTieneElJugadorEn2() {
        Jugador jugador = new Jugador("Test");

        Curandero curandero = new Curandero();

        int puntosPrevios = jugador.getPuntos();

        jugador.comprarUnidad(curandero);

        assertEquals(puntosPrevios - 2, jugador.getPuntos());
    }

    @Test
    public void UnJugadorCompraUnaCatapultaYBajaLaCantidadDePuntoQueTieneElJugadorEn5() {
        Jugador jugador = new Jugador("Test");

        Catapulta catapulta = new Catapulta();

        int puntosPrevios = jugador.getPuntos();

        jugador.comprarUnidad(catapulta);

        assertEquals(puntosPrevios - 5, jugador.getPuntos());
    }

    @Test
    public void unJugadorCompraUnidadesCon0PuntosYDeberiaLanzarUnaPuntosInsuficientesException() {
        Jugador jugador = new Jugador("Test"); // El jugador es creado con 20 puntos para comprar unidades

        ArrayList<Unidad> unidades = new ArrayList<Unidad>();
        Unidad ultimaUnidad = new UnidadDeInfanteria();

        for (int i = 0; i < 20; i++) {
            unidades.add(new UnidadDeInfanteria());
        }

        for (Unidad unidad : unidades) {
            jugador.comprarUnidad(unidad); // Cada unidad de infanteria cuesta 1 punto
        }

        assertEquals(jugador.getPuntos(), 0);

        assertThrows(PuntosInsuficientesException.class, () -> {
            jugador.comprarUnidad(ultimaUnidad);
        });
    }

    @Test
    public void unJugadorCompraUnaUnidadConPuntosInsuficientesYDeberiaTirarPuntosInsuficientesException() {
        Jugador jugador = new Jugador("Test"); // El jugador es creado con 20 puntos para comprar unidades


        UnidadDeInfanteria soldado = new UnidadDeInfanteria();
        Catapulta catapulta1 = new Catapulta();
        Catapulta catapulta2 = new Catapulta();
        Catapulta catapulta3 = new Catapulta();
        Catapulta catapulta4 = new Catapulta();

        jugador.comprarUnidad(catapulta1); // Cada catapulta cuesta 5 puntos
        jugador.comprarUnidad(catapulta2);
        jugador.comprarUnidad(catapulta3);
        jugador.comprarUnidad(soldado); // Cada unidad de infanteria cuesta 1 punto

        assertEquals(jugador.getPuntos(), 4);

        assertThrows(PuntosInsuficientesException.class, () -> {
            jugador.comprarUnidad(catapulta4);
        });
    }

    @Test
    public void jugadorManuPierdeCuandoSeQuedaSinUnidades() {
        Jugador manu = new Jugador("Manu");
        Jugador pepe = new Jugador("Pepe");


        UnidadDeInfanteria unidadManu = new UnidadDeInfanteria("Manu");
        UnidadDeInfanteria unidadPepe = new UnidadDeInfanteria("Pepe");

        manu.comprarUnidad(unidadManu);
        pepe.comprarUnidad(unidadPepe);

        for (int i = 0; i < 9; i++) {
            unidadPepe.atacar(unidadManu);
        }

        assertThrows(FinDelJuegoException.class, () -> {
            unidadPepe.atacar(unidadManu);
        });
    }
}