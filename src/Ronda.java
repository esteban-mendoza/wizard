import utils.colecciones.IteradorLista;
import utils.colecciones.Lista;
import utils.colecciones.ListaCircular;

public class Ronda {
    private int nTrucos;
    private ListaCircular<Jugador> jugadores;
    private Lista<Truco> trucos;
    private Baraja baraja;
    private Palo triunfo;
    private int semilla;
    private Jugador ganador;

    public Ronda(int nTrucos, ListaCircular<Jugador> jugadores, int semilla) {
        this.nTrucos = nTrucos;
        this.jugadores = jugadores;
        this.trucos = new Lista<>();
        this.baraja = new Baraja();
        this.semilla = semilla;
    }

    /**
     * Devuelve el ganador del último truco de la ronda.
     * @return Ganador del último truco de la ronda.
     */
    public Jugador getGanador() {
        return ganador;
    }

    /**
     * Establece el ganador del último truco de la ronda.
     * @param ganador Ganador del último truco de la ronda.
     */
    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    /**
     * Reparte las cartas a los jugadores.
     */
    public void repartirCartas(){
        ListaCircular.Iterador<Jugador> it = jugadores.iterador();

        for (int i = 0; i < nTrucos; i++) {
            for (int j = 0; j < jugadores.longitud; j++) {
                Jugador jugador = it.next();

                Carta carta = baraja.sacarCarta();
                jugador.recibirCarta(carta);
            }
        }
    }

    /**
     * Determina el palo del triunfo al inicio de la ronda.
     * @param ganador ganador del anterior truco o null si no hay truco anterior.
     * @return Palo del triunfo.
     */
    private Palo determinarPaloDelTriunfo(Jugador ganador) {

        if (baraja.estaVacia()) {
            System.out.println("No hay cartas en la baraja. Durante esta ronda no hay palo del triunfo.");
            return null;
        }


        Carta carta = baraja.sacarCarta();
        if (carta.getNumero() == 0) {
            System.out.println("La carta obtenida es " + carta + ". Durante esta ronda no hay palo del triunfo.");
            return null;
        }


        if (carta.getNumero() == 14) {
            ListaCircular.Iterador<Jugador> it = jugadores.iterador();
            it.moveBefore(ganador);
            Jugador jugador = it.next();
            Palo palo = ganador.elegirPalo();
            System.out.println("El jugador " + jugador.getNombre() + " eligió el palo " + palo + " como palo del triunfo.");
            it.moveBefore(ganador);
            return palo;
        }

        Palo palo = carta.getPalo();
        System.out.println("La carta obtenida es " + carta + ". El palo del triunfo es " + palo + ".");
        return palo;
    }

    /**
     * Jugar una ronda.
     */
    public void jugarRonda() {

        System.out.println("==========================");
        System.out.println("Comienza la ronda " + nTrucos + ".");

        baraja.revolver(semilla);
        repartirCartas();

        triunfo = determinarPaloDelTriunfo(ganador);
        pedirApuestas();

        for (int i = 0; i < nTrucos; i++) {

            Truco truco = new Truco(triunfo, jugadores);
            truco.jugarTruco(ganador);
            trucos.add(truco);

            ganador = truco.getGanador();
            ganador.ganarTruco();
        }

        finalizarRonda();

        // Actualizamos la semilla para que al revolver durante
        // la siguiente ronda no tengamos las cartas en el mismo orden
        semilla += 100;
    }

    /**
     * Método que calcula el resultado de la ronda para cada jugador.
     */
    private void finalizarRonda() {
        ListaCircular.Iterador<Jugador> it = jugadores.iterador();
        it.start();
        for (int i = 0; i < jugadores.longitud; i++) {
            Jugador jugador = it.next();
            jugador.finalizarRonda();
        }
        mostrarResultados();
    }

    /**
     * Muestra los resultados de la ronda.
     */
    private void mostrarResultados() {
        ListaCircular.Iterador<Jugador> it = jugadores.iterador();
        it.start();
        for (int i = 0; i < jugadores.longitud; i++) {
            Jugador jugador = it.next();
            jugador.mostrarResultado();
        }
    }

    /**
     * Pide las apuestas a los jugadores.
     */
    private void pedirApuestas() {
        ListaCircular.Iterador<Jugador> it = jugadores.iterador();
        it.moveBefore(ganador);

        for (int i = 0; i < jugadores.longitud; i++) {
            Jugador jugador = it.next();

            int apuesta = jugador.elegirApuesta(nTrucos);

            if (nTrucos == 1) {
                jugador.nuevoResultado(0, apuesta);
            } else {
                int puntuacion = jugador.getPuntos();
                jugador.nuevoResultado(puntuacion, apuesta);
            }
        }
    }

    /**
     * Muestra la historia de la ronda.
     */
    public void mostrarRonda() {

        ListaCircular.Iterador<Jugador> it = jugadores.iterador();
        Jugador siguiente = it.next();
        it.start();

        System.out.println("==========================");
        System.out.println("Ronda " + nTrucos + ".");

        if (triunfo != null) {
            System.out.println("El palo del triunfo fue " + triunfo + ".");
        } else {
            System.out.println("Esta ronda no tuvo palo del triunfo.");
        }

        System.out.println("Los jugadores apostaron: ");
        for (int i = 0; i < jugadores.longitud; i++) {
            Jugador jugador = it.next();
            jugador.mostrarApuesta(nTrucos);
        }

        IteradorLista<Truco> itTrucos = trucos.iterador();
        itTrucos.start();

        for (int i = 0; i < trucos.longitud; i++) {
            System.out.println("==== Truco " + (i + 1) + " ====");
            Truco truco = itTrucos.next();
            truco.mostrarTruco();
        }

        System.out.println("Las puntuaciones al final de la ronda son: ");
        for (int i = 0; i < jugadores.longitud; i++) {
            Jugador jugador = it.next();
            jugador.mostrarResultado(nTrucos);
        }

        it.moveBefore(siguiente);
    }
}
