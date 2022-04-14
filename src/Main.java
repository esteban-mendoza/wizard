import utils.colecciones.Lista;
import utils.colecciones.ListaCircular;

/**
 * Punto de entrada de la aplicación.
 */
public class Main {

    public static void main(String[] args) {

//        Juego juego = new Juego();
//        juego.inicializarPartida();
//        juego.jugar();
//        juego.terminar();


        ListaCircular<Integer> lista = new ListaCircular<>();
        System.out.println(lista);

        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);

        System.out.println(lista);

        Lista<Integer> lista2 = lista.clone();
        System.out.println("lista.clone(): " +  lista2);

        lista.reverse();
        System.out.println(lista);
    }
}
