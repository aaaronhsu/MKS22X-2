import java.util.Arrays;

public class Driver {
  public static void main(String[] args) {
    int[] arr = {1, 2, 2, 2, 2, 2, 2, 5};
    System.out.println(Preliminary.partition(arr, 0, arr.length - 1));
    System.out.println(Arrays.toString(arr));
  }
}
