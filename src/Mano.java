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
     * Devuelve la carta en la posición dada por el usuario y la elimina de la mano.
     * @param posicion La posición de la carta en la mano.
     * @return La carta en la posición dada.
     */
    public Carta devolverCarta(int posicion) {
        return cartas.popIndex(posicion);
    }

    /**
     * Determina las cartas que el jugador puede jugar.
     * @param lider El palo del líder del truco.
     * @return Un arreglo con los índices de las cartas que el jugador puede jugar.
     */
    public Lista<Integer> obtenerValidas(Palo lider) {

        Lista<Integer> validas = new Lista<>();

        Iterator<Carta> it = cartas.iterador();
        int indice = 0;
        boolean existeCartaDelPaloLider = false;

        // Los wizards y jokers son válidos, además de las cartas del palo líder
        while (it.hasNext()) {
            Carta c = it.next();

            if (c.getPalo().equals(lider)) {
                validas.add(indice);
                existeCartaDelPaloLider = true;
                indice++;
                continue;
            }

            if (c.getNumero() == 0 || c.getNumero() == 14) {
                validas.add(indice);
                indice++;
            }
        }

        // Si no existe palo líder en el truco, o si la mano no tiene cartas del palo líder
        // todas las cartas son válidas
        if (lider == null || !existeCartaDelPaloLider) {

            validas = new Lista<>();

            for (int i = 0; i < cartas.size(); i++) {
                validas.add(i);
            }
        }

        return validas;
    }

    /**
     * Muestra las cartas de la mano.
     */
    public void mostrar() {
        System.out.println("Mano actual: " + this);
    }

    /**
     * Devuelve una cadena con las cartas de la mano.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Carta> it = cartas.iterador();

        while (it.hasNext()) {
            Carta c = it.next();
            sb.append(c);
            if (it.hasNext())
                sb.append(", ");
        }

        return sb.toString();
    }
}




