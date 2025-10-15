public abstract class Game {
    protected Board board;

    public Game() {
        board = new Board();
    }

    public abstract void startGame(); 
    public abstract boolean checkWin(char symbol); 

    public boolean isDraw() {
        return board.isFull() && !checkWin('X') && !checkWin('O');
    }
}
