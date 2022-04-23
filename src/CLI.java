import utils.colecciones.Lista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esta clase contiene los métodos para la ejecución de comandos en la consola.
 *
 * Notemos que esta clase utiliza el patrón Singleton, por lo que debe utilizarse siempre como
 * > cli = CLI.getInstance();
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
            System.out.print(mensaje + "\n > ");
            try {
                String linea = input.readLine();

                if (extras) {
                    if (linea.equals("h")) {
                        Juego juego = getJuego();
                        juego.mostrarHistorial();
                    }

                    if (linea.equals("r")) {
                        Juego juego = getJuego();
                        juego.mostrarResumen();
                    }

                    if (linea.equals("q")) {
                        Juego juego = getJuego();
                        juego.terminar();
                    }

                    if (linea.equals("?")) {
                        Juego juego = getJuego();
                        juego.mostrarAyuda();
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
            System.out.print(mensaje + "\n > ");
            try {
                String linea = input.readLine();

                if (extras) {
                    if (linea.equals("h")) {
                        Juego juego = getJuego();
                        juego.mostrarHistorial();
                    }

                    if (linea.equals("r")) {
                        Juego juego = getJuego();
                        juego.mostrarResumen();
                    }

                    if (linea.equals("q")) {
                        Juego juego = getJuego();
                        juego.terminar();
                    }

                    if (linea.equals("?")) {
                        Juego juego = getJuego();
                        juego.mostrarAyuda();
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
     * @param validos Las formas válidas que puede tomar la cadena.
     * @return La cadena introducida por el usuario.
     */
    public String pedirCadena(String mensaje, Lista<String> validos, boolean extras) {
        String cadena;

        while (true) {
            System.out.print(mensaje + "\n > ");

            try {
                cadena = input.readLine();

                if (extras) {
                    if (cadena.equals("h")) {
                        Juego juego = getJuego();
                        juego.mostrarHistorial();
                    }

                    if (cadena.equals("r")) {
                        Juego juego = getJuego();
                        juego.mostrarResumen();
                    }

                    if (cadena.equals("q")) {
                        Juego juego = getJuego();
                        juego.terminar();
                    }

                    if (cadena.equals("?")) {
                        Juego juego = getJuego();
                        juego.mostrarAyuda();
                    }
                }

                if (validos == null) {
                    return cadena;
                }

                if (validos.contains(cadena))
                    return cadena;

                System.out.println("La cadena debe ser alguna de las siguientes: " + validos + ".");

            } catch (IOException e) {
                System.out.println("Error al leer la entrada. Intente de nuevo.");
            }
        }

    }
}
