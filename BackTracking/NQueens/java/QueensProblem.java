package BackTracking.NQueens.java;

public class QueensProblem {
  private int[][] chessTable;
  private int numOfQueens;

  public QueensProblem(int numOfQueens) {
    this.chessTable = new int[numOfQueens][numOfQueens];
    this.numOfQueens = numOfQueens;
  }

  public void solve() {
    if (setQueens(0)) {
      printQueens();
    } else {
      System.out.println("there is no solution");
    }
  }

  private boolean setQueens(int colIdx) {
    if (colIdx == numOfQueens) return true;

    for (int rowIdx = 0; rowIdx < numOfQueens; ++rowIdx) {
      if (isPlaceValid(rowIdx, colIdx)) {
        chessTable[rowIdx][colIdx] = 1;
        if (setQueens(colIdx + 1)) {
          return true;
        }
        // backtracking
        chessTable[rowIdx][colIdx] = 0;
      }
    }
    return false;
  }

  private boolean isPlaceValid(int rowIdx, int colIdx) {
    // horizontal
    for (int i = 0; i < colIdx; i++) {
      if (chessTable[rowIdx][i] == 1) {
        return false;
      }
    }
    // left diagonal
    for (int i = rowIdx, j = colIdx; i >= 0 && j >= 0; i--, j--) {
      if (chessTable[i][j] == 1) {
        return false;
      }
    }
    //
    for (int i = rowIdx, j = colIdx; i < chessTable.length && j >= 0; i++, j--) {
      if (chessTable[i][j] == 1) {
        return false;
      }
    }
    return true;
  }

  private void printQueens() {
    for (int row = 0; row < chessTable.length; row++) {
      for (int col = 0; col < chessTable.length; col++) {
        if (chessTable[row][col] == 1) {
          System.out.print(" * ");
        } else {
          System.out.print(" - ");
        }
      }
      System.out.println();
    }
  }
}
