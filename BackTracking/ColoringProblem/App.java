package BackTracking.ColoringProblem;

public class App {

 public static void main(String[] args) {
    int[][] graphMatrix = new int[][]{
    {0, 1, 0, 1, 0},
    {1, 0, 1, 1, 0},
    {0, 1, 0, 1, 0},
    {1, 1, 1, 0, 1},
    {0, 0, 0, 1, 0}
  };
  Algorithm algo = new Algorithm(graphMatrix, 4);
  algo.solve();
 }
}
