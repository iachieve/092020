package BackTracking.Sudoku;

public class Algorithm {
  final int BOARD_SIZE = 9;
  final int MIN_NUMBER = 1;
  final int MAX_NUMBER = 9;
  final int BOX_SIZE = 3;

  private int[][] sudokuTable;

  public Algorithm(int[][] sudokuTable) {
    this.sudokuTable = sudokuTable;
  }

  public void solveProblem() {
    if (solve(0, 0)) {
      showResult();
    } else {
      System.out.println("no solution");
    }
  }

  private boolean solve(int rowIdx, int colIdx) {
    if (rowIdx == BOARD_SIZE && ++colIdx == BOARD_SIZE) {
      return true;
    }

    if (rowIdx == BOARD_SIZE) {
      rowIdx = 0;
    }
    if (sudokuTable[rowIdx][colIdx] != 0) {
      return solve(rowIdx + 1, colIdx);
    }
    for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
      if (valid(rowIdx, colIdx, number)) {
        sudokuTable[rowIdx][colIdx] = number;
        if (solve(rowIdx + 1, colIdx)) {
          return true;
        }
        // backtrack
        sudokuTable[rowIdx][colIdx] = 0;
      }
    }
    return false;
  }

  private boolean valid(int rowIdx, int colIdx, int actualNumber) {
    // check if the number already in the row
    for (int i = 0; i < BOARD_SIZE; i++)
      if (sudokuTable[i][rowIdx] == actualNumber)
        return false;

    // check if the number already in the column
    for (int i = 0; i < BOARD_SIZE; i++)
      if (sudokuTable[colIdx][i] == actualNumber)
        return false;

    // if the given number already in the box
    int boxRowOffset = (rowIdx / 3) * BOX_SIZE;
    int boxColumnOffset = (colIdx / 3) * BOX_SIZE;
    for (int i = 0; i < BOX_SIZE; ++i) {
      for (int j = 0; j < BOARD_SIZE; ++j) {
        if (sudokuTable[boxRowOffset + i][boxColumnOffset + j] == actualNumber)
          return false;
      }
    }
    return true;
  }

  private void showResult() {
    for (int i = 0; i < BOARD_SIZE; i++) {
      if (i % 3 == 0)
        System.out.println(" ");
      for (int j = 0; j < BOARD_SIZE; j++) {
        if (j % 3 == 0)
          System.out.print(" ");
        System.out.println(sudokuTable[i][j] + " ");
      }
      System.out.println(" ");
    }
  }

}
