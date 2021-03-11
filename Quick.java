public class Quick {

  public static void quicksort(int[] data) {
    quicksort(data, 0, data.length - 1);
  }

  public static void quicksort(int[] data, int s, int e) {
    if (e - s <= 1) return;
    int hold = partition(data, s, e);
    quicksort(data, s, hold - 1);
    quicksort(data, hold + 1, e);
  }

  public static int quickselect(int[] data, int k) {
    return quickselect(data, k, 0, data.length - 1);
  }

  public static int quickselect(int[] data, int k, int s, int e) {
    int hold = partition(data, s, e);
    if (hold == k) return data[k];
    if (hold > k) return quickselect(data, k, s, hold - 1);
    return quickselect(data, k, hold + 1, e);
  }

  public static int partition(int[] data, int start, int end) {
    int hold = data[start];
    int medSwap = -1;

    if (data[start] < data[end]) {
      if (data[end] < data[(end + start) / 2]) medSwap = end;
      else medSwap = (end + start) / 2;
    }
    else {
      if (data[start] < data[(end + start) / 2]) medSwap = start;
      else medSwap = (end + start) / 2;
    }

    data[start] = data[medSwap];
    data[medSwap] = hold;

    int point = start + 1;
    for (int i = start + 1; i < end + 1; i++) {
      if (data[i] == data[start] && Math.random() < 0.5) continue;
      if (data[i] <= data[start]) {
        hold = data[point];
        data[point] = data[i];
        data[i] = hold;
        point++;
      }
    }

    hold = data[point - 1];
    data[point - 1] = data[start];
    data[start] = hold;

    return point - 1;
  }
}
