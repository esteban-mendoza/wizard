import static utils.constantes.Colores.BLANCO;
import static utils.constantes.Colores.NEUTRO;

/**
 * CLase que representa una carta de una baraja.
 */
public class Carta {
    /**
     * Atributos
     *
     */
    private int numero;
    private Palo palo;

    /**
     * Constructor público.
     * @param numero número de la carta.
     * @param palo palo de la carta.
     */
    public Carta(int numero, String palo){
        this.numero = numero;
        this.palo = new Palo(palo);
    }

    /**
     * Método que devuelve el número de la carta.
     * @return numero de la carta.
     */
    public int getNumero(){
        return numero;
    }
    /**
     * Método que devuelve el palo de la carta.
     * @return palo de la carta.
     */
    public Palo getPalo(){
        return palo;
    }

    /**
     * Devuelve una cadena con el color de la carta según el palo o el número.
     * - Si es humano, azul.
     * - Si es elfo, verde.
     * - Si es enano, rojo.
     * - Si es gigante, amarillo.
     * - Si son magos (Z, con valor 14) o bufones (N, con valor 0), blanco.
     *
     * @return Representación de la carta.
     */
    public String toString(){
        switch (numero) {
            case 0: return "[" + BLANCO + "N" + NEUTRO + "]";
            case 14: return "[" + BLANCO + "Z" + NEUTRO + "]";
        }

        return "[" + palo.getColor() + numero + NEUTRO + "]";
    }

}
