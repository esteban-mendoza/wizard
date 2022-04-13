public class Carta {

    private int numero;
    private String palo;

    public Carta(int numero, String palo){
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero(){
        return numero;
    }

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
                color = "azul";
                break;
            case "Elfo":
                color = "verde";
                break;
            case "Enano":
                color = "rojo";
                break;
            case "Gigante":
                color = "amarillo";
                break;
            case "Magos":
            case "Bufones":
                color = "blanco";
                break;
        }
        return numero + " de " + color;
    }

    public boolean equals(Carta carta){
        return numero == carta.numero && palo.equals(carta.palo);
    }

    public boolean menorQue(Carta carta){
        return numero < carta.numero;
    }

    public boolean mayorQue(Carta carta){
        return numero > carta.numero;
    }

    public boolean menorOIgualQue(Carta carta){
        return numero <= carta.numero;
    }

    public boolean mayorOIgualQue(Carta carta){
        return numero >= carta.numero;
    }

    public boolean esIgual(Carta carta){
        return numero == carta.numero;
    }


}
