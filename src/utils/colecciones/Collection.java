package utils.colecciones;

public interface Collection<T> {

    /**
     * Agrega un elemento a la colección.
     * 
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *                                  <code>null</code>.
    */
    void add(T elemento);

    /**
     * Elimina un elemento de la colección.
     * 
     * @param elemento el elemento a eliminar.
     */
    boolean delete(T elemento);

    /**
     * Regresa un elemento de la colección y lo elimina.
     * 
     * @return El elemento a sacar.
     */
    T pop();

    /**
     * Regresa el número de elementos en la colección.
     * 
     * @return el número de elementos en la colección.
     */
    int size();

    /**
     * Nos dice si un elemento está contenido en la colección.
     * 
     * @param elemento el elemento que queremos verificar si está contenido en
     *                 la colección.
     * @return <code>true</code> si el elemento está contenido en la colección,
     *         <code>false</code> en otro caso.
     */
    boolean contains(T elemento);

    /**
     * Vacía la colección.
     * 
     */
    void empty();

    /**
     * Nos dice si la colección es vacía.
     * 
     * @return <code>true</code> si la colección es vacía, <code>false</code> en
     *         otro caso.
     */
    boolean isEmpty();
    
    /**
     * Nos dice si la colección es igual a otra colección recibida.
     * 
     * @param o el objeto con el que hay que comparar.
     * @return <tt>true</tt> si la colección es igual a la colección recibida;
     *         <tt>false</tt> en otro caso.
     */
    boolean equals(Object o);

    /**
     * Regresa una representación en cadena de la colección.
     * 
     * @return una representación en cadena de la colección.
     */
    String toString();
    /**
     * Regresa una copia de la colección.
     * 
     * @return una copia de la colección.
     */
    Collection<T> clone();


}
