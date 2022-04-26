package utils.colecciones;

import java.util.NoSuchElementException;

/**
 * Lista circular doblemente ligada.
 */
public class ListaCircular<T> {

    public Nodo<T> cabeza;
    public Nodo<T> ultimo;
    public int longitud;
    Iterador<T> iterador;

    /**
     * Clase Iterador que permite recorrer la lista circular. Esta clase
     * implementa la interfaz IteradorLista e implementa el patrón singleton,
     * para no perder la posición del iterador en la lista.
     */
    public static class Iterador<T> implements IteradorLista<T> {

        private static Iterador instancia;
        private ListaCircular<T> lista;
        private Nodo<T> anterior;
        private Nodo<T> siguiente;

        private Iterador(ListaCircular<T> lista) {
            this.lista = lista;
            anterior = lista.ultimo;
            siguiente = lista.cabeza;
        }

        public static Iterador getInstance(ListaCircular lista) {
            if (instancia == null) {
                instancia = new Iterador(lista);
            }
            return instancia;
        }

        /**
         * Mueve el iterador antes del elemento dado.
         * @param elemento Elemento a buscar.
         */
        public void moveBefore(T elemento) {
            if (elemento == null)
                return;
            start();
            while (!elemento.equals(next())) {
                next();
            }
            previous();
        }

        @Override
        public boolean hasPrevious() {
            return anterior != null;
        }

        @Override
        public T previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            T regresar = anterior.elemento;

            this.siguiente = this.anterior;
            this.anterior = anterior.anterior;
            return regresar;
        }

        /**
         * Mueve el iterador antes de la cabeza.
         */
        @Override
        public void start() {
            anterior = lista.ultimo;
            siguiente = lista.cabeza;
        }

        @Override
        public void end() {
            anterior = lista.ultimo;
            siguiente = lista.cabeza;
        }

        @Override
        public boolean hasNext() {
            return siguiente != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T regresar = siguiente.elemento;

            this.anterior = this.siguiente;
            this.siguiente = siguiente.siguiente;
            return regresar;
        }
    }

    public ListaCircular() {
    }

    /**
     * Agrega un elemento a la lista.
     *
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *                                  <code>null</code>.
     */
    public void add(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento es null");
        }
        agregaFinal(elemento);
    }


    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     *
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *                                  <code>null</code>.
     */
    public void agregaInicio(T elemento) {
        if (elemento == null)
            throw new IllegalArgumentException("El elemento es null");

        Nodo<T> nuevo = new Nodo<>(elemento);
        if (cabeza == null) {
            this.cabeza = this.ultimo = nuevo;
        } else {
            this.cabeza.anterior = nuevo;
            nuevo.siguiente = this.cabeza;
            this.cabeza = nuevo;
        }
        this.cabeza.anterior = this.ultimo;
        this.ultimo.siguiente = this.cabeza;
        longitud++;
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     *
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *                                  <code>null</code>.
     */
    public void agregaFinal(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento es null");
        }
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (cabeza == null) {
            this.cabeza = this.ultimo = nuevo;
            this.cabeza.siguiente = this.ultimo;
            this.ultimo.anterior = this.cabeza;
        } else {
            this.ultimo.siguiente = nuevo;
            this.cabeza.anterior = nuevo;
            nuevo.anterior = this.ultimo;
            nuevo.siguiente = this.cabeza;
            this.ultimo = nuevo;
        }
        longitud++;
    }

    /**
     * Regresa el último elemento de la lista y lo elimina.
     *
     * @return El elemento eliminado.
     */
    public T pop() {
        if (longitud == 0 || cabeza == null) {
            throw new NoSuchElementException("La lista está vacía");
        }
        T valor = ultimo.elemento;
        ultimo = ultimo.anterior;
        ultimo.siguiente = cabeza;
        cabeza.anterior = ultimo;
        longitud--;
        return valor;
    }

    /**
     * Regresa el primer elemento de la lista y lo elimina.
     *
     * @return El elemento eliminado.
     * @throws NoSuchElementException si la lista está vacía.
     */
    public T popFirst() {
        if (longitud == 0 || cabeza == null) {
            throw new NoSuchElementException("La lista está vacía");
        }
        if (longitud == 1) {
            T valor = cabeza.elemento;
            cabeza = ultimo = null;
            longitud = 0;
            return valor;
        }
        T valor = cabeza.elemento;
        cabeza = cabeza.siguiente;
        cabeza.anterior = ultimo;
        ultimo.siguiente = cabeza;
        longitud--;
        return valor;
    }

    /**
     * Regresa la longitud de la lista.
     *
     * @return La longitud de la lista.
     */
    public int size() {
        return longitud;
    }


    /**
     * Regresa una representación en cadena de la colección.
     *
     * @return una representación en cadena de la colección:
     * Lista(a, b, c, d)
     */
    public String toString() {
        StringBuilder string = new StringBuilder("Lista(");

        if (longitud == 0)
            return string.append(")").toString();

        if (longitud == 1)
            return string.append(cabeza.elemento).append(")").toString();

        Nodo<T> nodo = cabeza;
        string.append(nodo.elemento).append(", ");

        nodo = nodo.siguiente;
        while (nodo != cabeza) {
            string.append(nodo.elemento);

            if (nodo.siguiente != cabeza)
                string.append(", ");

            nodo = nodo.siguiente;
        }

        string.append(")");
        return string.toString();
    }

    /**
     * Regresa un iterador para recorrer la lista en una dirección.
     *
     * <p>
     * Observe que este método no crea un iterador, sino que regresa una referencia
     * al iterador interno. Si desea iterar desde la cabeza de la lista, use <code>iterador.start()</code>.
     * </p>
     *
     * @return un iterador para recorrer la lista en una dirección.
     */
    public Iterador<T> iterador() {
        return Iterador.getInstance(this);
    }

}
