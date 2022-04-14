import utils.colecciones.Lista;
import utils.colecciones.Nodo;

public class Truco {
    private Palo paloTriunfo;
    private Palo paloLider;
    private Lista<Carta> cartas;
    private Carta valiosa;

   public Truco(Palo paloTriunfo, Palo paloLider, Lista<Carta> cartas, Carta valiosa) {
       this.paloTriunfo = paloTriunfo;
       this.paloLider = paloLider;
       this.cartas = cartas;
       this.valiosa = valiosa;
   }

    /**
     * regresa el palo del triunfo.
     * @return
     */
   public Palo getPaloTriunfo() {
       return paloTriunfo;
   }
   /**
    * regresa el palo del lider.
    * @return
    */
   public Palo getPalolider() {
       return paloLider;
   }

    /**
     * regresa la lista de cartas.
     * @return
     */
   public Lista<Carta> getCartas() {
       return cartas;
   }

    /**
     * regresa la carta mas valiosa.
     * @return
     */
   public Carta getValiosa() {
       return valiosa;
   }

    /**
     * establece el palo del triunfo.
     * @param paloTriunfo
     */
    public void setPaloTriunfo(Palo paloTriunfo) {
        this.paloTriunfo = paloTriunfo;
    }

    /**
     * establece el palo del lider.
     * @param paloLider
     */
    public void setPaloLider(Palo paloLider) {
        this.paloLider = paloLider;
    }

    /**
     * establece la lista de cartas.
     * @param cartas
     */
    public void setCartas(Lista<Carta> cartas) {
        this.cartas = cartas;
    }

    /**
     * establece la carta mas valiosa.
     * @param valiosa
     */
    public void setValiosa(Carta valiosa) {
        this.valiosa = valiosa;
    }

    /**
     * establece una carta como el palo de triunfo.
     * @param carta
     */
    public void establecerPaloTriunfo(Carta carta){
        this.paloTriunfo = carta.getPalo();
    }

    /**
     * determina la mejor carta.
     * @return
     */
    public Carta determinarMejorCarta(){
        Nodo<Carta> cartaActual = cartas.cabeza;

        while (cartaActual != null){
            if ((cartaActual.elemento.getNumero() == 14) || (cartaActual.elemento.getNumero() == 0) || (cartaActual.elemento.getPalo().equals(paloTriunfo) && cartaActual.elemento.getNumero() == 13)
            || (cartaActual.elemento.getPalo().equals(paloTriunfo) && cartaActual.elemento.getNumero() == 13)) {
                valiosa = cartaActual.elemento;

                return valiosa;
            }
            cartaActual = cartaActual.siguiente;
        }
        return null;
    }
    /**
     * agrega una carta a la mano.
     * @param carta
     */
    public void agregarCarta(Carta carta){
        cartas.agregaFinal(carta);
    }
}




