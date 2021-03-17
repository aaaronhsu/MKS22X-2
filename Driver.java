import java.util.*;
import java.io.*;

public class Driver {
  public static void main(String[] args) {
    

    int[] arr = {4, 7, 2, 6, 5, 9, 3, 8};

    Merge.mergesort(arr);

    System.out.println(Arrays.toString(arr));
  }  
}
