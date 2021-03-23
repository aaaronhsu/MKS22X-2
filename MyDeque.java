import java.util.*;

public class MyDeque<E> {
  public E[] data;
  public int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque() {
    this(4);
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
    if (start == end && data[start] == null) throw new NoSuchElementException();
    return data[start];
  }

  public E getLast() {
    if (start == end && data[start] == null) throw new NoSuchElementException();
    return data[end];
  }

  public E removeFirst() {
    if (data[start] == null) throw new NoSuchElementException();
    E hold = data[start];
    data[start] = null;
    start++;
    if (start == data.length) start = 0;

    size--;
    return hold;
  }

  public E removeLast() {
    if (data[end] == null) throw new NoSuchElementException();
    E hold = data[end];
    data[end] = null;
    end--;
    if (end == -1) end = data.length - 1;

    size--;
    return hold;
  }

  public String toString() {
    if (start == -1) return "{}";

    StringBuilder sb = new StringBuilder();
    sb.append("{");
    int cur = start;
    boolean ele = false;

    while (data[cur] != null) {
      sb.append(data[cur] + ", ");
      ele = true;
      cur++;
      cur %= data.length;
    }

    if (ele) {
      sb.setLength(sb.length() - 2);
    }
    sb.append("}");

    return sb.toString();
  }

  private void resize() {
    if (size == data.length) {
      @SuppressWarnings("unchecked")
      E[] hold = (E[]) new Object[data.length * 2];
      hold[0] = data[start];

      int index = 1;
      for (int i = start + 1; i != start; i++) {
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
