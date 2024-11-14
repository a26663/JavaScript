import java.util.Scanner;

public class CoccionHuevos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int h = scanner.nextInt();
            int c = scanner.nextInt();

            if (h == 0 && c == 0) {
                break;
            }

            int minutosNecesarios = (int) Math.ceil((double) h / c) * 10;
            System.out.println(minutosNecesarios);
        }

        scanner.close();
    }
}
