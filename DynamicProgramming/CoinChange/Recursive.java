package DynamicProgramming.CoinChange;

// exponential running time O(n^2)
public class Recursive {
  /**
   * 
   * @param M: total amount
   * @param v: coins
   * @param idx: index
   * @return
   */
  public int naiveCoinChange(int M, int[] v, int idx){
    if(M < 0) return 0;
    if(M == 0) return 1;
    if(v.length == idx){ // we have considered all options
      return 0;
    }

    //                      coin included
    return naiveCoinChange(M - v[idx], v, idx) + naiveCoinChange(M, v, idx+1);

  }

}
