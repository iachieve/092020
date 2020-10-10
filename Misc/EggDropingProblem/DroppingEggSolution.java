package Misc.EggDropingProblem;

// https://www.youtube.com/watch?v=iOaRjDT0vjc

public class DroppingEggSolution {

  /**
   * Interview Question #3:
   * 
   * The problem itself is that there are N number of eggs and building which has
   * M floors. Write an algorithm to find
   * 
   * the minimum number of drops is required to know the floor from which if egg
   * is dropped, it will break.
   * 
   * (usually N=2 and M=100)
   * 
   * ************************************************* *
   * ************************************************* FIND LEAST AMOUNT OF EGG
   * DROPS ... TO GUARANTEE THAT I FIND THE PIVOTAL FLOOR WHERE RIGHT BELOW IT IF
   * I DROP THE EGG IT WON'T BREAK AND RIGHT ABOVE IT IT WILL BREAK
   * 
   * INPUT: EGGS, FLOORS OUTPUT: LEAST AMOUNT OF EGGS TO ENSURE THE PIVOTAL FLOOR
   * IS FOUND
   ************************************************
   *************************************************
   * 
   * assumptions: 1) an egg that does not break can be reused 2) if an egg breaks
   * when dropped from a given floor then it will break from any higher floor 3)
   * if an egg does not break when dropped from a given floor then it will not
   * break if dropped from any lower floors
   * 
   * simplified version: If we have just a single egg we have no other option but
   * to try the floors on a one-by-one basis: we end up with a O(M) linear running
   * time algo
   * 
   * Many Eggs Problem: If we have lots ot eggs(lets suppose infinite number of
   * eggs) then we can use binary search to find the critical floor -> we go to
   * floor 50 and drop an egg -> the outcome of this drop instantly cuts out
   * problem into half (very similar to binary search or binary search trees) ->
   * the number of drops to find the critical floor is log2 100~7
   * 
   * We are after the worst-case scenario because iin best-case we may find the
   * critical floor with a few drops
   * 
   * Two Eggs Problem (100 floor) This is a special case of the egg dropping
   * problem where er have just 2 eggs ~ we have too few eggs to make binary
   * search in this case -> we drop the first egg from floor n: if it breaks then
   * we consider all the floors below one-by-one otherwise we jump to floor 2n
   * then 3n -> reducing the worst case means making all cases take the same
   * number of drops
   * 
   * Main Idea: When considering the lower floors we have more tries... we need a
   * one-by-one strategy but when we get higher up the building we have used drop
   * chances to get there
   * 
   * let's suppose we drop the first egg from floor n -> if it breaks we can do a
   * linear search through the previous n-1 floors -> if egg does not break then
   * we jump up n floors... but we should take the previous drops into
   * consideration Thats why jump up n-1 floors instead of n. In the next
   * iterations we jump n-2 floors and so on Finally we consider all the floors so
   * we keep reducing the steps n + (n-1) + (n-2) + (n-3) .... 1 = 100 n(n+1) / 2
   * = 100 n = 13.7
   * 
   * Solution: we can solve the problem with recursion but it is inefficient
   * because there are overlapping sub-problems: this is why we can use dynamic
   * programming -> we will store (memoize) the sub-solutions in a 2D array -> we
   * can use the following formula If we have n eggs and m is the number of floors
   * then there are 2 possible outcomes: 1) If the egg breaks after dropping from
   * floor x then we have to check floors below with the remaining eggs ~ problem
   * reduces to n-1 eggs and x-1 floors 2) If egg does not break after dropping
   * from floor x then we have to check the floors above: so we have n eggs and
   * m-x floors to check
   * 
   * we after the minimum of egg drops in worst-case scenario min { max(drop(n-1,
   * x-1), drop(n,m-x))} min: because we want to minimize the number of drops max:
   * because we are dealing with worst-case scenario 1st n: egg breaks after
   * dropping from floor x 2nd n: egg does not break after dropping from floor x
   */

  public int solve(int eggs, int floors) {
    int[][] dpTable = new int[eggs + 1][floors + 1];
    // the first columns is initialized with 1s
    // first column values are 1
    dpTable[0][0] = 1;
    dpTable[1][0] = 1;
    // the first row (linear search)
    for (int i = 0; i < floors; i++)
      dpTable[1][i] = i;
    // row is the index for the eggs - col is the index for the floors
    for (int row = 2; row <= eggs; row++) {
      for (int col = 1; col <= floors; col++) {
        dpTable[row][col] = Integer.MAX_VALUE;
        // check dropping the eggs from 1 to the current floor col
        // NOTE: we can reuse the sub-solutions from the table !!!
        for (int x = 1; x <= col; x++) {
          // use max because of worst-case scenario
          // add one to include the current drop (+1)
          int maxDrops = 1 + Math.max(dpTable[row - 1][x - 1], dpTable[row][col - x]);
          // this is taking the minimum (because we are after the minimum number of drops)
          if (maxDrops < dpTable[row][col]) dpTable[row][col] = maxDrops;
          
        }
      }
    }
    print(dpTable);
    // the last item in the table contains the minimum number of drops
    return dpTable[eggs][floors];
  }

  private void print(int[][] dpTable) {
    System.out.println("========================");
    for (int i = 0; i < dpTable.length; i++) {
      for (int j = 0; j < dpTable[i].length; j++) {
        System.out.print("  " + dpTable[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("========================");
  }
}
