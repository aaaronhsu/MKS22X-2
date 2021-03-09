public class Preliminary {
  public static int partition(int[] data, int start, int end) {
    int hold = data[start];
    int randSwap = (int) (Math.random() * ((end + 1) - start) + start);
    data[start] = data[randSwap];
    data[randSwap] = hold;

    int point = start + 1;
    for (int i = start + 1; i < end + 1; i++) {
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
