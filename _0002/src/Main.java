import java.util.Random; //Importando la el tomo de la biblioteca de funciones y lo emplea

public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Secuencia de números aleatorios!!");
        Random r = new Random();

        // Press Mayús+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {
            // Press Mayús+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("Numero aleatorio " + "nº" + i + " = " + r.nextInt(100));
        }
    }
}