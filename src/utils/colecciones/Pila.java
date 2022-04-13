package utils.colecciones;

public class Pila<T> extends PushPop<T>{


    /**
     * Agrega un elemento al inicio de la pila.
     * @param elemento el elemento a agregar.
     */
    public void push(T elemento){
        if(elemento == null){
            throw new IllegalArgumentException("");
        }
        Nodo aux = new Nodo(elemento);
        if(isEmpty()){
            this.cabeza=ultimo=aux;
            longi++;
            return ;
        }
        aux.siguiente = cabeza;
        cabeza = aux;
        longi ++;
    }

    /**
     * Regresa un clon de la estructura.
     * 
     * @return un clon de la estructura.
     */
    public Pila<T> clone(){
        Pila<T> nueva = new Pila<>();
        if (this.isEmpty()) {
            return nueva;
        }
        nueva.push(this.cabeza.elemento);
        Nodo n = this.cabeza;
        while (n.siguiente != null) {
           nueva.push(n.siguiente.elemento);
           n = n.siguiente;
        }
        return nueva;
    }

    public String toString(){
        StringBuilder result = new StringBuilder("{");
        Nodo aux = this.cabeza;

        while (aux != null) {
            result.append(aux.elemento);

            if (aux.siguiente != null)
                result.append(", ");

            aux = aux.siguiente;
        }
        result.append("}");

        return result.toString();
    }


}
