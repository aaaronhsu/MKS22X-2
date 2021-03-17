import java.util.*;
import java.io.*;

public class Merge {
  
  static void mergesort(int[] data) {
    mergesort(data, data.clone(), 0, data.length - 1);
  }

  static void mergesort(int[] data, int[] temp, int s, int e) {
    if (s >= e) return;
    if (s + 1 == e) {
      data[s] = Integer.min(temp[s], temp[e]);
      data[e] = Integer.max(temp[s], temp[e]);
      return;
    }

    int mid = (s + e) / 2 + (s + e) % 2;

    mergesort(temp, data, s, mid - 1);
    mergesort(temp, data, mid, e);

    int p1 = s;
    int p2 = mid;

    for (int i = s; i <= e; i++) {
      // fill all with p2
      if (p1 == mid) {
        while (p2 <= e) {
          data[i] = temp[p2];

          p2++;
          i++;
        }

        break;
      }
      // fill all with p1
      else if (p2 > e) {
        while (p1 < mid) {
          data[i] = temp[p1];

          p1++;
          i++;
        }

        break;
      }

      if (temp[p1] < temp[p2]) {
        data[i] = temp[p1];
        p1++;
      }
      else {
        data[i] = temp[p2];
        p2++;
      }
    }
  }
}
