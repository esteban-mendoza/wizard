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
     * Constructor publico.
     * @param numero
     * @param palo
     */
    public Carta(int numero, Palo palo){
        this.numero = numero;
        this.palo = palo;
    }
    /**
     * Metodo que devuelve el numero de la carta.
     * @return numero
     */
    public int getNumero(){
        return numero;
    }
    /**
     * Metodo que devuelve el palo de la carta.
     * @return palo
     */
    public Palo getPalo(){
        return palo;
    }

    /**
     * Devuelve una cadena con el color de la carta según el palo:
     * - Si es humano, azul.
     * - Si es elfo, verde.
     * - Si es enano, rojo.
     * - Si es gigante, amarillo.
     * - Si son magos (Z, con valor 14) o bufones (N, con valor 0), blanco.
     *
     * @return Representación de la carta.
     */
    public String toString(){
        String color = "";
        switch(palo){
            case "Humano":
                color = "\u001B[34mazul";
                break;
            case "Elfo":
                color = "\u001B[32mverde";
                break;
            case "Enano":
                color = "\u001B[31rojo";
                break;
            case "Gigante":
                color = "\u001B[33mamarillo";
                break;
            case "Mago":
            case "Bufon":
                color = "\u001B[0mblanco";
                break;
        }
        return numero + " de " + color;
    }

    /**
     * Determina si la carta es válida para una jugada.
     */
    public boolean esValida(Palo lider, Palo triunfo){
        //TODO: Implementar
        return true;
    }
}
