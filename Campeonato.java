import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * Clase que representa el Campeonato Internacional de Balonmano.
 * Permite registrar jugadores, calcular su efectividad, y realizar consultas sobre los jugadores.
 *
 * Autor: David Miranda
 * Fecha de creación: 21 de septiembre de 2023
 */
public class Campeonato {
    private ArrayList<Jugador> jugadores;
    private Scanner scanner;

    /**
     * Constructor de la clase Campeonato.
     * Inicializa la lista de jugadores y el objeto Scanner para entrada de datos.
     */
    public Campeonato() {
        jugadores = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Agrega un nuevo jugador al campeonato, solicitando información al usuario.
     */
    public void agregarJugador() {
        System.out.println("Agregando un nuevo jugador:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("País: ");
        String pais = scanner.nextLine();
        System.out.print("Faltas: ");
        int faltas = Integer.parseInt(scanner.nextLine());
        System.out.print("Goles directos: ");
        int golesDirectos = Integer.parseInt(scanner.nextLine());
        System.out.print("Total de lanzamientos: ");
        int totalLanzamientos = Integer.parseInt(scanner.nextLine());

        System.out.print("¿Es portero? (S/N): ");
        String esPortero = scanner.nextLine().toUpperCase();

        if (esPortero.equals("S")) {
            System.out.print("Paradas efectivas: ");
            int paradasEfectivas = Integer.parseInt(scanner.nextLine());
            System.out.print("Goles recibidos: ");
            int golesRecibidos = Integer.parseInt(scanner.nextLine());
            Portero portero = new Portero(nombre, pais, faltas, golesDirectos, totalLanzamientos, paradasEfectivas, golesRecibidos);
            jugadores.add(portero);
        } else {
            System.out.print("Pases: ");
            int pases = Integer.parseInt(scanner.nextLine());
            System.out.print("Asistencias efectivas: ");
            int asistenciasEfectivas = Integer.parseInt(scanner.nextLine());
            Extremo extremo = new Extremo(nombre, pais, faltas, golesDirectos, totalLanzamientos, pases, asistenciasEfectivas);
            jugadores.add(extremo);
        }

        System.out.println("Jugador agregado con éxito.");
    }

    /**
     * Muestra la lista de jugadores registrados en el campeonato.
     */
    public void mostrarJugadores() {
        System.out.println("---- Lista de Jugadores ----");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.toString());
        }
    }

    /**
     * Muestra a los mejores porteros en función de su efectividad.
     */
    public void mostrarMejoresPorteros() {
        ArrayList<Portero> porteros = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Portero) {
                porteros.add((Portero) jugador);
            }
        }
        if (porteros.isEmpty()) {
            System.out.println("No hay porteros registrados en el campeonato.");
            return;
        }
        // Ordenar los porteros por efectividad
        Collections.sort(porteros, (p1, p2) -> Double.compare(p2.calcularEfectividad(), p1.calcularEfectividad()));
        System.out.println("---- Mejores Porteros ----");
        int numMostrados = Math.min(porteros.size(), 3); // Mostrar los 3 mejores o menos si hay menos
        for (int i = 0; i < numMostrados; i++) {
            Portero portero = porteros.get(i);
            System.out.println("Nombre: " + portero.getNombre());
            System.out.println("Efectividad: " + portero.calcularEfectividad() + "%");
            System.out.println("-----------------------");
        }
    }

    /**
     * Cuenta la cantidad de extremos con más del 85% de efectividad.
     * @return La cantidad de extremos efectivos.
     */
    public int contarExtremosEfectivos() {
        int contador = 0;
        for (Jugador jugador : jugadores) {
            if (jugador instanceof Extremo) {
                double efectividad = jugador.calcularEfectividad();
                if (efectividad > 85) {
                    contador++;
                }
            }
        }
        return contador;
    }
}
