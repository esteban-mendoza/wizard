package utils.colecciones;

class Nodo<T> {
    public T elemento;
    public Nodo<T> anterior;
    public Nodo<T> siguiente;

    public Nodo(T elemento) {
        this.elemento = elemento;
    }
}
