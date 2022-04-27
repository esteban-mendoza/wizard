import utils.colecciones.Lista;
import utils.colecciones.ListaCircular;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esta clase contiene los métodos para la ejecución de comandos en la consola.
 *
 * Notemos que esta clase utiliza el patrón Singleton, por lo que debe utilizarse siempre como
 * > cli = CLI.getInstance();
 *
 * La clase además guarda una referencia al juego para poder mostrar información al jugador
 * durante la partida como el historial de la partida, el resumen de la misma, o para realizar
 * acciones como detener la partida y mostrar ayuda.
 */
public class CLI {

    private static CLI instance = null;
    private final BufferedReader input;
    private Juego juego;

    /**
     * Constructor privado para implementar patrón singleton.
     */
    private CLI() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Método para obtener la instancia única de la clase.
     * @return instancia de la clase.
     */
    public static CLI getInstance() {
        if (instance == null) {
            instance = new CLI();
        }
        return instance;
    }

    /**
     * Método para obtener el juego.
     * @return juego.
     */
    public Juego getJuego() {
        return juego;
    }

    /**
     * Método para establecer el juego.
     * @param juego juego.
     */
    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    /**
     * Pide un entero al usuario usando el mensaje provisto, y si el entero está entre min y max y lo devuelve.
     *
     * <p>
     * Si <code>extras == true</code> se pueden introducir las siguientes cadenas:
     * <ul>
     *     <li>r -> se muestra un resumen del juego y vuelve a pedir la cadena.</li>
     *     <li>q -> se muestra un resumen del juego y se termina el mismo.</li>
     *     <li>h -> se muestra el historial del juego y vuelve a pedir la cadena.</li>
     *     <li>? -> se muestra la ayuda del juego y vuelve a pedir la cadena.</li>
     * </ul></p>
     *
     * @param mensaje El mensaje que se usa para pedir el entero.
     * @param min El mínimo valor que puede tomar el entero.
     * @param max El máximo valor que puede tomar el entero.
     * @return El entero introducido por el usuario.
     */
    public int pedirEntero(String mensaje, int min, int max, boolean extras) {
        int numero;

        while (true) {
            try {
                System.out.print(mensaje + "\n > ");
                String linea = input.readLine();

                if (extras) {
                    if (linea.equals("h")) {
                        Juego juego = getJuego();
                        juego.mostrarHistorial();
                        continue;
                    }

                    if (linea.equals("r")) {
                        Juego juego = getJuego();
                        juego.mostrarResumen();
                        continue;
                    }

                    if (linea.equals("q")) {
                        Juego juego = getJuego();
                        juego.terminar();
                        continue;
                    }

                    if (linea.equals("?")) {
                        Juego juego = getJuego();
                        juego.mostrarAyuda();
                        continue;
                    }

                }

                numero = Integer.parseInt(linea);
                if (numero >= min && numero <= max) {
                    return numero;
                }

                System.out.println("El número debe estar entre " + min + " y " + max + ".");

            } catch (IOException e) {
                System.out.println("Error al leer la entrada. Intente de nuevo.");
            } catch (NumberFormatException e) {
                System.out.println("El valor introducido no es un número. Intente de nuevo.");
            }
        }
    }

    /**
     * Pide un entero al usuario usando el mensaje provisto, y si el entero está en el array de válidos lo devuelve.
     *
     * <p>
     * Si <code>extras == true</code> se pueden introducir las siguientes cadenas:
     * <ul>
     *     <li>r -> se muestra un resumen del juego y vuelve a pedir la cadena.</li>
     *     <li>q -> se muestra un resumen del juego y se termina el mismo.</li>
     *     <li>h -> se muestra el historial del juego y vuelve a pedir la cadena.</li>
     *     <li>? -> se muestra la ayuda del juego y vuelve a pedir la cadena.</li>
     * </ul></p>
     *
     * @param mensaje El mensaje que se usa para pedir el entero.
     * @param validos Los valores válidos que puede tomar el entero.
     * @return El entero introducido por el usuario.
     */
    public int pedirEntero(String mensaje, Lista<Integer> validos, boolean extras) {
        int numero;

        while (true) {
            try {
                System.out.print(mensaje + "\n > ");
                String linea = input.readLine();

                if (extras) {
                    if (linea.equals("h")) {
                        Juego juego = getJuego();
                        juego.mostrarHistorial();
                        continue;
                    }

                    if (linea.equals("r")) {
                        Juego juego = getJuego();
                        juego.mostrarResumen();
                        continue;
                    }

                    if (linea.equals("q")) {
                        Juego juego = getJuego();
                        juego.terminar();
                        continue;
                    }

                    if (linea.equals("?")) {
                        Juego juego = getJuego();
                        juego.mostrarAyuda();
                        continue;
                    }
                }

                numero = Integer.parseInt(linea);
                if (validos.contains(numero))
                    return numero;


                System.out.println("El número debe ser alguno de los siguientes: " + validos + ".");

            } catch (IOException e) {
                System.out.println("Error al leer la entrada. Intente de nuevo.");
            } catch (NumberFormatException e) {
                System.out.println("El valor introducido no es un número. Intente de nuevo.");
            }
        }
    }

