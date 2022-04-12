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

    public String toString(){
        return numero + " de " + palo;
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
