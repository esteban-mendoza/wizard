import java.util.Objects;

/**
* CLase que representa a un palo.
*/

public class Palo {
    /**
    * Atributos de la clase.
    */
    private String nombre;
    private String color;
    private Boolean lider;
    private Boolean triunfo;

    /**
    * Constructor de la clase.
    */
    public Palo(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        this.lider = false;
        this.triunfo = false;
    }

    /**
     * Metodo que devuelve el nombre del palo.
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que devuelve el color del palo.
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * Metodo que devuelve si el palo es lider.
     * @return
     */
    public Boolean getLider() {
        return lider;
    }

    /**
     * Metodo que establece si el palo es lider.
     * @param lider
     */
    public void setLider(Boolean lider) {
        this.lider = lider;
    }
    /**
     * Metodo que devuelve si el palo es de triunfo.
     * @return
     */
    public Boolean getTriunfo() {
        return triunfo;
    }
    /**
     * Metodo que establece si el palo es de triunfo.
     * @param triunfo
     */
    public void setTriunfo(Boolean triunfo) {
        this.triunfo = triunfo;
    }

    /**
     * Metodo que devuelve el palo en formato String.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Palo{" +
                "nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", lider=" + lider +
                ", triunfo=" + triunfo +
                '}';
    }

    public boolean equals (Palo palo) {
        if (this.nombre.equals(palo.getNombre()) && this.color.equals(palo.getColor())) {
            return true;
        }
        return false;
    }

    /**
     * metodo que verifica si el palo es lider.
     * @return
     */
    public boolean esLider(){
        if (this.lider == true && this.triunfo == false) {
            return true;
        }
        return false;
    }

    /**
     * metodo que verifica si el palo es de triunfo.
     * @return
     */
    public boolean esTriunfo(){
        if (this.triunfo == true && this.lider == false) {
            return true;
        }
        return false;
    }
}

