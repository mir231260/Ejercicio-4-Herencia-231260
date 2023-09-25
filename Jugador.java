/**
 * Clase que representa a un Jugador en el Campeonato Internacional de Balonmano.
 *
 * Autor: David Miranda
 * Fecha de creación: 21 de septiembre de 2023
 */
public class Jugador {
    private String nombre;
    private String pais;
    private int faltas;
    private int golesDirectos;
    private int totalLanzamientos;

    /**
     * Constructor de la clase Jugador.
     * @param nombre Nombre del jugador.
     * @param pais País de origen del jugador.
     * @param faltas Cantidad de faltas cometidas por el jugador.
     * @param golesDirectos Cantidad de goles directos anotados por el jugador.
     * @param totalLanzamientos Cantidad total de lanzamientos realizados por el jugador.
     */
    public Jugador(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos) {
        this.nombre = nombre;
        this.pais = pais;
        this.faltas = faltas;
        this.golesDirectos = golesDirectos;
        this.totalLanzamientos = totalLanzamientos;
    }

    /**
     * Calcula la efectividad del jugador.
     * @return El valor de efectividad del jugador (0.0 por defecto).
     */
    public double calcularEfectividad() {
        // Implementa el cálculo de efectividad según el tipo de jugador
        return 0.0;
    }
    /**
     * Obtiene el nombre del jugador.
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    // Getters y setters

    public int getTotalLanzamientos() {
        return totalLanzamientos;
    }

    public void setTotalLanzamientos(int totalLanzamientos) {
        this.totalLanzamientos = totalLanzamientos;
    }

    @Override
    public String toString (){
        return "Nombre: " + nombre +
        "\nPais: " + pais +
        "\nFaltas: "+ faltas+
        "\nGoles Directos:" + golesDirectos+
        "\nTotal Lanzamientos:"+ totalLanzamientos ;
    }
}
