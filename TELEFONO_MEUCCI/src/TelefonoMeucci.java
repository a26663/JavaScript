import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TelefonoMeucci {
    private static final Map<String, Integer> romanos = new HashMap<>();

    static {
        romanos.put("I", 1);
        romanos.put("II", 2);
        romanos.put("III", 3);
        romanos.put("IV", 4);
        romanos.put("V", 5);
        romanos.put("VI", 6);
        romanos.put("VII", 7);
        romanos.put("VIII", 8);
        romanos.put("IX", 9);
        romanos.put("X", 0); // X representa 0 en el contexto del problema
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            if (linea.isEmpty()) {
                break;
            }

            int combinaciones = contarCombinaciones(linea);
            System.out.println(combinaciones);
        }

        scanner.close();
    }

    private static int contarCombinaciones(String numero) {
        if (numero.isEmpty()) {
            return 1;
        }

        int totalCombinaciones = 0;
        for (int i = 1; i <= 4 && i <= numero.length(); i++) {
            String sub = numero.substring(0, i);
            if (romanos.containsKey(sub)) {
                totalCombinaciones += contarCombinaciones(numero.substring(i));
            }
        }

        return totalCombinaciones;
    }
}
