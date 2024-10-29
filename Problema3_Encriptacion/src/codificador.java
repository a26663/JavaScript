import java.util.Scanner;

public class codificador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String vocales = "aeiouAEIOU";

        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            char primerCaracter = linea.charAt(0);
            String mensajeCodificado = linea.substring(1);

            // Calcular el desplazamiento necesario para que el primer carácter corresponda a 'p'
            int desplazamiento = primerCaracter - 'p';

            // Decodificar el mensaje aplicando el desplazamiento inverso
            String mensajeDecodificado = decodificar(mensajeCodificado, desplazamiento);

            // Detener el programa si el mensaje decodificado es "FIN"
            if (mensajeDecodificado.equals("FIN")) {
                break;
            }

            // Contar las vocales no acentuadas en el mensaje decodificado
            int contadorVocales = 0;
            for (char c : mensajeDecodificado.toCharArray()) {
                if (vocales.indexOf(c) != -1) {
                    contadorVocales++;
                }
            }

            // Imprimir el número de vocales no acentuadas en el mensaje decodificado
            System.out.println(contadorVocales);
        }
        scanner.close();
    }

    // Método para decodificar el mensaje
    public static String decodificar(String mensaje, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();

        for (char c : mensaje.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                // Aplicar el desplazamiento inverso
                int nuevaPosicion = (c - base - desplazamiento + 26) % 26 + base;
                resultado.append((char) nuevaPosicion);
            } else {
                resultado.append(c);
            }
        }

        return resultado.toString();
    }
}
