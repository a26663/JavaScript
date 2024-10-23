import java.util.Random;

public class Bingo {
    public static void main(String[] args) {
        int[][] bingoCard = generateBingoCard();
        printBingoCard(bingoCard);
    }

    public static int[][] generateBingoCard() {
        int[][] card = new int[5][5];
        Random rand = new Random();

        // Llenar las columnas B, I, N, G, O
        for (int i = 0; i < 5; i++) {
            int start = i * 15 + 1; // Empieza en 1, 16, 31, 46, 61
            int end = start + 14;   // Termina en 15, 30, 45, 60, 75
            fillColumn(card, i, start, end, rand);
        }

        // Espacio libre en el centro (columna N, fila 3)
        card[2][2] = 0; // Espacio libre

        return card;
    }

    public static void fillColumn(int[][] card, int column, int start, int end, Random rand) {
        boolean[] used = new boolean[15];
        for (int row = 0; row < 5; row++) {
            if (column == 2 && row == 2) {
                continue; // Saltar el espacio libre
            }
            int num;
            do {
                num = rand.nextInt(end - start + 1) + start;
            } while (used[num - start]);
            card[row][column] = num;
            used[num - start] = true;
        }
    }

    public static void printBingoCard(int[][] card) {
        String[] headers = {" B ", " I ", " N ", " G ", " O "};
        for (String header : headers) {
            System.out.print(header);
        }
        System.out.println();

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (card[row][col] == 0) {
                    System.out.print(" * "); // Espacio libre
                } else {
                    System.out.printf("%2d ", card[row][col]);
                }
            }
            System.out.println();
        }
    }
}
