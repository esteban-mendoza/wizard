import utils.colecciones.IteradorLista;
import utils.colecciones.Lista;

public class Historial {

    private Lista<Ronda> historial;

    public Historial() {
        historial = new Lista<Ronda>();
    }

    /**
     * Agrega una ronda al historial
     * @param ronda Ronda a agregar
     */
    public void addRonda(Ronda ronda){
        historial.add(ronda);
    }

    /**
     * Muestra el historial de rondas
     */
    public void mostrarHistorial() {

        IteradorLista<Ronda> it = historial.iterador();
        while (it.hasNext()) {
            Ronda ronda = it.next();
            ronda.mostrarRonda();
        }
    }


}
