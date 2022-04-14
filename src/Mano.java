import utils.colecciones.Lista;
import utils.colecciones.Nodo;

/**
 * Clase que representa una mano de cartas.
 */
public class Mano {
    /**
     * ArrayList que contiene las cartas de la mano.
     */
    private Lista<Carta> cartas;
    private Carta triunfo;
    private Carta lider;

    /**
     * Constructor de la clase Mano.
     */
    public Mano(Lista<Carta> cartas) {
        this.cartas = cartas;
    }
    /**
     * Devuelve la lista de cartas de la mano.
     */
    public Lista<Carta> getCartas() {
        return cartas;
    }

    /**
     * establece las cartas.
     * @param cartas
     */
    public void setCartas(Lista<Carta> cartas) {
        this.cartas = cartas;
    }

    /**
     * Devuelve la carta de triunfo.
     * @return
     */
    public Carta getTriunfo() {
        return triunfo;
    }

    /**
     * establece el triunfo de la mano.
     * @param triunfo
     */
    public void setTriunfo(Carta triunfo) {
        this.triunfo = triunfo;
    }

    /**
     * devuelve la carta lider.
     * @return
     */

    public Carta getLider() {
        return lider;
    }

    /**
     * establece el lider de la mano.
     * @param lider
     */
    public void setLider(Carta lider) {
        this.lider = lider;
    }

    /**
     * agrega una carta a la mano.
     * @param carta
     */
    public void agregarCarta(Carta carta){
        cartas.agregaFinal(carta);
    }

    /**
     * elimina una carta de la mano.
     * @param carta
     */
    public void quitarCarta(Carta carta){
        cartas.delete(carta);
    }

    /**
     * muestra las cartas de la mano.
     */
    public void mostrarCartas(){
        Nodo<Carta> cartaActual = cartas.cabeza;
        Integer contador = 0;
        while (cartaActual != null){
            System.out.println("Carta " + contador + ": " +  cartaActual.elemento.toString());
            contador++;
            cartaActual = cartaActual.siguiente;
        }
    }

    /**
     * muestra las cartas validas de la mano.
     */
    public void mostrarValidas(){
        Integer contador = 0;
        Nodo<Carta> cartaActual = cartas.cabeza;
        while (cartaActual != null){
            if (cartaActual.elemento.getNumero() ==14){
                System.out.println("Carta " + contador + ": " +  cartaActual.elemento.toString());
            }
            if (cartaActual.elemento.getNumero() ==0){
                System.out.println("Carta " + contador + ": " +  cartaActual.elemento.toString());
            }
            if (cartaActual.elemento.getPalo().equals(lider.getPalo())){
                System.out.println("Carta " + contador + ": " +  cartaActual.elemento.toString());
            }
            cartaActual = cartaActual.siguiente;
            contador++;
        }
    }

    /**
     * elimina la carta de la mano por indice.
     * @param indice
     */
    public void eliminaCarta(Integer indice){
        cartas.delete(obtenerPorIndice(indice));
    }

    /**
     * devuelve la carta de la mano por indice.
     * @param indice
     * @return
     */
    public Carta obtenerPorIndice (Integer indice){
        Nodo<Carta> cartaActual = cartas.cabeza;
        Integer contador = 0;
        while (cartaActual != null){
            if (contador == indice){
                return cartaActual.elemento;
            }
            cartaActual = cartaActual.siguiente;
            contador++;

        }
        return null;
    }


}




