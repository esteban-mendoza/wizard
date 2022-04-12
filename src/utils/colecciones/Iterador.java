package utils.colecciones;

import java.util.NoSuchElementException;

// Iterador
class Iterador<T> implements IteradorLista<T> {
    private final Lista<T> lista;
    public Nodo<T> anterior;
    public Nodo<T> siguiente;


    public Iterador(Lista<T> lista) {
        this.lista = lista;
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

    @Override
    public void start() {
        this.anterior = null;
        this.siguiente = lista.cabeza;
    }

    @Override
    public void end() {
        this.anterior = lista.ultimo;
        this.siguiente = null;
    }

}
