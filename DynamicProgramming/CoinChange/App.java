package DynamicProgramming.CoinChange;

public class App {
  public static void main(String[] args){
    int[] v = { 1, 2, 3 };
    int M = 4;
    System.out.println(new Recursive().naiveCoinChange(M, v, 0));
    new Dyanmic().dynamicProgrammingCoinChange(v, M);
  }
}
