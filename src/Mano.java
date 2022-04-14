import utils.colecciones.Lista;

import java.util.Iterator;

public class Mano {

    private Lista<Carta> cartas;

    public Mano(Carta[] cartas) {
        this.cartas = new Lista<>(cartas);
    }

    /**
     * Devuelve las cartas de la mano.
     * @return Las cartas de la mano.
     */
    public Lista<Carta> getCartas() {
        return cartas;
    }

    /**
     * Muestra las cartas que el jugador puede jugar.
     * @param lider El palo del lider del truco.
     * @param triunfo El palo del triunfo de la ronda.
     */
    public void mostrarValidas(Palo lider, Palo triunfo) {
        System.out.print("Cartas validas: ");

        Iterator<Carta> it = cartas.iterador();
        while (it.hasNext()) {
            Carta c = it.next();
            if (c.esValida(lider, triunfo)) {
                System.out.print(c);

                if (it.hasNext()) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }

    /**
     * Muestra las cartas que el jugador no puede jugar.
     * @param lider El palo del lider del truco.
     * @param triunfo El palo del triunfo de la ronda.
     */
    public void mostrarInvalidas(Palo lider, Palo triunfo) {
        System.out.print("Cartas inválidas: ");

        Iterator<Carta> it = cartas.iterador();
        while (it.hasNext()) {
            Carta c = it.next();
            if (!c.esValida(lider, triunfo)) {
                System.out.print(c);

                if (it.hasNext())
                    System.out.print(", ");
            }
        }
        System.out.println();
    }

}




