import java.util.Objects;

/**
* CLase que representa a un palo.
*/

public class Palo {
    /**
    * Atributos de la clase.
    */
    private final String nombre;
    private String color;

    /**
    * Constructor de la clase.
    */
    public Palo(String nombre) {
        this.nombre = nombre;

        switch (nombre) {
            case "enanos": this.color = "\u001B[31m"; break;
            case "elfos": this.color = "\u001B[32m"; break;
            case "gigantes": this.color = "\u001B[33m"; break;
            case "humanos": this.color = "\u001B[34m"; break;
        }
    }

    /**
     * Determina si dos palos son iguales.
     * @param otroPalo Palo con el que se compara.
     * @return true si son iguales, false en caso contrario.
     */
    public boolean equals(Palo otroPalo) {
        return this.nombre.equals(otroPalo.nombre);
    }


}

