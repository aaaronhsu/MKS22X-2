public class MyDeque<E> {
  public E[] data;
  public int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque() {
    this(16);
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int n) {
    data = (E[]) new Object[n];
    start = 0;
    end = data.length - 1;
    size = 0; 
  }

  
}
