import java.util.Arrays;

public class Driver {
  public static void main(String[] args) {
    MyDeque<Integer> deq = new MyDeque<Integer>();

    
    deq.addFirst(123);
    deq.addFirst(123);
    deq.addFirst(123);
    deq.addFirst(123);
    deq.addFirst(123);
    deq.addFirst(123);
    deq.addFirst(123);
    deq.addFirst(123);
    deq.addFirst(123);
    deq.addFirst(123);
    deq.addFirst(123);
    deq.addFirst(123);
    deq.removeLast();
    deq.removeLast();
    deq.removeLast();
    deq.removeLast();
    deq.removeLast();
    deq.removeLast();
    deq.removeLast();
    deq.removeLast();
    deq.removeLast();

    System.out.println(deq.size());
    System.out.println(deq);
    System.out.println(Arrays.toString(deq.data));
  }
}
