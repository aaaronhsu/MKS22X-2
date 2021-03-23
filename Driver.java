public class Driver {
  public static void main(String[] args) {
    MyDeque<Integer> deq = new MyDeque<Integer>();

    deq.addFirst(3);
    System.out.println(deq.removeLast());
    // System.out.println(deq.removeFirst());


    System.out.println(deq.size());
    System.out.println(deq);
  }
}
