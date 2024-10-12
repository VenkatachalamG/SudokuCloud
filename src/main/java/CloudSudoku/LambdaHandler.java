package CloudSudoku;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaHandler implements RequestHandler<SudokuInput, String> {

    @Override
    public String handleRequest(SudokuInput input, Context context) {
        context.getLogger().log("Input received: " + input + "\n");
        System.out.println();
        if (input == null || input.getBoard() == null) {
            return "{\"error\": \"Invalid input: Sudoku board is required.\"}";
        }

        int[][] board = input.getBoard();
        if (board.length != 9 || board[0].length != 9) {
            return "{\"error\": \"Invalid input: Sudoku board must be 9x9.\"}";
        }

        // Attempt to solve the board
        if (SudokuSolver.solve(board)) {
            String result = SudokuSolver.display(board);
            System.out.println("\n"+result); // Print to terminal
            return result;
        } else {
            return "{\"error\": \"Cannot solve.\"}";
        }
    }
}
