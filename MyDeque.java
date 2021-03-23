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
    start = -1;
    end = 0;
    size = 0; 
  }

  public void addFirst(E element) {
    if (element == null) throw new NullPointerException();
    resize();

    if (start == -1) {
      start = 0;
      end = 0;
    }
    else if (start == 0) start = size - 1;
    else start--;

    data[start] = element;
  }
}
