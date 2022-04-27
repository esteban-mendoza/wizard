import utils.colecciones.IteradorLista;
import utils.colecciones.Lista;
import utils.colecciones.ListaCircular;

import java.util.Objects;

/**
 * Clase que implementa las acciones de un jugador.
 */
public class Jugador {
    private String nombre;
    private Mano mano;
    private CLI cli;
    private Lista<Resultado> resultados;

    Jugador() {
        this.nombre = null;
        this.mano = new Mano();
        this.resultados = new Lista<>();
    }

    Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new Mano();
        this.resultados = new Lista<>();
    }

    /**
     * Método que pide al usuario el nombre del jugador.
     */
    public void setNombre(ListaCircular<Jugador> jugadores) {
        cli = CLI.getInstance();
        String nombre = cli.pedirNombre("Introduce el nombre del jugador: ", jugadores);
        this.nombre = nombre;
    }

    /**
     * Método que genera el resultado de una nueva ronda.
     * @param puntos puntos obtenidos hasta el momento.
     * @param apuesta apuesta del jugador.
     */
    public void nuevoResultado(int puntos, int apuesta) {
        resultados.add(new Resultado(puntos, apuesta));
    }

    /**
     * Método que devuelve la puntación actual del jugador.
     * @return puntación actual del jugador.
     */
    public int getPuntos() {
        return resultados.peekLast().getPuntos();
    }

    /**
     * Método que aumenta en 1 la cantidad de trucos ganados en la ronda.
     */
    public void ganarTruco() {
        resultados.peekLast().ganarTruco();
    }

    /**
     * Método que calcula la puntuación del jugador al final de la partida.
     */
    public void finalizarRonda() {
        resultados.peekLast().actualizarPuntos();
    }

    /**
     * Muestra el resultado de la última ronda para el jugador.
     */
    public void mostrarResultado() {
        System.out.print("Jugador " + nombre + ". ");
        System.out.println(resultados.peekLast());
    }

    /**
     * Muestra el resultado determinado.
     * @param nRonda número de la ronda.
     */
    public void mostrarResultado(int nRonda) {
        IteradorLista<Resultado> it = resultados.iterador();
        it.start();

        for (int i = 0; i < nRonda; i++) {
            if (!it.hasNext()) {
                return;
            }

            Resultado resultado = it.next();

            if (i == nRonda - 1) {
                System.out.println("Jugador " + nombre + ". " + resultado);
                return;
            }
        }
    }

    /**
     * Método que muestra las cartas en la mano, muestra las cartas válidas para jugar,
     * pide al usuario que seleccione una carta y devuelve la carta seleccionada.
     * @param lider palo líder del truco.
     */
    public Carta elegirCarta(Palo lider) {

        System.out.print("Jugador " + nombre + ". ");
        mano.mostrar();
        Lista<Integer> validas = mano.obtenerValidas(lider);

        if (validas.longitud == 1) {
            Carta carta = mano.devolverCarta(validas.popFirst());
            System.out.println("Solo puedes jugar la carta " + carta + ". Dicha carta será jugada.");
            return carta;
        }

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

        System.out.print("Jugador " + nombre + ". ");
        mano.mostrar();

        cli = CLI.getInstance();
        Palo palo = cli.pedirPalo("Elige el palo de triunfo: ");
        return palo;
    }

    /**
     * Método que pide al jugador que elija una apuesta.
     * @param apuestaMaxima apuesta máxima.
     * @return apuesta elegida.
     */
    public int elegirApuesta(int apuestaMaxima) {
        System.out.println("Jugador " + nombre + ":");
        mano.mostrar();

        cli = CLI.getInstance();
        return cli.pedirEntero("Introduce la apuesta: ", 0, apuestaMaxima, true);
    }

    /**
     * Método que muestra la apuesta del jugador en la ronda especificada.
     * @param nRonda número de la ronda.
     */
    public void mostrarApuesta(int nRonda) {
        IteradorLista<Resultado> it = resultados.iterador();
        it.start();

        for (int i = 0; i < nRonda; i++) {

            if (!it.hasNext()) {
                return;
            }

            Resultado resultado = it.next();

            if (i == nRonda - 1) {
                System.out.println("Jugador " + nombre + ". Apuesta: " + resultado.getApuesta());
                return;
            }
        }
    }

    /**
     * Elemento que dice si dos jugadores son iguales usando como criterio que tengan el mismo nombre
     * @param o - objeto que se desea comparar
     * @return <code>true</code> si el objeto es igual al jugador o <code>false</code> en otro caso
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return nombre.equals(jugador.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    /**
     * Método que devuelve el nombre del jugador.
     * @return nombre del jugador.
     */
    @Override
    public String toString() {
        return nombre;
    }

    /**
     * Muestra el avance de la última ronda del jugador
     */
    public void mostrarAvanceDeRonda() {
        Resultado resultado = resultados.peekLast();
        System.out.println("El jugador ha ganado " + resultado.getnTrucosGanados() +
                " trucos de " + resultado.getApuesta() + " apostados.");
    }
}
