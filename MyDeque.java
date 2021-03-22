public class MyDeque<E> {
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[]) new Object[10];
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int n) {
    data = (E[]) new Object[n];
  }

  
}
