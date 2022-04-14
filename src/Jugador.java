/**
 * Clase que implementa las acciones de un jugador.
 */
public class Jugador {
    private String nombre;
    private Mano mano;
    private CLI cli;

    Jugador(){
        pedirNombre();
    }

    /**
     * Método que pide al usuario el nombre del jugador.
     */
    private void pedirNombre() {
        cli = CLI.getInstance();
        nombre = cli.pedirCadena("Introduce tu el nombre del jugador: ", null);
    }

    /**
     * Método que muestra las cartas válidas e inválidas para jugar,
     * pide al usuario que seleccione una carta y devuelve la carta seleccionada.
     * @param lider palo líder del truco.
     * @param triunfo palo del triunfo de la ronda.
     */
    public Carta elegirCarta(Palo lider, Palo triunfo) {

        mano.mostrarValidas(lider, triunfo);
        mano.mostrarInvalidas(lider, triunfo);

        cli = CLI.getInstance();
        int indice = cli.pedirEntero("Introduce la carta que quieres jugar: ",
                0, mano.getCartas().size()-1);

        return mano.getCartas().popIndex(indice);
    }

    /**
     * Método que devuelve el nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece la mano del jugador.
     * @param mano mano del jugador.
     */
    public void setMano(Mano mano) {
        this.mano = mano;
    }

    /**
     * Método que devuelve la mano del jugador.
     * @return mano del jugador.
     */
    public Mano getMano() {
        return mano;
    }
}
