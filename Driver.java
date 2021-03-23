public class Driver {
  public static void main(String[] args) {
    MyDeque<Integer> deq = new MyDeque<Integer>();

    int n = 100000000;
    for (int i = 0; i < n; i++) {
      deq.addFirst(i);
      deq.addLast(i - 1);
      deq.removeFirst();
    }

    System.out.println(deq.size());
  }
}
