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

  public int size() {
    return size;
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("{");

    if (start > 0) {
      for (int i = start - 1; i > 0; i--) str.append(data[i] + ", ");
      if (end == data.length - 1) {
        str.append(data[0] + "}");
        return str.toString();
      }
      else str.append(data[0]);
    }

    if (end < data.length - 1) {
      for (int i = data.length - 1; end + 1 < i; i--) str.append(data[i] + ", ");
      str.append(data[end + 1] + "}");
      return str.toString();
    }

    str.append("}");
    return str.toString();
  }
}
