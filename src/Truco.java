import utils.colecciones.IteradorLista;
import utils.colecciones.Lista;
import utils.colecciones.ListaCircular;

public class Truco {
    private Palo triunfo;
    private Palo lider;
    private Lista<Jugada> jugadas;
    private ListaCircular<Jugador> jugadores;
    private Jugada ganadora;

   public Truco(Palo triunfo, ListaCircular<Jugador> jugadores){
       this.triunfo = triunfo;
       this.jugadores = jugadores;
       this.jugadas = new Lista<>();
       this.lider = null;
   }

    /**
     * Pide cartas a todos los jugadores y devuelve al jugador que ganó el truco.
     * @param ganador el jugador que ganó el truco anterior o null si no hay uno.
     */
    public void jugarTruco(Jugador ganador) {
        Carta carta;
        Jugador jugador;

        ListaCircular.Iterador<Jugador> iterador = jugadores.iterador();
        iterador.moveBefore(ganador);

        for (int i = 0; i < jugadores.longitud; i++) {
            jugador = iterador.next();

            System.out.println("==========================");
            System.out.println("Comienza el turno del jugador " + jugador.getNombre() + ".");
            mostrarTriunfoYLider();
            mostrarCartasJugadas();
            carta = jugador.elegirCarta(lider);
            jugarCarta(carta, jugador);
        }

        ganadora = determinarJugadaGanadora();
        mostrarGanador();
    }

    /**
     * Muestra al jugador que ganó el truco.
     */
    private void mostrarGanador() {
        System.out.println("==========================");
        System.out.println("El jugador " + ganadora.getJugador().getNombre() + " ganó el truco.");
    }

    /**
     * Muestra las cartas jugadas.
     */
    private void mostrarCartasJugadas() {

        if (jugadas.isEmpty())
            System.out.println("No hay cartas jugadas.");

        IteradorLista<Jugada> iterador = jugadas.iterador();

        while (iterador.hasNext()) {
            Jugada jugada = iterador.next();
            System.out.println("El jugador " +  jugada.getJugador().getNombre() + " jugó " + jugada.getCarta() + ".");
        }
    }

    /**
     * Muestra el palo del triunfo y el palo líder.
     */
    private void mostrarTriunfoYLider() {
        if (triunfo == null)
            System.out.println("No hay palo del triunfo en esta ronda.");
        else
            System.out.println("El palo del triunfo es: " + triunfo + ".");

        if (lider == null)
            System.out.println("El palo líder no ha sido definido.");
        else
            System.out.println("El palo líder es: " + lider + ".");
    }

    /**
     * Devuelve el jugador que ganó el truco.
     * @return el jugador que ganó el truco.
     */
    public Jugador getGanador() {
        return ganadora.getJugador();
    }

    /**
     * Determina la jugada ganadora del truco. Esta se determina usando las siguientes reglas:
     *
     * <lo>
     *     <li>La primera jugada con un Mago.</li>
     *     <li>La mayor carta con el palo del triunfo.</li>
     *     <li>La mayor carta con el palo líder.</li>
     *     <li>El primer bufón.</li>
     * </lo>
     *
     * @return la jugada ganadora.
     */
    private Jugada determinarJugadaGanadora() {

        IteradorLista<Jugada> iterador = jugadas.iterador();
        iterador.start();

        Jugada jugadaConMayorPaloDelTriunfo = null;
        Jugada jugadaConMayorPaloLider = null;
        Jugada jugadaConPrimerBufon = null;

        while (iterador.hasNext()){
            Jugada jugadaActual = iterador.next();

            int numero = jugadaActual.getCarta().getNumero();
            Palo palo = jugadaActual.getCarta().getPalo();

            if (numero == 14)
                return jugadaActual;

            if (triunfo != null) {
                if (palo.equals(triunfo) && numero != 0) {
                    if (jugadaConMayorPaloDelTriunfo == null)
                        jugadaConMayorPaloDelTriunfo = jugadaActual;
                    else if (numero > jugadaConMayorPaloDelTriunfo.getCarta().getNumero())
                        jugadaConMayorPaloDelTriunfo = jugadaActual;
                }
            }


            if (palo.equals(lider)) {
                if (jugadaConMayorPaloLider == null)
                    jugadaConMayorPaloLider = jugadaActual;
                else if (numero > jugadaConMayorPaloLider.getCarta().getNumero())
                    jugadaConMayorPaloLider = jugadaActual;
            }

            if (numero == 0) {
                if (jugadaConPrimerBufon == null)
                    jugadaConPrimerBufon = jugadaActual;
            }
        }

        if (jugadaConMayorPaloDelTriunfo != null)
            return jugadaConMayorPaloDelTriunfo;
        else if (jugadaConMayorPaloLider != null)
            return jugadaConMayorPaloLider;

        return jugadaConPrimerBufon;
    }

    /**
     * Juega una carta y agrega la jugada a la lista de jugadas.
     * @param carta la carta a jugar.
     * @param jugador el jugador que juega la carta.
     */
    private void jugarCarta(Carta carta, Jugador jugador){

        if (lider == null && (carta.getNumero() == 0 || carta.getNumero() == 14))
            lider = null;
        else if (lider == null)
            lider = carta.getPalo();

        jugadas.add(new Jugada(carta, jugador));
    }


    /**
     * Método que muestra el historial del truco.
     */
    public void mostrarTruco() {

        System.out.println("Se jugaron las siguientes cartas:");

        IteradorLista<Jugada> iterador = jugadas.iterador();
        iterador.start();

        while (iterador.hasNext()) {
            Jugada jugadaActual = iterador.next();
            jugadaActual.mostrarJugada();
        }

        System.out.println("Ganó el jugador: " + ganadora.getJugador().getNombre());
    }
}




