// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Random;

public class StarWarsGame {
    static final int SIZE = 10;
    static final char YODA = 'Y';
    static final char VADER = 'V';
    static final char DARTH_MAUL = 'D';
    static final char R2D2 = 'R';
    static final char WALL = 'M';
    static final char EMPTY = 'L';
    static final int START_LIVES = 3;

    char[][] yodaBoard = new char[SIZE][SIZE];
    char[][] vaderBoard = new char[SIZE][SIZE];
    int yodaRow, yodaCol, vaderRow, vaderCol;
    int yodaLives = START_LIVES, vaderLives = START_LIVES;
    Random random = new Random();

    public StarWarsGame() {
        initializeBoard(yodaBoard, YODA, DARTH_MAUL, WALL);
        initializeBoard(vaderBoard, VADER, R2D2, WALL);
    }

    private void initializeBoard(char[][] board, char player, char badCharacter, char wall) {
        // Rellenar con 'L' inicialmente
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }

        // Colocar al jugador aleatoriamente
        placeCharacter(board, player);

        // Colocar 5 personajes malos
        for (int i = 0; i < 5; i++) {
            placeCharacter(board, badCharacter);
        }

        // Colocar 5 muros
        for (int i = 0; i < 5; i++) {
            placeCharacter(board, wall);
        }

        // Definir la casilla final
        board[SIZE - 1][SIZE - 1] = 'F';
    }

    private void placeCharacter(char[][] board, char character) {
        int row, col;
        do {
            row = random.nextInt(SIZE);
            col = random.nextInt(SIZE);
        } while (board[row][col] != EMPTY);

        board[row][col] = character;

        // Guardar posición inicial de los jugadores
        if (character == YODA) {
            yodaRow = row;
            yodaCol = col;
        } else if (character == VADER) {
            vaderRow = row;
            vaderCol = col;
        }
    }

    public void movePlayer(char player, int newRow, int newCol) {
        char[][] board = (player == YODA) ? yodaBoard : vaderBoard;
        int currentRow = (player == YODA) ? yodaRow : vaderRow;
        int currentCol = (player == YODA) ? yodaCol : vaderCol;
        int lives = (player == YODA) ? yodaLives : vaderLives;

        if (newRow < 0 || newRow >= SIZE || newCol < 0 || newCol >= SIZE || board[newRow][newCol] == WALL) {
            System.out.println("Movimiento no válido.");
            return;
        }

        // Actualizar la posición del jugador en el tablero
        board[currentRow][currentCol] = EMPTY;
        if (board[newRow][newCol] == DARTH_MAUL || board[newRow][newCol] == R2D2) {
            lives--;
            System.out.println(player + " perdió una vida. Vidas restantes: " + lives);
        }
        if (lives <= 0) {
            System.out.println(player + " ha perdido todas sus vidas. ¡Perdió el juego!");
            System.exit(0);
        }

        board[newRow][newCol] = player;

        if (player == YODA) {
            yodaRow = newRow;
            yodaCol = newCol;
            yodaLives = lives;
        } else {
            vaderRow = newRow;
            vaderCol = newCol;
            vaderLives = lives;
        }

        // Verificar si el jugador ha ganado
        if (newRow == SIZE - 1 && newCol == SIZE - 1) {
            System.out.println(player + " ha llegado a la casilla final. ¡Ganó el juego!");
            System.exit(0);
        }
    }

    public void displayBoard(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StarWarsGame game = new StarWarsGame();
        System.out.println("Tablero de Yoda:");
        game.displayBoard(game.yodaBoard);
        System.out.println("Tablero de Darth Vader:");
        game.displayBoard(game.vaderBoard);

        // Aquí puedes agregar lógica para mover a los jugadores
        // Ejemplo de movimientos:
        game.movePlayer(YODA, 1, 1); // Cambia las coordenadas según las reglas del juego
        game.movePlayer(VADER, 2, 2); // Cambia las coordenadas según las reglas del juego
    }
}
