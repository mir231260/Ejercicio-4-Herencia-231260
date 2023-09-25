/**
 * Clase que representa a un Jugador de tipo Extremo en el Campeonato Internacional de Balonmano.
 *
 * Autor: David Miranda
 * Fecha de creación: 21 de septiembre de 2023
 */
public class Extremo extends Jugador {
    private int asistenciasEfectivas;

    /**
     * Constructor de la clase Extremo.
     * @param nombre Nombre del jugador.
     * @param pais País de origen del jugador.
     * @param faltas Cantidad de faltas cometidas por el jugador.
     * @param golesDirectos Cantidad de goles directos anotados por el jugador.
     * @param totalLanzamientos Cantidad total de lanzamientos realizados por el jugador.
     * @param pases Cantidad de pases realizados por el jugador.
     * @param asistenciasEfectivas Cantidad de asistencias efectivas realizadas por el jugador.
     */
    public Extremo(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos, int pases, int asistenciasEfectivas) {
        super(nombre, pais, faltas, golesDirectos, totalLanzamientos);
        this.asistenciasEfectivas = asistenciasEfectivas;
    }

    @Override
    public double calcularEfectividad() {
        if (getTotalLanzamientos() == 0) {
            return 0.0; 
        }
        return ((double) asistenciasEfectivas / getTotalLanzamientos()) * 100;
    }
}
