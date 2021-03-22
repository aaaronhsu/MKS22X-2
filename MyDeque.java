public class MyDeque<E> {
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[]) new Object[10];
    start = 0;
    end = 0;
    size = 0; 
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int n) {
    data = (E[]) new Object[n];
    start = 0;
    end = 0;
    size = 0; 
  }

  public int size() {
    if (end > start) return end - start + 1;
    return end + (data.length - start) + 1;
  }
}
