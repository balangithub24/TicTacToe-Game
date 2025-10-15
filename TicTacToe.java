import java.util.Scanner;

public class TicTacToe extends Game {
    private Player player1, player2;
    private Scanner sc;

    public TicTacToe() {
        super();
        sc = new Scanner(System.in);

        System.out.print("Enter name for Player 1 (X): ");
        player1 = new Player(sc.nextLine(), 'X');

        System.out.print("Enter name for Player 2 (O): ");
        player2 = new Player(sc.nextLine(), 'O');
    }

    @Override
    public void startGame() {
        Player currentPlayer = player1;
        boolean gameEnded = false;

        while (!gameEnded) {
            board.displayBoard();
            playerMove(currentPlayer);

            if (checkWin(currentPlayer.getSymbol())) {
                board.displayBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                gameEnded = true;
            } else if (board.isFull()) {
                board.displayBoard();
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }

        System.out.print("Play again? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            board = new Board();
            startGame();
        } else {
            System.out.println("Thanks for playing!");
        }
    }

    @Override
    public boolean checkWin(char symbol) {
        char[][] b = board.getBoard();

        for (int i = 0; i < 3; i++) {
            if ((b[i][0] == symbol && b[i][1] == symbol && b[i][2] == symbol) ||
                (b[0][i] == symbol && b[1][i] == symbol && b[2][i] == symbol))
                return true;
        }

        if ((b[0][0] == symbol && b[1][1] == symbol && b[2][2] == symbol) ||
            (b[0][2] == symbol && b[1][1] == symbol && b[2][0] == symbol))
            return true;

        return false;
    }

    private void playerMove(Player player) {
        int row = -1, col = -1;
        boolean validMove = false;

        while (!validMove) {
            System.out.print(player.getName() + " (" + player.getSymbol() + ") enter your move (1-9): ");
            int move;
            try {
                move = Integer.parseInt(sc.nextLine());
                if (move < 1 || move > 9) {
                    System.out.println("Invalid input! Enter 1-9.");
                    continue;
                }

                row = (move - 1) / 3;
                col = (move - 1) % 3;

                if (!board.isCellEmpty(row, col))
                    System.out.println("Cell occupied! Choose another.");
                else
                    validMove = true;

            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number!");
            }
        }

        board.markCell(row, col, player.getSymbol());
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.startGame();
    }
}
