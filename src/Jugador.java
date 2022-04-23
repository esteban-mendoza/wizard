import utils.colecciones.Lista;

/**
 * Clase que implementa las acciones de un jugador.
 */
public class Jugador {
    private String nombre;
    private Mano mano;
    private CLI cli;

    Jugador(){
        this.nombre = pedirNombre();
    }

    /**
     * Método que pide al usuario el nombre del jugador.
     */
    private String pedirNombre() {
        cli = CLI.getInstance();
        return cli.pedirCadena("Introduce el nombre del jugador: ", null, false);
    }

    /**
     * Método que muestra las cartas en la mano, muestra las cartas válidas para jugar,
     * pide al usuario que seleccione una carta y devuelve la carta seleccionada.
     * @param lider palo líder del truco.
     */
    public Carta elegirCarta(Palo lider) {

        mano.mostrar();
        Lista<Integer> validas = mano.obtenerValidas(lider);

        cli = CLI.getInstance();
        int indice = cli.pedirEntero("Introduce alguno de los índices válidos: " + validas, validas, true);

        return mano.devolverCarta(indice);
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

    /**
     * Método que recibe una carta y la añade a la mano del jugador.
     * @param carta carta a añadir.
     */
    public void recibirCarta(Carta carta) {
        mano.recibirCarta(carta);
    }

    /**
     * Método que pide al jugador que elija un palo de triunfo.
     * @return palo de triunfo elegido.
     */
    public Palo elegirPalo() {
        Lista<String> palos = new Lista<>(new String[]{"enanos", "elfos", "gigantes", "humanos"});

        cli = CLI.getInstance();
        String palo = cli.pedirCadena("Introduce el palo de triunfo: ", palos, true);
        return new Palo(palo);
    }

}
