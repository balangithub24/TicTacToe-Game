public class Board {
    private char[][] board;
    private final int SIZE = 3;

    public Board() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = '-';
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == '-';
    }

    public void markCell(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == '-') return false;
        return true;
    }

    public void displayBoard() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public char[][] getBoard() {
        return board; 
    }
}
