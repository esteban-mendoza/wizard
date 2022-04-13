import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esta clase contiene los métodos para la ejecución de comandos en la consola.
 */
public class CLI {

    private static CLI instance = null;
    private BufferedReader input;
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
     * De otro modo, lanza una excepción.
     *
     * @param mensaje El mensaje que se usa para pedir el entero.
     * @param min El mínimo valor que puede tomar el entero.
     * @param max El máximo valor que puede tomar el entero.
     * @return El entero introducido por el usuario.
     */
    public int pedirEntero(String mensaje, int min, int max) {
        int numero;

        while (true) {
            System.out.print(mensaje + ":\n >");
            try {
                String linea = input.readLine();
                numero = Integer.parseInt(linea);

                if (linea.equals("h")) {
                    Juego juego = getJuego();
                    juego.mostrarHistorial();
                }

                if (linea.equals("q")) {
                    Juego juego = getJuego();
                    juego.terminar();
                }

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
     * Pide una cadena al usuario usando el mensaje provisto, y si la cadena no está vacía y es una cadena
     * válida, la devuelve. De otro modo, lanza una excepción.
     *
     * @param mensaje El mensaje que se usa para pedir la cadena.
     * @return La cadena introducida por el usuario.
     */
    public String pedirCadena(String mensaje, String[] validos) {

    }
}
