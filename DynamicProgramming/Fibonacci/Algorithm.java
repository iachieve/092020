package DynamicProgramming.Fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Algorithm {
  private static Map<Integer,Integer> memoizeTable = new HashMap<>();

  public static void main(String[] args) {
    System.out.println("========================");
    int naiveSol = naiveFibonacci(5);
    System.out.println("naive solution:" + naiveSol);
    int dynamicSol = dynamicSolution(5);
    System.out.println("dynamic solution:" + dynamicSol);

    System.out.println(memoizeTable);
  }
  
  private static int dynamicSolution(int n){
    memoizeTable.put(0, 0);
    memoizeTable.put(1, 1);
    if(memoizeTable.containsKey(n)) return memoizeTable.get(n);
    memoizeTable.put(n-1, dynamicSolution(n - 1));
    memoizeTable.put(n-2, dynamicSolution(n - 2));
    int calculatedNumber = memoizeTable.get(n-1) + memoizeTable.get(n - 2);
    return calculatedNumber;
  }

  private static int naiveFibonacci(int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;
    return naiveFibonacci(n - 1) + naiveFibonacci(n - 2);
  }
}