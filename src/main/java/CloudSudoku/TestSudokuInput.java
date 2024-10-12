package CloudSudoku;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestSudokuInput {
    public static void main(String[] args) {
        String json = "{\"board\": [[5, 3, 0, 0, 7, 0, 0, 0, 0], [6, 0, 0, 1, 9, 5, 0, 0, 0], [0, 9, 8, 0, 0, 0, 0, 6, 0], [8, 0, 0, 0, 6, 0, 0, 0, 3], [4, 0, 0, 8, 0, 3, 0, 0, 1], [7, 0, 0, 0, 2, 0, 0, 0, 6], [0, 6, 0, 0, 0, 0, 2, 8, 0], [0, 0, 0, 4, 1, 9, 0, 0, 5], [0, 0, 0, 0, 8, 0, 0, 7, 9]]}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            SudokuInput input = objectMapper.readValue(json, SudokuInput.class);
            System.out.println("Deserialized object: " + input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
