import java.util.Scanner;

public class piramides {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de casos de prueba
        int n = scanner.nextInt();

        // Procesar cada caso de prueba
        for (int i = 0; i < n; i++) {
            // Leer los años A, B y C
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();

            // Calcular las distancias absolutas de A y C a B
            int distanciaA = calcularDistancia(A, B);
            int distanciaC = calcularDistancia(C, B);

            // Determinar cuál año está más cerca de B o si es empate
            if (distanciaA < distanciaC) {
                System.out.println(A);
            } else if (distanciaC < distanciaA) {
                System.out.println(C);
            } else {
                System.out.println("EMPATE");
            }
        }

        scanner.close();
    }

    // Método para calcular la distancia entre dos años teniendo en cuenta que no existe el año 0
    private static int calcularDistancia(int año1, int año2) {
        if ((año1 < 0 && año2 > 0) || (año1 > 0 && año2 < 0)) {
            return Math.abs(año1 - año2) - 1; // Ajustar para no contar el año 0 inexistente
        }
        return Math.abs(año1 - año2);
    }
}
