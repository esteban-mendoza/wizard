/**
 * Punto de entrada de la aplicación.
 */
public class Main {

    public static void main(String[] args) {

        Juego juego = new Juego();
        juego.inicializarPartida();
        juego.jugar();
        juego.terminar();
    }
}
