package Misc.EggDropingProblem;

public class App {



  public static void main(String[] args) {
    DroppingEggSolution sol = new DroppingEggSolution();
    System.out.println("minimum number of drops to find the critical floor: " + 
                          sol.solve(2, 10));
  }
}
