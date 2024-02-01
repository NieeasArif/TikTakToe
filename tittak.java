import java.util.Scanner;

public class tittak {
    public static void main(String[] args) {
        char[][] Board = new char[3][3];
        for (int row = 0; row < Board.length; row++) {
            for (int col = 0; col < Board[row].length; col++) {
                Board[row][col] = ' ';
            }
        }
        Scanner sc = new Scanner(System.in);
        char Player = 'X';
        boolean isGameOver = false;
        int moveCount = 0;
        while (!isGameOver) {
            printBoard(Board);
            System.out.println("Enter for " + Player + " at: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (Board[row][col] == ' ') {
                Board[row][col] = Player;
                moveCount++;
                isGameOver = HasWon(Board, Player);

                if (isGameOver) {
                    printBoard(Board);
                    System.out.println(Player + " Wins");
                } else {
                    if (moveCount == 9) {
                        isGameOver = true;
                        System.out.println("No Possible moves!\nGame Draw!");
                    }
                    Player = Player == 'X' ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid Position!");
            }

        }
    }

    public static void printBoard(char[][] Board) {
        for (int row = 0; row < Board.length; row++) {
            for (int col = 0; col < Board[row].length; col++) {
                System.out.print("|");
                System.out.print(" " + Board[row][col] + " ");
            }
            System.out.println("|");
        }
    }

    public static boolean HasWon(char[][] Board, char currentPlayer) {
        for (int row = 0; row < Board.length; row++) {
            if (Board[row][0] == currentPlayer && Board[row][1] == currentPlayer && Board[row][2] == currentPlayer)
                return true;
        }
        for (int col = 0; col < Board.length; col++) {
            if (Board[0][col] == currentPlayer && Board[1][col] == currentPlayer && Board[2][col] == currentPlayer)
                return true;
        }

        if (Board[0][0] == currentPlayer && Board[1][1] == currentPlayer && Board[2][2] == currentPlayer)
            return true;

        if (Board[0][2] == currentPlayer && Board[1][1] == currentPlayer && Board[2][0] == currentPlayer)
            return true;

        return false;
    }

    public static boolean GameDraw(char[][] Board) {
        for (int row = 0; row < Board.length; row++) {
            if (Board[row][0] == ' ' && Board[row][1] == ' ' && Board[row][2] == ' ')
                return false;
        }
        for (int col = 0; col < Board.length; col++) {
            if (Board[0][col] == ' ' && Board[1][col] == ' ' && Board[2][col] == ' ')
                return false;
        }

        if (Board[0][0] == ' ' && Board[1][1] == ' ' && Board[2][2] == ' ')
            return false;

        if (Board[0][2] == ' ' && Board[1][1] == ' ' && Board[2][0] == ' ')
            return false;

        return true;
    }
}