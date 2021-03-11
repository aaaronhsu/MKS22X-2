public class Quick {
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
