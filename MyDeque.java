public class MyDeque<E> {
  private E[] data;
  public int size, start, end;

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
    if (end > start) return end - start - 1;
    return end + (data.length - start);
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("{");

    if (end > start) {
      for (int i = start + 1; i < end - 1; i++) str.append(data[i] + ", ");
      str.append(data[end - 1] + "}");
    }
    else {
      for (int i = start + 1; i < data.length - 1; i++) str.append(data[i] + ", ");
      if (end != 0) {
        str.append(data[data.length - 1] + ", ");
      }
      else {
        str.append(data[data.length - 1] + "}");
        return str.toString();
      }

      for (int i = 0; i < end - 1; i++) str.append(data[i] + ", ");
      
      str.append(data[end - 1] + "}");
    }

    return str.toString();
  }
}
