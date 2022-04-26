import utils.colecciones.Lista;

/**
 * Pila de cartas.
 */
public class Baraja {

    private Lista<Carta> baraja;

    /**
     * Constructor que crea una baraja de 60 cartas.
     */
    public Baraja() {
        baraja = new Lista<>();

        String[] palos = {"humanos", "elfos", "enanos", "gigantes"};
        int[] numeros = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        for (String palo: palos) {
            for (int numero: numeros) {
                baraja.add(new Carta(numero, palo));
            }
        }
    }

    /**
     * Devuelve la carta en la cima de la baraja.
     * @return La carta de la cima de la baraja.
     */
    public Carta sacarCarta() {
        return baraja.popFirst();
    }

    /**
     * Revuelve la baraja.
     */
    public void revolver(int semilla) {
        baraja.shuffle(semilla);
    }

    /**
     * Determine si la baraja está vacía.
     * @return <code>true</code> si la baraja está vacía, <code>false</code> en caso contrario.
     */
    public boolean estaVacia() {
        return baraja.isEmpty();
    }

}
