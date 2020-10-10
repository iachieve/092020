package Misc;

public class IntegerReversion {

  /*
   * 
   * Interview Question #2:
   * 
   * Our task is to design an efficient algorithm to reverse a given integer. For
   * example if the input of the algorithm is 1234 then the output should be 4321.
   
   */
  private static int reverseNumber(int n){
    int result = 0;
    while(n > 0){
      int remainder = n % 10;
      n /= 10;
      result = result * 10 + remainder;
    }
    return result;
  }
  public static void main(String[] args) {
    System.out.println(reverseNumber(1234));
  }
}
