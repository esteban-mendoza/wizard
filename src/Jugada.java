public class Jugada {
    private Carta carta;
    private Jugador jugador;

    public Jugada(Carta carta, Jugador jugador){
        this.carta = carta;
        this.jugador = jugador;
    }

    public Carta getCarta(){
        return carta;
    }

    public Jugador getJugador(){
        return jugador;
    }
}
