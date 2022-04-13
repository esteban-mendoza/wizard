/**
 * Punto de entrada de la aplicación.
 */
public class Main {

    public static void main(String[] args) {

        Juego juego = new Juego();
        juego.configurarPartida();
        juego.jugar();
        juego.terminar();
    }
}
