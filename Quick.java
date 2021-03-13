public class Quick {

  public static void quicksort(int[] data) {
    quicksortDutch(data, 0, data.length - 1);
  }

  public static void quicksort(int[] data, int s, int e) {
    if (s >= e) return;
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

  public static int partition(int[] arr, int start, int end) {
    int hold = arr[start];
    int medSwap = -1;

    if (arr[start] < arr[end]) {
      if (arr[end] < arr[(end + start) / 2]) medSwap = end;
      else medSwap = (end + start) / 2;
    }
    else {
      if (arr[start] < arr[(end + start) / 2]) medSwap = start;
      else medSwap = (end + start) / 2;
    }

    arr[start] = arr[medSwap];
    arr[medSwap] = hold;

    int point = start + 1;
    for (int i = start + 1; i <= end; i++) {
      if (arr[i] == arr[start] && Math.random() < 0.5) continue;
      if (arr[i] <= arr[start]) {
        hold = arr[point];
        arr[point] = arr[i];
        arr[i] = hold;
        point++;
      }
    }

    hold = arr[point - 1];
    arr[point - 1] = arr[start];
    arr[start] = hold;

    return point - 1;
  }



  public static void quicksortDutch(int[] data) {
    quicksortDutch(data, 0, data.length - 1);
  }
  
  public static void quicksortDutch(int[] data, int s, int e) {
    if (s >= e) return;
    if (s == e - 2) {
      int hold = -1;

      if (data[s] > data[s + 1]) {
        hold = data[s];
        data[s] = data[s + 1];
        data[s + 1] = hold;
      }
      if (data[s] > data[e]) {
        hold = data[s];
        data[s] = data[e];
        data[e] = hold;
      }
      if (data[s + 1] > data[e]) {
        hold = data[s + 1];
        data[s + 1] = data[e];
        data[e] = hold; 
      }
    }
    else if (s == e - 1) {
      int min = Integer.min(data[s], data[e]);
  
      data[e] = Integer.max(data[s], data[e]);
      data[s] = min;
    }
    else {
      int[] hold = partitionDutch(data, s, e);
      quicksortDutch(data, s, hold[0]);
      quicksortDutch(data, hold[1], e);
    }
  }
  
  public static int[] partitionDutch(int[] arr, int start, int end) {
    int midPt = start + 1;
    int endPt = -1;
    
    if (arr[start] < arr[end]) {
      if (arr[end] < arr[(end + start) / 2]) endPt = end;
      else endPt = (end + start) / 2;
    }
    else {
      if (arr[start] < arr[(end + start) / 2]) endPt = start;
      else endPt = (end + start) / 2;
    }
    boolean equals = false;
    
    int hold = arr[start];
    arr[start] = arr[endPt];
    arr[endPt] = hold;

    endPt = start + 1;
  
    for (int i = start + 1; i <= end; i++) {
      if (arr[i] < arr[start]) {
        hold = arr[midPt];
        arr[midPt] = arr[i];
        arr[i] = hold;
  
        if (equals) {
          hold = arr[endPt];
          arr[endPt] = arr[i];
          arr[i] = hold;
        }
  
        midPt++;
        endPt++;
      }
      else if (arr[i] == arr[start]) {
        hold = arr[endPt];
        arr[endPt] = arr[i];
        arr[i] = hold;
        
        endPt++;
        equals = true;
      }
    }
  
    hold = arr[midPt - 1];
    arr[midPt - 1] = arr[start];
    arr[start] = hold;
  
    return new int[] {midPt - 2, endPt};
  }
}