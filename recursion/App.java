package recursion;

public class App {
  public static void main(String[] args) {
    TowerOfHanoi toh = new TowerOfHanoi();
    toh.solveHanoi(3, 'A', 'B', 'C');
  }
}
