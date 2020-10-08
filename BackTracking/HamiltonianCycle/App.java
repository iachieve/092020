package BackTracking.HamiltonianCycle;

public class App {
  public static void main(String[] args) {
    int[][] adjacentMatrix = {
      {0, 1, 1, 1, 0, 0},
      {1, 0, 1, 0, 1, 0},
      {1, 1, 1, 1, 0, 1},
      {0, 1, 0, 0, 0, 1 },
      {0, 1, 1, 1, 1, 1}
    };
    HamiltonianCycle cycle = new HamiltonianCycle(adjacentMatrix);
    cycle.solve();
  }
}
