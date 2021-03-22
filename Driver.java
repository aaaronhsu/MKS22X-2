public class Driver {
  public static void main(String[] args) {
    MyDeque<Integer> deq = new MyDeque<Integer>();

    deq.addFirst(3);
    deq.removeLast();
    deq.addFirst(3);
    deq.removeLast();
    deq.addFirst(3);
    deq.removeLast();
    deq.addFirst(3);
    deq.removeLast();
    deq.addFirst(3);
    deq.removeLast();

    System.out.println(deq.size());
    System.out.println(deq);
  }
}
