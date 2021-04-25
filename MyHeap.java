import java.util.*;
import java.io.*;

public class MyHeap {
  public static void pushDown(int[] data, int size, int index) {
    int a = index * 2 + 1;
    int b = index * 2 + 2;

    if (a >= size) {
      return;
    }
    else if (a == size - 1) {
      // only one child node
      if (data[a] > data[index]) {
        // swap index with a
        int hold = data[index];
        data[index] = data[a];
        data[a] = hold;
      }
      return;
    }

    if (data[b] > data[a]) {
      if (data[b] > data[index]) {
        // swap index with b
        int hold = data[index];
        data[index] = data[b];
        data[b] = hold;

        pushDown(data, size, b);
      }
    }
    else {
      if (data[a] > data[index]) {
        // swap index with a
        int hold = data[index];
        data[index] = data[a];
        data[a] = hold;

        pushDown(data, size, a);
      }
    }
  }

  private static void buildHeap(int[] data) {
    for (int i = data.length - 1; i >= 0; i--) {
      pushDown(data, data.length, i);
    }
  }

  private static void remove(int[] data, int size) {
    int hold = data[0];
    data[0] = data[size];
    data[size] = hold;
    
    pushDown(data, size - 1, 0);
  }

  public static void heapsort(int[] data) {
    buildHeap(data);

    System.out.println(Arrays.toString(data));

    for (int i = data.length - 1; i >= 0; i--) {
      remove(data, i);
    }
  }
}