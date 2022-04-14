import utils.colecciones.ListaCircular;

public class Partida {

    private int numeroJugadores;
    private int numeroRondas;
    private ListaCircular<Jugador> jugadores;
    private Historial historial;
    private CLI cli;

    /**
     * Constructor de la clase Partida
     */
    public Partida() {
        pedirNumeroJugadores();
        determinarNumeroRondas();
        instanciarJugadores();
        historial = new Historial();
    }

    /**
     * Pedir número de jugadores
     */
    private void pedirNumeroJugadores() {
        cli = CLI.getInstance();
        numeroJugadores = cli.pedirEntero("Ingrese el numero de jugadores: ", 3, 6);
    }

    /**
     * Determinar número de rondas usando el número de jugadores
     */
    private void determinarNumeroRondas() {
        switch (numeroJugadores) {
            case 3:
                numeroRondas = 20;
                break;
            case 4:
                numeroRondas = 15;
                break;
            case 5:
                numeroRondas = 12;
                break;
            case 6:
                numeroRondas = 10;
                break;
        }
    }

    /**
     * Método que instancia los jugadores
     */
    private void instanciarJugadores() {
        jugadores = new ListaCircular<>();
        for (int i = 0; i < numeroJugadores; i++) {
            jugadores.add(new Jugador());
        }
    }


}
