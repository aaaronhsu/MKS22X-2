import java.util.*;
import java.io.*;

public class Tester {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0};

    MyHeap.pushDown(arr, 7, 2);

    System.out.println(Arrays.toString(arr));
  }  
}
