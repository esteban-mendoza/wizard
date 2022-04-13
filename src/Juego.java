/**
 * Clase principal con la lógica del juego.
 *
 * Instancia una nueva partida y llama a sus métodos.
 */
public class Juego {

    private CLI cli;
    private Partida partida;

    public Juego() {
        cli = CLI.getInstance();
    }

    /**
     * Crea una nueva partida.
     */
    public void inicializarPartida() {
        partida = new Partida();
    }

    /**
     * Jugar la partida.
     */
    public void jugar() {
    }

    /**
     * Muestra el historial de la partida.
     */
    public void mostrarHistorial() {

       // Debe iterar por las rondas, e imprimir cada truco.
        return;
    }

    /**
     * Muestra resumen de la partida.
     */
    public void mostrarResumen() {
        return;
    }

    /**
     * Terminar juego.
     */
    public void terminar() {
        mostrarResumen();
        return;
    }

}
