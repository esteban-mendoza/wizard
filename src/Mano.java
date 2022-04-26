import utils.colecciones.Lista;

import java.util.Iterator;

public class Mano {

    private Lista<Carta> cartas;

    public Mano() {
        cartas = new Lista<>();
    }

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
     * Recibe una carta y la agrega a la mano.
     * @param carta La carta a agregar.
     */
    public void recibirCarta(Carta carta) {
        cartas.add(carta);
    }

    /**
     * Determina las cartas que el jugador puede jugar.
     * @param lider El palo del líder del truco.
     * @return Un arreglo con los índices de las cartas que el jugador puede jugar.
     */
    public Lista<Integer> obtenerValidas(Palo lider) {

        Lista<Integer> validas = new Lista<>();

        // Si el palo del líder es nulo, se puede jugar cualquier carta.
        if (lider == null) {
            for (int i = 0; i < cartas.size(); i++) {
                validas.add(i);
            }
            return validas;
        }

        Iterator<Carta> it = cartas.iterador();
        int indice = 0;
        boolean existeCartaDelPaloLider = false;

        // Las cartas distintas de wizard y joker que sean del palo líder son válidas.
        // También los wizard y joker de cualquier palo.
        while (it.hasNext()) {
            Carta c = it.next();

            if (c.getPalo().equals(lider) && (c.getNumero() != 0 && c.getNumero() != 14)) {
                validas.add(indice);
                existeCartaDelPaloLider = true;
                indice++;
                continue;
            }

            if (c.getNumero() == 0 || c.getNumero() == 14) {
                validas.add(indice);
                indice++;
                continue;
            }

            indice++;
        }

        // Si la mano no tiene cartas del palo líder todas las cartas son válidas
        if (!existeCartaDelPaloLider) {
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




