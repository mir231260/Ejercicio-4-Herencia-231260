/**
 * Clase que se encarga de interactuar con el usuario, mostrar las opciones disponibles
 * y leer la opción seleccionada.
 *
 * Autor: David Miranda
 * Fecha de creación: 21 de septiembre de 2023
 */
import java.util.Scanner;
//import java.util.ArrayList;

public class Menu {
    private Campeonato campeonato;
    private Scanner scanner;

    /**
     * Constructor de la clase Menu.
     */
    public Menu() {
        campeonato = new Campeonato();
        scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú de opciones y realiza las acciones correspondientes.
     */
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("----- Menú del Campeonato de Balonmano -----");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Mostrar jugadores");
            System.out.println("3. Mostrar mejores porteros");
            System.out.println("4. Contar extremos efectivos");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    campeonato.agregarJugador();
                    break;
                case 2:
                    campeonato.mostrarJugadores();
                    break;
                case 3:
                    campeonato.mostrarMejoresPorteros();
                    break;
                case 4:
                    int extremosEfectivos = campeonato.contarExtremosEfectivos();
                    System.out.println("Cantidad de extremos efectivos: " + extremosEfectivos);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

    /**
     * Lee la opción seleccionada por el usuario.
     * @return La opción seleccionada.
     */
    private int leerOpcion() {
        int opcion = -1;
        while (opcion < 0) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número válido.");
            }
        }
        return opcion;
    }

    /**
     * Método principal para ejecutar el programa.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mostrarMenu();
    }
}
