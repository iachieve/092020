package DynamicProgramming.Knapsack;

public class App {
  public static void main(String[] args) {
    int numOfItems = 3;
    int capacityOfKnapsack = 5;
    int[] weightsOfItems = new int[numOfItems + 1];
    weightsOfItems[1] = 4;
    weightsOfItems[2] = 2;
    weightsOfItems[3] = 3;

    int[] profitOfItems = new int[numOfItems + 1];
    profitOfItems[1] = 10;
    profitOfItems[2] = 4;
    profitOfItems[3] = 7;

    Algorithm algo = new Algorithm(numOfItems, capacityOfKnapsack, weightsOfItems, profitOfItems);
    algo.solve();
    algo.showResult();
  }
}