    /**
     * Pide una cadena al usuario usando el mensaje provisto, y si la cadena no está vacía y es una cadena
     * válida, la devuelve. De otro modo, lanza una excepción.
     *
     * <p>
     * Si <code>extras == true</code> se pueden introducir las siguientes cadenas:
     *
     * <ul>
     * <li>r -> se muestra un resumen del juego y vuelve a pedir la cadena.</li>
     * <li>q -> se muestra un resumen del juego y se termina el mismo.</li>
     * <li>h -> se muestra el historial del juego y vuelve a pedir la cadena.</li>
     * <li>? -> se muestra la ayuda del juego y vuelve a pedir la cadena.</li>
     * </ul></p>
     *
     * @param mensaje El mensaje que se usa para pedir la cadena.
     * @return La cadena introducida por el usuario.
     */
    public String pedirNombre(String mensaje, ListaCircular<Jugador> jugadores) {
        String cadena;

        while (true) {
            try {
                System.out.print(mensaje + "\n > ");
                cadena = input.readLine();

                if (cadena.length() < 1) {
                    System.out.println("La cadena ingresada debe contener al menos un caracter. Intente de nuevo.");
                    continue;
                }

                if (jugadores == null || jugadores.isEmpty())
                    return cadena;

                if (jugadores.contains(new Jugador(cadena))) {
                    System.out.println("El nombre ya ha sido elegido por otro jugador. Intente de nuevo.");
                    continue;
                }

                return cadena;

            } catch (IOException e) {
                System.out.println("Error al leer la entrada. Intente de nuevo.");
            }
        }

    }

    /**
     * Pide una cadena al usuario usando el mensaje provisto, y si la cadena no está vacía y es una cadena
     * válida, la devuelve. De otro modo, lanza una excepción.
     *
     * <p>
     * Si <code>extras == true</code> se pueden introducir las siguientes cadenas:
     *
     * <ul>
     * <li>r -> se muestra un resumen del juego y vuelve a pedir la cadena.</li>
     * <li>q -> se muestra un resumen del juego y se termina el mismo.</li>
     * <li>h -> se muestra el historial del juego y vuelve a pedir la cadena.</li>
     * <li>? -> se muestra la ayuda del juego y vuelve a pedir la cadena.</li>
     * </ul></p>
     *
     * @param mensaje El mensaje que se usa para pedir la cadena.
     * @return La cadena introducida por el usuario.
     */
    public Palo pedirPalo(String mensaje) {
        String cadena;

        Lista<Palo> palos = new Lista<>(new Palo[]{
                new Palo("enanos"),
                new Palo("elfos"),
                new Palo("gigantes"),
                new Palo("humanos")
        });

        Lista<String> nombrePalos = new Lista<>(new String[]{
                "enanos", "elfos", "gigantes", "humanos"
        });

        while (true) {
            try {
                System.out.print(mensaje + "\n > ");
                cadena = input.readLine();

                if (cadena.equals("h")) {
                    Juego juego = getJuego();
                    juego.mostrarHistorial();
                    continue;
                }

                if (cadena.equals("r")) {
                    Juego juego = getJuego();
                    juego.mostrarResumen();
                    continue;
                }

                if (cadena.equals("q")) {
                    Juego juego = getJuego();
                    juego.terminar();
                    continue;
                }

                if (cadena.equals("?")) {
                    Juego juego = getJuego();
                    juego.mostrarAyuda();
                    continue;
                }

                if (nombrePalos.contains(cadena))
                    return new Palo(cadena);

                System.out.println("La cadena debe ser alguna de las siguientes: " + palos + ".");

            } catch (IOException e) {
                System.out.println("Error al leer la entrada. Intente de nuevo.");
            }
        }

    }
}
