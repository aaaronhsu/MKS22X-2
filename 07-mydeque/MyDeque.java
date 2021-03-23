import java.util.*;

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

  public int size() {
    return size;
  }

  public void addFirst(E element) {
    resize();
    if (element == null) throw new NullPointerException();

    if (start == -1) {
      data[0] = element;
      start = 0;
      end = 0;
    }
    else if (start == 0) {
      data[data.length - 1] = element;
      start = data.length - 1;
    }
    else {
      data[start - 1] = element;
      start--;
    }

    size++;
  }

  public void addLast(E element) {
    resize();
    if (element == null) throw new NullPointerException();

    if (end == -1) {
      data[0] = element;
      start = 0;
      end = 0;
    }
    else if (end == data.length - 1) {
      data[0] = element;
      end = 0;
    }
    else {
      data[end + 1] = element;
      end++;
    }

    size++;
  }

  public E getFirst() {
    if (start == -1 || (start == end && data[start] == null)) throw new NoSuchElementException();
    return data[start];
  }

  public E getLast() {
    if (start == -1 || (start == end && data[start] == null)) throw new NoSuchElementException();
    return data[end];
  }

  public E removeFirst() {
    if (start == -1 || data[start] == null) throw new NoSuchElementException();
    E hold = data[start];
    data[start] = null;
    start++;
    if (start == data.length) start = 0;

    size--;
    return hold;
  }

  public E removeLast() {
    if (start == -1 || data[end] == null) throw new NoSuchElementException();
    E hold = data[end];
    data[end] = null;
    end--;
    if (end == -1) end = data.length - 1;

    size--;
    return hold;
  }

  public String toString() {
    if (start == -1) return "{}";

    String str = "{";

    int cur = start;
    boolean ele = false;

    while (data[cur] != null) {
      if (ele && cur == start) break;
      str += data[cur] + ", ";
      ele = true;
      cur++;
      if (cur == data.length) cur = 0;
    }

    if (ele) str = str.substring(0, str.length() - 2);
    str += "}";

    return str;
  }

  private void resize() {
    if (data.length == 0) {
      @SuppressWarnings("unchecked")
      E[] data = (E[]) new Object[16];
      start = -1;
      end = -1;
      size = 0;
      this.data = data;
    }
    else if (size == data.length) {
      @SuppressWarnings("unchecked")
      E[] hold = (E[]) new Object[data.length * 2];
      hold[0] = data[start];

      int index = 1;

      int i = start;
      while (index < data.length) {
        i++;
        if (i == data.length) i = 0;
        hold[index] = data[i];
        index++;
      }

      data = hold;
      start = 0;
      end = index - 1;
    }
  }
}
