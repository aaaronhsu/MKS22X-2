public class Driver {
  public static void main(String[] args) {
    MyDeque<Integer> deq = new MyDeque<Integer>();

    deq.start = 0;
    deq.end = 5;

    Integer[] arr = new Integer[10];


    arr[1] = 2;
    arr[2] = 3;
    arr[3] = 4;
    arr[4] = 5;
    // arr[9] = 0;

    deq.data = arr;

    System.out.println(deq.size());
    System.out.println(deq);
  }
}
