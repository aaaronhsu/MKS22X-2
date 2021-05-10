import java.util.*;
import java.io.*;

public class MyHeap {

  private static void swap(int[] data, int a, int b) {
    int hold = data[a];
    data[a] = data[b];
    data[b] = hold;
  }

  private static void pushDown(int[] data, int size, int index) {
    int a = index * 2 + 1;
    int b = index * 2 + 2;

    if (a >= size) return;
    else if (a == size - 1) {
      // only one child node
      if (data[a] > data[index]) swap(data, a, index);
      return;
    }

    if (data[b] > data[a]) {
      if (data[b] > data[index]) {
        swap(data, b, index);
        pushDown(data, size, b);
      }
    }
    else {
      if (data[a] > data[index]) {
        swap(data, a, index);
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
    swap(data, 0, size);
    pushDown(data, size, 0);
  }

  public static void heapsort(int[] data) {
    buildHeap(data);

    for (int i = data.length - 1; i >= 0; i--) {
      remove(data, i);
    }
  }
}