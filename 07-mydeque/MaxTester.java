import java.util.*;
import java.io.*;
public class MaxTester {

    public static void main(String[] args) {
        int numtests = 10; // number of tests
        int upperbound = -1; // -1 if no upper bound, or make it the upper bound for integers
        int len = 10000; // number of elements added to the deque
        boolean fail = false;
        for (int seed = 0; seed < numtests; seed++) {
            LinkedList<Integer> dq = new LinkedList<Integer>();
            MyDeque<Integer> test = new MyDeque<Integer>(len);
            Random rng = new Random(seed);
            if (badExceptions(test)) fail=true;
            for (int i = 0; i < len; i++) {
                Integer add = (upperbound==-1) ? rng.nextInt() : rng.nextInt(upperbound);
                if (rng.nextBoolean()) {
                    dq.add(0, add);
                    test.addFirst(add);
                } else {
                    dq.add(add);
                    test.addLast(add);
                }
            }
            String correct, mine;
            for (int i = 0; i < len; i++) {
                if (fail) break;
                // test get methods
                if (dq.peekFirst() != test.getFirst()) fail=true;
                if (dq.peekLast() != test.getLast()) fail=true;
                // test size method
                if (dq.size() != test.size()) fail=true;
                // test either removeFirst or removeLast
                if (rng.nextBoolean()) {
                    if (dq.remove() != test.removeFirst()) fail=true;
                } else {
                    if (dq.removeLast() != test.removeLast()) fail=true;
                }
                // tests toString but only if size<1000 since this is a linear method
                if (test.size()<1000) {
                    correct = dq.toString();
                    mine = test.toString();
                    if (!sameString(correct, mine)) fail=true;
                }
                // tests exceptions
                if (badExceptions(test)) fail=true;
            }
            if (fail) {
                System.out.println("Failed on seed " + String.valueOf(seed));
                break;
            }
        }
        if (!fail) {
            System.out.println("Congrats!");
        }
    }

    public static boolean badExceptions(MyDeque<Integer> test) {
        boolean fail = false;
        if (test.size()<0) fail=true;
        if (test.size()==0) {
            try {
                test.removeFirst();
                fail=true;
            }
            catch (NoSuchElementException e) {}
            catch (RuntimeException e) {fail=true;}
            try {
                test.removeLast();
                fail=true;
            }
            catch (NoSuchElementException e) {}
            catch (RuntimeException e) {fail=true;}
            try {
                test.getFirst();
                fail=true;
            }
            catch (NoSuchElementException e) {}
            catch (RuntimeException e) {fail=true;}
            try {
                test.getLast();
                fail=true;
            }
            catch (NoSuchElementException e) {}
            catch (RuntimeException e) {fail=true;}
        }
        try {
            test.addFirst(null);
            fail=true;
        }
        catch (NullPointerException e) {}
        catch (RuntimeException e) {fail=true;}
        try {
            test.addLast(null);
            fail=true;
        }
        catch (NullPointerException e) {}
        catch (RuntimeException e) {fail=true;}
        return fail;
    }

    public static boolean sameString(String a, String b) {
        return a.substring(1, a.length()-1).equals(b.substring(1, b.length()-1));
    }

}
