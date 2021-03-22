public class Driver {
  public static void main(String[] args) {
    MyDeque<Integer> deq = new MyDeque<Integer>();

    deq.start = 3;
    deq.end = 9;

    System.out.println(deq.size());
  }
}
