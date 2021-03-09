import java.util.Arrays;

public class Driver {
  public static void main(String[] args) {
    int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    System.out.println(Preliminary.partition(arr, 0, arr.length - 1));
    System.out.println(Arrays.toString(arr));
  }
}
