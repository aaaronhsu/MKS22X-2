import java.util.NoSuchElementException;

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
      else str.append(data[0] + ", ");
    }

    if (end < data.length - 1) {
      for (int i = data.length - 1; end + 1 < i; i--) str.append(data[i] + ", ");
      str.append(data[end + 1] + "}");
      return str.toString();
    }

    str.append("}");
    return str.toString();
  }

  public void addFirst(E element) {
    if (element == null) throw new NullPointerException();
    if (start == end) resize();

    data[start] = element;
    size++;
    start++;
  }

  public void addLast(E element) {
    if (element == null) throw new NullPointerException();
    if (start == end) resize();

    data[end] = element;
    size++;
    end--;
  }

  public E getFirst() {
    if (start == 0) {
      if (end == data.length - 1) throw new NoSuchElementException();
      return data[data.length - 1];
    }
    return data[start - 1];
  }

  public E getLast() {
    if (end == data.length - 1) {
      if (start == 0) throw new NoSuchElementException();
      return data[0];
    }
    return data[end + 1];
  }

  public E removeFirst() {
    if (start == 0) {
      if (end == data.length - 1) throw new NoSuchElementException();

      E hold = data[data.length - 1];
      data[data.length - 1] = null;
      size--;
      end++;
      return hold;
    }
    
    E hold = data[start - 1];
    data[start - 1] = null;
    size--;
    start--;
    return hold;
  }


  private void resize() {
    @SuppressWarnings("unchecked")
    E[] hold = (E[]) new Object[data.length * 2];

    for (int i = 0; i < start; i++) {
      hold[i] = data[i];
    }

    for (int i = 0; i < (data.length - 1) - end; i++) {
      hold[hold.length - (i + 1)] = data[data.length - (i + 1)];
    }

    end = hold.length - (data.length - end);

    data = hold;
  }
}
