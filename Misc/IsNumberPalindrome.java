package Misc;

public class IsNumberPalindrome {
  public static void main(String[] args) {
    int n = 9234327;
    // validate negative numbers
    // if(n < 0) return false;

    // get the length
    long len = (int) Math.round(Math.log10(n)) + 1;

    // get the mask, facilitates getting the first digit from the right
    int mask = (int) Math.pow(10, len - 1);

    // iterate through half the n length, the mid point doesn't
    // matter in palindrome scenario
    // still considered O(n)
    for (int i = 0; i < (len / 2); i++) {

      // getting the last digit in the number % 10
      int lastDigit = n % 10;
      System.out.println("last digit: " + lastDigit);

      // getting the first digit in the number
      double firstDigit = Math.floor(n / mask);
      System.out.println("first digit: " + firstDigit);

    }
    System.out.println("Len: " + len);
    System.out.println("mask: " + mask);

  }
}
