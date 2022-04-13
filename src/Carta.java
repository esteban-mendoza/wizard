/**
 * CLase que representa una carta de una baraja.
 */
public class Carta {
    /**
     * Atributos
     *
     */
    private int numero;
    private String palo;

    /**
     * Constructor publico.
     * @param numero
     * @param palo
     */
    public Carta(int numero, String palo){
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
    public String getPalo(){
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
     * Compara si dos cartas son iguales.
     * @param carta
     * @return
     */
    public boolean equals(Carta carta){
        return numero == carta.numero && palo.equals(carta.palo);
    }
    /**
     * Compara si una carta es menor que otra.
     * @param carta
     * @return
     */
    public boolean menorQue(Carta carta){
        return numero < carta.numero;
    }
    /**
     * Compara si una carta es mayor que otra.
     * @param carta
     * @return
     */
    public boolean mayorQue(Carta carta){
        return numero > carta.numero;
    }
    /**
     * Compara si una carta es menor o igual que otra.
     * @param carta
     * @return
     */
    public boolean menorOIgualQue(Carta carta){
        return numero <= carta.numero;
    }
    /**
     * Compara si una carta es mayor o igual que otra.
     * @param carta
     * @return
     */
    public boolean mayorOIgualQue(Carta carta){
        return numero >= carta.numero;
    }
    /**
     * Compara si una carta es igual a otra.
     * @param carta
     * @return
     */
    public boolean esIgual(Carta carta){
        return numero == carta.numero;
    }

    /**
     * Compara si una carta es distinta a otra.
     * @param carta
     * @return
     */
    public boolean esDistinto(Carta carta){
        return numero != carta.numero;
    }
}
