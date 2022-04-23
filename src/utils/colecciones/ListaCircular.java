package utils.colecciones;

import java.util.NoSuchElementException;

/**
 * Lista circular doblemente ligada.
 */
public class ListaCircular<T> extends Lista<T> {

    public Nodo<T> cabeza;
    public Nodo<T> ultimo;
    public int longitud;
    Iterador<T> iterador;

    public ListaCircular() {
        iterador = new Iterador<>(this);
    }

    public ListaCircular(T[] elementos) {
        iterador = new Iterador<>(this);

        for (T elemento : elementos) {
            add(elemento);
        }
    }

    /**
     * Agrega un elemento a la lista.
     *
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *                                  <code>null</code>.
     */
    @Override
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
        } else {
            this.ultimo.siguiente = nuevo;
            nuevo.anterior = this.ultimo;
            this.ultimo = nuevo;
        }
        this.ultimo.siguiente = this.cabeza;
        this.cabeza.anterior = this.ultimo;
        longitud++;
    }

    /**
     * Busca el elemento dado y, si el elemento buscado está en la lista,
     * devuelve el primer nodo con el elemento deseado. Si el elemento buscado
     * no está en la lista, devuelve null.
     *
     * @param elemento elemento a buscar
     * @return nodo con elemento
     */
    private Nodo<T> buscaElemento(T elemento) {
        Nodo<T> n = cabeza;

        if (n == null)
            return null;

        if (longitud == 1)
            if (n.elemento.equals(elemento))
                return n;

        while (n != ultimo) {
            if (elemento.equals(n.elemento)) {
                return n;
            }
            n = n.siguiente;
        }
        return null;
    }

    /**
     * Elimina un elemento de la lista.
     *
     * @param elemento el elemento a eliminar.
     * @return <code>true</code> si el elemento fue eliminado correctamente
     * y <code>false</code> si el elemento no está en la lista
     */
    public boolean delete(T elemento) {
        if (elemento == null)
            return false;

        Nodo<T> n = buscaElemento(elemento);
        if (n == null) {
            return false;
        }
        if (longitud == 1) {
            empty();
            return true;
        }
        if (n == cabeza) {
            cabeza = cabeza.siguiente;
            cabeza.anterior = ultimo;
            ultimo.siguiente = cabeza;
            longitud--;
            return true;
        }
        if (n == ultimo) {
            ultimo = ultimo.anterior;
            ultimo.siguiente = cabeza;
            cabeza.anterior = ultimo;
            longitud--;
            return true;
        }
        n.siguiente.anterior = n.anterior;
        n.anterior.siguiente = n.siguiente;
        longitud--;
        return true;
    }


    /**
     * Regresa el último elemento de la lista y lo elimina.
     *
     * @return El elemento eliminado.
     */
    public T pop() {
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
            throw new NoSuchElementException("");
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
     * Nos dice si un elemento está contenido en la lista.
     *
     * @param elemento el elemento que queremos verificar si está contenido en
     *                 la lista.
     * @return <code>true</code> si el elemento está contenido en la lista,
     * <code>false</code> en otro caso.
     */
    public boolean contains(T elemento) {
        return buscaElemento(elemento) != null;
    }

    /**
     * Vacía la lista.
     */
    public void empty() {
        cabeza = ultimo = null;
        longitud = 0;
    }

    /**
     * Nos dice si la lista es vacía.
     *
     * @return <code>true</code> si la lista es vacía, <code>false</code> en
     * otro caso.
     */
    public boolean isEmpty() {
        return longitud == 0;
    }


    /**
     * Regresa una copia de la lista.
     *
     * @return una copia de la lista.
     */
    public ListaCircular<T> clone() {
        ListaCircular<T> nueva = new ListaCircular<>();
        Nodo<T> nodo = cabeza;

        if (nodo == null || longitud == 0)
            return nueva;

        if (longitud == 1)
            nueva.add(nodo.elemento);

        while (nodo != ultimo) {
            nueva.add(nodo.elemento);
            nodo = nodo.siguiente;
        }
        return nueva;
    }

    /**
     * Nos dice si la colección es igual a otra colección recibida.
     *
     * @param lista la lista con la que queremos comparar.
     * @return <tt>true</tt> si la lista es igual a la recibida, <tt>false</tt> en
     *          otro caso.
     */
    public boolean equals(ListaCircular<T> lista) {

        if (lista.size() == 0)
            return true;

        if (lista.size() != this.size())
            return false;

        Nodo<T> left = cabeza;
        Nodo<T> right = lista.cabeza;

        if (lista.size() == 1)
            return left.elemento.equals(right.elemento);

        while (left != ultimo) {
            if (!left.elemento.equals(right.elemento))
                return false;
            left = left.siguiente;
            right = right.siguiente;
        }
        return true;
    }


    /**
     * Método que invierte el orden de la lista.
     */
    public void reverse() {

        if (size() <= 1)
            return;

        Nodo<T> aux;

        // Intercambia referencias de cabeza y último
        aux = cabeza;
        cabeza = ultimo;
        ultimo = aux;
        cabeza.anterior = ultimo;
        ultimo.siguiente = cabeza;

        Nodo<T> actual = cabeza.siguiente;

        while (actual != cabeza) {
            // Intercambia referencias de siguiente y anterior de nodo actual
            aux = actual.anterior;
            actual.anterior = actual.siguiente;
            actual.siguiente = aux;

            actual = actual.siguiente;
        }
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
     * Junta dos listas siempre y cuando sean del mismo tipo.
     */
    public void append(Lista<T> lista) {

        if (this == lista) {
            lista = lista.clone();
        }

        Iterador<T> iterador = new Iterador<>(lista);

        while (iterador.hasNext()) {
            this.add(iterador.next());
        }
    }

    /**
     * Regresa un entero con la posición del elemento.
     * Solo nos importará la primera aparición del elemento
     * Empieza a contar desde 0.
     *
     * @param elemento elemento del cual queremos conocer la posición.
     * @return entero con la posición del elemento
     * @throws IllegalArgumentException si <code>elemento</code> es
     *                                  <code>null</code>.
     */
    public int indexOf(T elemento) {
        if (elemento == null)
            throw new IllegalArgumentException("El elemento es null");

        int index = 0;
        Iterador<T> iterador = new Iterador<>(this);

        while (iterador.hasNext()) {
            if (elemento == iterador.next())
                return index;

            index++;
        }

        throw new NoSuchElementException("El elemento no está en la lista.");
    }

    /**
     * Inserta un elemento en un índice explícito.
     * <p>
     * Si el índice es menor que cero, el elemento se agrega al inicio de la
     * lista. Si el índice es mayor o igual que el número de elementos en la
     * lista, el elemento se agrega al final de la misma. En otro caso, después
     * de mandar llamar el método, el elemento tendrá el índice que se
     * especifica en la lista.
     *
     * @param i        El índice donde insertar el elemento. Si es menor que 0 el
     *                 elemento se agrega al inicio, y si es mayor o igual que el
     *                 número de elementos en la lista se agrega al final.
     * @param elemento el elemento a insertar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *                                  <code>null</code>
     */
    public void insert(int i, T elemento) {

        if (elemento == null)
            throw new IllegalArgumentException("Elemento es null");

        if (i <= 0) {
            agregaInicio(elemento);
            return;
        }

        if (i >= size()) {
            agregaFinal(elemento);
            return;
        }

        Iterador<T> iterador = new Iterador<>(this);

        // Mueve el iterador hasta la posición deseada
        for (int j = 0; j < i; j++) {
            iterador.next();
        }

        // Crea nodo de lista
        Nodo<T> nuevoNodo = new Nodo<>(elemento);

        nuevoNodo.anterior = iterador.anterior;
        nuevoNodo.siguiente = iterador.siguiente;

        // Inserta elemento en la lista
        iterador.anterior.siguiente = nuevoNodo;
        iterador.siguiente.anterior = nuevoNodo;

        longitud++;
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
        return iterador;
    }

    /**
     * Regresa un iterador para recorrer la lista en ambas direcciones.
     *
     * <p>
     * Observe que este método no crea un iterador, sino que regresa una referencia
     * al iterador interno. Si desea iterar desde la cabeza de la lista, use <code>iterador.start()</code>.
     * </p>
     *
     * @return un iterador para recorrer la lista en ambas direcciones.
     */
    public IteradorLista<T> iteradorLista() {
        return iterador;
    }
}
