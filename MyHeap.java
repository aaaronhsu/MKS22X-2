import java.util.*;
import java.io.*;

public class MyHeap {
  public static void pushDown(int[] data, int size, int index) {
    int a = index * 2 + 1;
    int b = index * 2 + 2;

    if (a >= size) {
      return;
    }
    else if (a > size) {
      // only one child node
      if (data[a] > data[index]) {
        // swap index with a
        int hold = data[index];
        data[index] = data[a];
        data[a] = hold;
        return;
      }
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
}