public class Resultado {
    private int apuesta;
    private int nTrucosGanados;
    private int puntos;
    private int resultado;

    public Resultado(int puntos, int apuesta) {
        this.apuesta = apuesta;
        this.nTrucosGanados = 0;
        this.puntos = puntos;
        this.resultado = 0;
    }

    /**
     * Devuelve la apuesta del jugador
     * @return la apuesta
     */
    public int getApuesta() {
        return apuesta;
    }

    /**
     * Devuelve el número de trucos que ha ganado el jugador en la ronda actual
     * @return el número de trucos que ha ganado el jugador en la ronda actual
     */
    public int getnTrucosGanados() {
        return nTrucosGanados;
    }

    /**
     * Aumenta en 1 el número de trucos ganados
     */
    public void ganarTruco() {
        nTrucosGanados++;
    }

    /**
     * Devuelve el resultado de la ronda para el jugador
     * @return el resultado de la ronda para el jugador
     */
    private int resultado() {
        if (apuesta == nTrucosGanados)
            return 20 + 10 * nTrucosGanados;
        else
            return -10 * Math.abs(apuesta - nTrucosGanados);
    }

    /**
     * Actualiza el número de puntos que le corresponden al jugador al final de la ronda
     */
    public void actualizarPuntos() {
        resultado = resultado();
        puntos += resultado;
    }

    /**
     * Devuelve el número de puntos que le corresponden al jugador al final de la ronda
     * @return el número de puntos que le corresponden al jugador al final de la ronda
     */
    public int getPuntos() {
        return puntos;
    }


    @Override
    public String toString() {
        String stringResultado;
        if (resultado > 0)
            stringResultado = "+" + resultado;
        else
            stringResultado = "" + resultado;
        return "Resultado: " + stringResultado + ". Puntuación actual: " + puntos + ".";
    }

}
