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
    end = 1;
    size = 0; 
  }

  public int size() {
    if (end > start) return end - start - 1;
    return end + (data.length - (start + 1));
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("{");

    if (end > start) {
      if (end - start == 1) {
        str.append("}");
        return str.toString();
      }
      
      for (int i = start + 1; i < end - 1; i++) str.append(data[i] + ", ");
      str.append(data[end - 1] + "}");
    }
    else {
      if (start != data.length - 1) {

        for (int i = start + 1; i < data.length - 1; i++) str.append(data[i] + ", ");
        if (end != 0) {
          str.append(data[data.length - 1] + ", ");
        }
        else {
          str.append(data[data.length - 1] + "}");
          return str.toString();
        }
      }

      for (int i = 0; i < end - 1; i++) str.append(data[i] + ", ");
      
      str.append(data[end - 1] + "}");
    }

    return str.toString();
  }

  public void addFirst(E element) {
    if (element == null) throw new NullPointerException();

    if (start == end || end - start == 1) resize();

    data[start] = element;
    start--;
    if (start < 0) start = data.length - 1;
  }

  public void addLast(E element) {
    if (element == null) throw new NullPointerException();

    if (start == end || end - start == 1) resize();

    data[end] = element;
    end = (end + 1) % data.length;
  }

  public E getFirst() {
    if (start > end) {
      if (start == data.length - 1) {
        if (data[0] == null) throw new NoSuchElementException();
        return data[0];
      }

      if (data[start + 1] == null) throw new NoSuchElementException();
      return data[start + 1];
    }
    if (start == 0) return null;

    if (data[start - 1] == null) throw new NoSuchElementException();
    return data[start - 1];
  }

  public E getLast() {
    if (end < start) {
      if (end == 0) {
        if (data[data.length - 1] == null) throw new NoSuchElementException();
        return data[data.length - 1];
      }

      if (data[end - 1] == null) throw new NoSuchElementException();
      return data[end - 1];
    }

    if (data[end - 1] == null) throw new NoSuchElementException();
    return data[end - 1];
  }

  public E removeFirst() {
    if (start > end) {
      if (start == data.length - 1) {
        E hold = data[0];
        if (hold == null) throw new NoSuchElementException();

        data[0] = null;
        start = 0;
        return hold;
      }

      E hold = data[start + 1];
      if (hold == null) throw new NoSuchElementException();

      data[start + 1] = null;
      start++;
      return hold;
    }
    if (start == 0) return null;

    E hold = data[start - 1];
    if (hold == null) throw new NoSuchElementException();

    data[start - 1] = null;
    start--;
    return hold;
  }

  public E removeLast() {
    if (end <= start) {
      if (end == 0) {
        E hold = data[data.length - 1];
        if (hold == null) throw new NoSuchElementException();

        data[data.length - 1] = null;
        end = data.length - 1;
        return hold;
      }
    }

    E hold = data[end - 1];
    if (hold == null) throw new NoSuchElementException();

    data[end - 1] = null;
    end--;
    return hold;
  }

  private void resize() {
    @SuppressWarnings("unchecked")
    E[] hold = (E[]) new Object[data.length * 2];

    if (end > start) {
      for (int i = start + 1; i < end; i++) {
        hold[i] = data[i]; 
      }
    }
    else {
      int count = 0;
      for (int i = start + 1; i < data.length; i++) {
        hold[count] = data[i];
        count++;
      }

      for (int i = 0; i < end; i++) {
        hold[count] = data[i];
        count++;
      }

      end += (data.length - (start + 1));
      start = hold.length - 1;
    }

    data = hold;
  }
}
