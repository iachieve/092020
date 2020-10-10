package Misc;

public class Palindrome {
  public static void main(String[] args) {
    System.out.println(palindrome1("madam"));
  }

  public static boolean palindrome1(String s) {
    String reversed = "";
    int length = s.length();

    for (int i = 0; i < length; i++) {
      reversed = reversed + s.charAt(length - i - 1);
    }

    if (s.equals(reversed))
      return true;

    return false;

  }

  /**
   * Interview Question #1
   * 
   * "A palindrome is a string that reads the same forward and backward"
   * 
   * For example: radar or madam
   * 
   * Our task is to design an optimal algorithm for checking whether a given
   * string is palindrome or not!
   */
  public static boolean palindrome2(String s) {
    int i = 0;
    int j = s.length() - 1;
    int k = (i + j) / 2;
    for (int idx = i; idx < k; idx++) {
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else {
        return false;
      }
    }
    return true;
  }
}
