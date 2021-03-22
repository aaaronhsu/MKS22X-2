public class Driver {
  public static void main(String[] args) {
    MyDeque<Integer> deq = new MyDeque<Integer>();

    deq.addFirst(3);
    deq.addFirst(2);
    deq.addFirst(1);
    deq.addFirst(56);
    deq.addLast(12);
    deq.addLast(13);
    deq.addLast(15);

    System.out.println(deq.size());
    System.out.println(deq);
  }
}
