package fiuba.algo3.AlgoChess.modelo.habilidades;

import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.AlgoChess.modelo.unidades.Unidad;

public class AtaqueEncadenadoADistancia extends Habilidad {
    private final static int DANIO = 20;

    public AtaqueEncadenadoADistancia(Unidad portador) {
        super(portador);
    }

    private List<Unidad> getUnidadesAAtacar(Unidad priverObjetivo) {
        List<Unidad> unidadesVisitadas = new LinkedList<>();
        List<Unidad> unidadesPorVisitar = new LinkedList<>();

        unidadesPorVisitar.add(priverObjetivo);

        while (unidadesPorVisitar.size() > 0) {
            Unidad unidad = unidadesPorVisitar.remove(0);
            List<Unidad> unidadesCercanas = unidad.unidadesCerca();

            if (!unidadesVisitadas.contains(unidad))
                unidadesVisitadas.add(unidad);

            for (Unidad unidadCercana : unidadesCercanas) {
                if (!unidadesPorVisitar.contains(unidadCercana)) {
                    unidadesPorVisitar.add(unidadCercana);
                }
            }
        }

        return unidadesVisitadas;
    }

    @Override
    public void usarHabilidad(Unidad objetivo) {
        List<Unidad> unidades = getUnidadesAAtacar(objetivo);

        unidades.forEach(unidad -> unidad.disminuirVida(DANIO));
    }
}
