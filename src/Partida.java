import utils.colecciones.ListaCircular;

public class Partida {

    private int numeroJugadores;
    private int numeroRondas;
    private int semilla;
    private ListaCircular<Jugador> jugadores;
    private Historial historial;
    private CLI cli;

    /**
     * Constructor de la clase Partida
     */
    public Partida() {
        numeroJugadores = 0;
        numeroRondas = 0;
        jugadores = new ListaCircular<>();
        historial = new Historial();
        semilla = 0;
    }

    /**
     * Método que inicializa los valores necesarios para la partida.
     */
    public void inicializarPartida() {
        numeroJugadores = pedirNumeroJugadores();
        numeroRondas = determinarNumeroRondas();
        jugadores = instanciarJugadores();
        historial = new Historial();
        semilla = pedirSemilla();
    }

    /**
     * Pedir número de jugadores
     * @return número de jugadores
     */
    private int pedirNumeroJugadores() {
        cli = CLI.getInstance();
        return cli.pedirEntero("Ingrese el numero de jugadores (entre 3 y 6): ", 3, 6, false);
    }

    /**
     * Método que devuelve la lista circular de jugadores
     * @return la lista circular de jugadores
     */
    public ListaCircular<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * Determinar número de rondas usando el número de jugadores
     * @return número de rondas
     */
    private int determinarNumeroRondas() {
        switch (this.numeroJugadores) {
            case 3:
                return 20;
            case 4:
                return 15;
            case 5:
                return 12;
            case 6:
                return 10;
        }
        return 0;
    }

    /**
     * Método que instancia los jugadores
     * @return ListaCircular con los jugadores
     */
    private ListaCircular<Jugador> instanciarJugadores() {
        jugadores = new ListaCircular<>();
        for (int i = 0; i < numeroJugadores; i++) {
            Jugador jugador = new Jugador();
            jugador.setNombre(jugadores);
            jugadores.add(jugador);
        }

        return jugadores;
    }

    /**
     * Pedir semilla
     * @return semilla ingresada por el usuario
     */
    private int pedirSemilla() {
        cli = CLI.getInstance();
        return cli.pedirEntero("Ingrese la semilla del juego: ", Integer.MIN_VALUE, Integer.MAX_VALUE, false);
    }

    /**
     * Método que inicia la partida
     */
    public void iniciarPartida() {

        Jugador ultimoGanador = null;

        for (int i = 0; i < numeroRondas; i++) {
            Ronda ronda = new Ronda(i + 1, jugadores, semilla);

            ronda.setGanador(ultimoGanador);

            historial.addRonda(ronda);

            ronda.jugarRonda(semilla);
            ultimoGanador = ronda.getGanador();
            // Actualizamos la semilla para que al revolver durante
            // la siguiente ronda no tengamos las cartas en el mismo orden
            semilla += 100;
        }
    }

    /**
     * Método que muestra el historial de la partida
     */
    public void mostrarHistorial() {
        historial.mostrarHistorial();
    }

    /**
     * Método que muestra el resumen de la partida
     */
    public void mostrarResumen() {
        System.out.println("===============================");
        System.out.println("Resumen de la partida: ");
        ListaCircular.Iterador<Jugador> iterador = jugadores.iterador();
        Jugador siguiente = iterador.next();
        iterador.start();

        for (int i = 0; i < numeroRondas; i++) {
            System.out.println("Resumen de la ronda " + (i+1) + ": ");
            for (int j = 0; j < jugadores.longitud; j++) {
                Jugador jugador = iterador.next();
                jugador.mostrarResultado(i+1);
            }
        }

        iterador.moveBefore(siguiente);
    }
}
