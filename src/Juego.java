/**
 * Clase principal con la lógica del juego.
 *
 * Instancia una nueva partida y llama a sus métodos.
 */
public class Juego {

    private CLI cli;
    private Partida partida;

    public Juego() {
        System.out.println("Bienvenidx a Wizard (ᚹᛇᛉᛖᚱᛞ).");
        cli = CLI.getInstance();
        cli.setJuego(this);
        partida = new Partida();
    }

    /**
     * Jugar la partida.
     */
    public void jugar() {
        mostrarAyuda();
        partida.iniciarPartida();
        terminar();
    }

    /**
     * Muestra el historial de la partida.
     */
    public void mostrarHistorial() {
        System.out.println("==========================================================");
        System.out.println("Historial de la partida:");
        partida.mostrarHistorial();
        System.out.println("==========================================================");
    }

    /**
     * Muestra resumen de la partida.
     */
    public void mostrarResumen() {
        partida.mostrarResumen();
    }

    /**
     * Terminar juego.
     */
    public void terminar() {
        System.out.println("==========================================================");
        System.out.println("Ha concluido la partida.");
        mostrarResumen();
    }

    /**
     * Muestra las opciones que el usuario puede elegir durante el juego.
     */
    public void mostrarAyuda() {
        System.out.println("==========================================================");
        System.out.println("A partir de este momento, puede ingresar cualquiera de las siguientes opciones\n" +
                "cuando se le pida alguna acción:");
        System.out.println("\th - Mostrar historial de la partida.");
        System.out.println("\tr - Mostrar resumen de la partida.");
        System.out.println("\tq - Terminar juego.");
        System.out.println("\t? - Mostrar este mensaje de ayuda.");
        System.out.println("Para ver un video explicando las reglas de Wizard diríjase a: https://youtu.be/mYO4lealSes");
    }

}
