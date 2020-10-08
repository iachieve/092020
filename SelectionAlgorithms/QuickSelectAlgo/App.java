package SelectionAlgorithms.QuickSelectAlgo;

public class App {
  public static void main(String[] args) {
    int[] nums = {1, 5, 4, 8, -2};
    QuickSelect2 quickSelect = new QuickSelect2(nums);
    System.out.println(quickSelect.select(2));
  }
}
