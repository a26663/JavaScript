import java.util.Random;

//Version Funcional

public class Main {
    public static void main(String[] args) {
        int filas = 10;
        int columnas = 9;
        int tablero[][] = new int[filas][columnas];
        Random random = new Random();

        // Generar números aleatorios para el tablero
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int numAleatorio = random.nextInt(10) + 10 * (j + 1); // Genera entre 10*(j+1) y 10*(j+1) + 9
                tablero[i][j] = numAleatorio;
            }
        }

        // Ordenar cada columna
        for (int columna = 0; columna < columnas; columna++) {
            for (int i = 0; i < filas - 1; i++) {
                for (int j = i + 1; j < filas; j++) {
                    if (tablero[i][columna] > tablero[j][columna]) {
                        int aux = tablero[i][columna];
                        tablero[i][columna] = tablero[j][columna];
                        tablero[j][columna] = aux;
                    }
                }
            }
        }

        // Imprimir el tablero
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
