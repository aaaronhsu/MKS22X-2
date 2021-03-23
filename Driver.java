public class Driver {
  public static void main(String[] args) {
    MyDeque<Integer> deq = new MyDeque<Integer>();

    deq.addFirst(3);
    System.out.println(deq.getLast());
    deq.addFirst(6);
    deq.addFirst(23);
    deq.addFirst(7);

    deq.addLast(10);
    System.out.println(deq.getFirst());
    deq.addLast(9);
    deq.addLast(8);
    deq.addLast(7);


    System.out.println(deq.size());
    System.out.println(deq);
  }
}
