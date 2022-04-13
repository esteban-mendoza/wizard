import utils.colecciones.Lista;

/**
 * Pila de cartas.
 */
public class Baraja extends Lista<Carta> {


    /**
     * Constructor que crea una baraja de 60 cartas.
     */
    public Baraja() {
        String[] palos = {"humanos", "elfos", "enanos", "gigantes"};
        int[] numeros = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    }
}
