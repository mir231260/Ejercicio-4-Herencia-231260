/**
 * Clase que representa a un Jugador de tipo Portero en el Campeonato Internacional de Balonmano.
 *
 * Autor: David Miranda
 * Fecha de creación: 21 de septiembre de 2023
 */
public class Portero extends Jugador {
    private int paradasEfectivas;
    private int golesRecibidos;

    /**
     * Constructor de la clase Portero.
     * @param nombre Nombre del portero.
     * @param pais País de origen del portero.
     * @param faltas Cantidad de faltas cometidas por el portero.
     * @param golesDirectos Cantidad de goles directos anotados por el portero.
     * @param totalLanzamientos Cantidad total de lanzamientos realizados por el portero.
     * @param paradasEfectivas Cantidad de paradas efectivas realizadas por el portero.
     * @param golesRecibidos Cantidad de goles recibidos por el portero.
     */
    public Portero(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos, int paradasEfectivas, int golesRecibidos) {
        super(nombre, pais, faltas, golesDirectos, totalLanzamientos);
        this.paradasEfectivas = paradasEfectivas;
        this.golesRecibidos = golesRecibidos;
    }

    @Override
    public double calcularEfectividad() {
        if (golesRecibidos == 0) {
            return 100.0; //evitar división por cero
        }
        return ((double) paradasEfectivas / golesRecibidos) * 100;
    }

    @Override
    public String toString() {
        return super.toString() +
        "\nParadas efectivas: " + paradasEfectivas +
        "\nGoles recibidos: " + golesRecibidos;
    }
}
