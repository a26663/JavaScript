import java.util.Scanner;

public class DesordenPoblacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int numHabitantes = scanner.nextInt();
            if (numHabitantes == 0) {
                break;
            }

            int[] edadesReales = new int[numHabitantes];
            for (int i = 0; i < numHabitantes; i++) {
                edadesReales[i] = scanner.nextInt();
            }

            int desordenTotal = calcularDesordenTotal(edadesReales);
            System.out.println(desordenTotal);
        }

        scanner.close();
    }

    private static int calcularDesordenTotal(int[] edades) {
        int desordenTotal = 0;
        for (int i = 0; i < edades.length; i++) {
            for (int j = i + 1; j < edades.length; j++) {
                if (edades[i] > edades[j]) {
                    desordenTotal++;
                }
            }
        }
        return desordenTotal;
    }
}
