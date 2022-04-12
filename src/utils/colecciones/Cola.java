package utils.colecciones;

public class Cola<T> extends PushPop<T> {

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es <code>null</code>.
     */
    @Override
    public void push(T elemento) {
        if (elemento == null)
            throw new IllegalArgumentException("El elemento es null");

        Nodo aux = new Nodo(elemento);

        if (this.cabeza == null)
            this.cabeza = this.ultimo = aux;
        else {
            this.ultimo.siguiente = aux;
            this.ultimo = aux;
        }

        longi++;
    }

    /**
     * Devuelve una copia de la cola.
     * @return Una copia de la cola.
     */
    @Override
    public PushPop<T> clone() {
        Cola<T> clon = new Cola<>();

        if (isEmpty()) return clon;

        clon.push(this.cabeza.elemento);

        Nodo aux = this.cabeza;
        while (aux.siguiente != null) {
            clon.push(aux.siguiente.elemento);
            aux = aux.siguiente;
        }

        return clon;
    }

    /**
     * Devuelve una representación en String de la cola.
     *
     * Ejemplo: [1, 2, 3], donde 1 es el primer elemento de la cola y 3 el último.
     * @return Representación en String de la cola.
     */
    @Override
    public String toString() {

        String result = "[";
        Nodo aux = this.cabeza;

        while (aux != null) {
            result += aux.elemento;

            if (aux.siguiente != null)
                result += ", ";

            aux = aux.siguiente;
        }
        result += "]";

        return result;
    }
}
