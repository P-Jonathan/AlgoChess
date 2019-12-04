package fiuba.algo3.algochess.controlador.unidadcontroller;

import fiuba.algo3.algochess.modelo.unidades.*;
import fiuba.algo3.algochess.vista.TableroView;

import java.util.HashMap;
import java.util.Map;

public class UnidadControlFactory {
    @FunctionalInterface
    private interface UnidadControlSupplier {
        UnidadController getUnidadController(Unidad unidad, TableroView tableroView);
    }

    private static final Map<String, UnidadControlSupplier> map = new HashMap<>(Map.ofEntries(
            Map.entry(UnidadDeInfanteria.class.getName(), UnidadInfanteriaController::new),
            Map.entry(Curandero.class.getName(), UnidadInfanteriaController::new),
            Map.entry(Catapulta.class.getName(), UnidadInfanteriaController::new),
            Map.entry(Jinete.class.getName(), UnidadInfanteriaController::new)
    ));

    public static UnidadController getInstance(Unidad unidad, TableroView tablero) {
        UnidadController control = map.get(unidad.getClass().getName()).getUnidadController(unidad, tablero);
        System.out.println("Se instancio \"" + control.getClass().getName() + "\" para \"" + unidad.getClass().getName() + "\"");
        return control;
    }
}
