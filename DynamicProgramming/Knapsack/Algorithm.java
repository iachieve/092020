package DynamicProgramming.Knapsack;

public class Algorithm {
  private int numOfItems;
  private int capacityOfKnapsack;
  private int[][] KnapsackTable;
  private int totalBenefit;
  private int[] weights;
  private int[] values;

  public Algorithm(int numOfItems, int capacityOfKnapsack, int[] weights, int[] values) {
    this.numOfItems = numOfItems;
    this.capacityOfKnapsack = capacityOfKnapsack;
    this.weights = weights;
    this.values = values;
    this.KnapsackTable = new int[numOfItems + 1][capacityOfKnapsack + 1];
  }

  public void solve() {
    // time complexity O(N*W)
    for (int i = 0; i < numOfItems; i++) {
      for (int w = 0; w < capacityOfKnapsack; w++) {
        int notTakingItem = KnapsackTable[i - 1][w];
        int takingItem = 0;
        if (weights[i] <= w) {
          takingItem = values[i] + KnapsackTable[i - 1][w - weights[i]];
        }
        KnapsackTable[i][w] = Math.max(notTakingItem, takingItem);
      }
    }
    totalBenefit = KnapsackTable[numOfItems][capacityOfKnapsack];
  }

  public void showResult() {
    System.out.println("Total Benefit: " + totalBenefit);
    for (int n = numOfItems, w = capacityOfKnapsack; n > 0; n--) {
      if(KnapsackTable[n][w] != 0 && KnapsackTable[n][w] != KnapsackTable[n-1][w]){
        System.out.println("we take item: #" + n);
        w = w - weights[n];
      }
    }
  }
}
