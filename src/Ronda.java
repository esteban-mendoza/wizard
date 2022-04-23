import utils.colecciones.IteradorLista;
import utils.colecciones.Lista;
import utils.colecciones.ListaCircular;

public class Ronda {
    private int nTrucos;
    private ListaCircular<Jugador> jugadores;
    private Lista<Truco> trucos;
    private Baraja baraja;
    private Palo triunfo;

    public Ronda(int nTrucos, ListaCircular<Jugador> jugadores) {
        this.nTrucos = nTrucos;
        this.jugadores = jugadores;
        this.trucos = new Lista<>();
        this.baraja = new Baraja();
    }

    /**
     * Reparte las cartas a los jugadores.
     */
    public void repartirCartas(){
        IteradorLista<Jugador> it = jugadores.iterador();

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
     * @return Palo del triunfo.
     */
    private Palo determinarPaloDelTriunfo() {

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
            IteradorLista<Jugador> it = jugadores.iterador();
            Jugador jugador = it.next();
            Palo palo = jugador.elegirPalo();
            System.out.println("El jugador " + jugador.getNombre() + " eligió el palo " + palo + " como palo del triunfo.");
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

        baraja.revolver();

        repartirCartas();

        triunfo = determinarPaloDelTriunfo();

        for (int i = 0; i < nTrucos; i++) {
            Truco truco = new Truco(triunfo, jugadores);
            truco.jugarTruco();
            trucos.add(truco);
        }
    }



}
