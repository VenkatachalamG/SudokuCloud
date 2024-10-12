package CloudSudoku;

import java.util.Arrays;

public class SudokuInput {

    public int[][] board;

    // Default constructor (required for JSON parsing)
    public SudokuInput() {
    }

    // Getter method for the board
    public int[][] getBoard() {
        return board;
    }

    // Setter method for the board
    public void setBoard(int[][] board) {
        System.out.println("Setting board: " + Arrays.deepToString(board));
        this.board = board;
    }

    @Override
    public String toString() {
        return "SudokuInput{" +
                "board=" + Arrays.deepToString(board) +
                '}';
    }
}
