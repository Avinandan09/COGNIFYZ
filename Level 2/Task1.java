import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        boolean playAgain = true;

        while (playAgain) {
            initializeBoard(board);
            char currentPlayer = 'X';
            boolean gameWon = false;
            int moveCount = 0;

            while (!gameWon && moveCount < 9) {
                printBoard(board);
                playerMove(board, currentPlayer, scanner);
                gameWon = checkWin(board, currentPlayer);

                if (gameWon) {
                    printBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                } else if (moveCount == 8) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                moveCount++;
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().equalsIgnoreCase("y");
        }

        scanner.close();
    }

    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    public static void playerMove(char[][] board, char currentPlayer, Scanner scanner) {
        boolean validMove = false;
        while (!validMove) {
            System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                validMove = true;
            } else {
                System.out.println("This move is not valid.");
            }
        }
    }

    public static boolean checkWin(char[][] board, char currentPlayer) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }
}
