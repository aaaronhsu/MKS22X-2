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
    end = -1;
    size = 0; 
  }

  public void addFirst(E element) {
    if (element == null) throw new NullPointerException();

    if (start == -1) {
      data[0] = element;
      start = data.length - 1;
      end = 1;
    }
    else if (start == 0) {
      data[data.length - 1] = element;
      start = data.length - 1;
    }
    else {
      data[start - 1] = element;
      start--;
    }


  }

  public void addLast(E element) {
    if (element == null) throw new NullPointerException();

    if (end == -1) {
      data[0] = element;
      start = data.length - 1;
      end = 1;
    }
    else if (end == data.length - 1) {
      data[0] = element;
      end = 0;
    }
    else {
      data[end + 1] = element;
      end++;
    }
  }
}
