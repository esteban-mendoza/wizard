public class Jugada {
    private Carta carta;
    private Jugador jugador;

    public Jugada(Carta carta, Jugador jugador){
        this.carta = carta;
        this.jugador = jugador;
    }

    /**
     * Método que devuelve la carta de la jugada.
     * @return Carta de la jugada.
     */
    public Carta getCarta(){
        return carta;
    }

    /**
     * Método que devuelve el jugador de la jugada.
     * @return Jugador de la jugada.
     */
    public Jugador getJugador(){
        return jugador;
    }

    /**
     * Método que imprime la jugada.
     */
    public void mostrarJugada() {
        System.out.println(jugador.getNombre() + " jugó " + carta + ".");
    }
}
