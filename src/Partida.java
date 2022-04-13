public class Partida {

    private int numeroJugadores;
    private int numeroRondas;
    private Baraja baraja;
    private Jugador[] jugadores;
    private Historial historial;
    private CLI cli;

    public Partida() {

        cli = CLI.getInstance();

    }

    public void inicializarJugadores() {
        return;
    }

    public void iniciarPartida() {
        return;
    }
    public void mostrarPuntajes() {
        return;
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    public int getNumeroRondas() {
        return numeroRondas;
    }

    public void setNumeroRondas(int numeroRondas) {
        this.numeroRondas = numeroRondas;
    }

    public Baraja getBaraja() {
        return baraja;
    }

    public void setBaraja(Baraja baraja) {
        this.baraja = baraja;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }
}
