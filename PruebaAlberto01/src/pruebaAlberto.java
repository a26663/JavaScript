import java.util.Random;
import java.util.Scanner;

public class pruebaAlberto {
    public static void main(String[] args) {

        Random rdm = new Random();
        Scanner sc = new Scanner(System.in);

        int filas = 10;
        int columnas = 10;

        int[][] tableroNumeros = new int[filas][columnas];
        char[][] tableroX = new char[filas][columnas];

        // Inicializar los tableros
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tableroNumeros[i][j] = rdm.nextInt(89) + 10;
                tableroX[i][j] = ' ';
            }
        }

        // Mostrar el tablero de números (opcional)
        System.out.println("Tablero de números aleatorios:");
        mostrarTablero(tableroNumeros);

        // Permitir al usuario insertar 10 números
        for (int i = 0; i < 10; i++) {
            System.out.println(" ");
            System.out.print("· Ingresa el número " + (i + 1) + ": ");
            int num = sc.nextInt();
            if (num >= 100 || num < 10) {
                System.out.println("Ese número no es posible.");
            } else {
                marcarX(tableroNumeros, tableroX, num);
            }
        }

        // Mostrar el tablero de resultados con las X
        System.out.println(" ");
        System.out.println("Tablero resultado con X marcando las respuestas correctas:");
        mostrarTableroConResultados(tableroNumeros, tableroX);
    }


    private static void mostrarTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) { // Recorremos las filas
            for (int j = 0; j < tablero[i].length; j++) { // Recorremos las columnas de cada fila
                System.out.print(tablero[i][j] + " "); // Imprimimos el número con un espacio
            }
            System.out.println(); // Hacemos un salto de línea al final de cada fila
        }
    }
    private static void mostrarTableroConResultados(int[][] tableroNumeros, char[][] tableroX) {
        for (int i = 0; i < tableroNumeros.length; i++) {
            for (int j = 0; j < tableroNumeros[i].length; j++) {
                if (tableroX[i][j] == 'X') {
                    System.out.print("X  "); // Mostrar la X para respuestas correctas
                } else {
                    System.out.print(tableroNumeros[i][j] + " "); // Mostrar el número original
                }
            }
            System.out.println();
        }
    }

    private static void marcarX(int[][] tableroNumeros, char[][] tableroX, int numero) {
        for (int i = 0; i < tableroNumeros.length; i++) {
            for (int j = 0; j < tableroNumeros[i].length; j++) {
                if (tableroNumeros[i][j] == numero) {
                    tableroX[i][j] = 'X'; // Marcar X si el número coincide
                }
            }
        }
    }
}



