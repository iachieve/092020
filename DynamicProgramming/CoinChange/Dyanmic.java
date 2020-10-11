package DynamicProgramming.CoinChange;

public class Dyanmic {
  public void dynamicProgrammingCoinChange(int[] v, int M) {
    // rows as many as values/coins v + 1 (1: because we added 0 as base case)
    // columns as many as M/TotalAmount m+1 (1: because we added 0 as base case)
    int[][] dpTable = new int[v.length + 1][M + 1];
    // initialize the table
    for (int i = 0; i <= v.length; i++) { // rows based on coins/values
      dpTable[i][0] = 1; // first column is one, first column is 0, so we have one solution(zero)
    }

    for (int j = 1; j <=M; j++) { // iterating through column starting from second column
      dpTable[0][j] = 0;  // if the first row have 0 coin, so the columns will be zero
    }

    // O(v*m)
    for (int i = 1; i <= v.length; i++) {
      for (int j = 1; j <= M; j++) {
        
        if(v[i-1] <= j){ // if current coin value is less than the amount value
          dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j-v[i-1]]; // take the coin option
        }else{
          dpTable[i][j] = dpTable[i-1][j]; // don't take the coin option
        }
      }
    }
    System.out.println("solution: " + dpTable[v.length][M]);
  }
}
