import static utils.constantes.Colores.*;

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
        switch (nombre) {
            case "enanos":
                this.nombre = nombre;
                this.color = ROJO;
                break;
            case "elfos":
                this.nombre = nombre;
                this.color = VERDE;
                break;
            case "gigantes":
                this.nombre = nombre;
                this.color = AMARILLO;
                break;
            case "humanos":
                this.nombre = nombre;
                this.color = AZUL;
                break;
            default: throw new IllegalArgumentException("Palo no reconocido");
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

    /**
     * Devuelve el nombre del palo.
     * @return Nombre del palo.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve el color del palo.
     * @return Color del palo.
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Devuelve una cadena con el nombre del palo en el color correspondiente.
     * @return Cadena con el nombre del palo.
     */
    @Override
    public String toString() {
        return color + nombre + NEUTRO;
    }
}

