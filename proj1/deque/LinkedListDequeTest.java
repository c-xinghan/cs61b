package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

//        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

//        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

//        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

//        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

//        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }

    @Test
    /* Checks whether get(i) returns null when a Node at position i does not exist */
    public void nonExistentGetTest() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        assertNull(lld.get(0));
        assertNull(lld.get(1));
        for (int i = 1; i < 4; i++) {
            lld.addLast(i);
        }
        lld.printDeque();
        assertNull(lld.get(3));
    }

    @Test
    /* Checks whether getRecursive(i) returns null when a Node at position i does not exist */
    public void nonExistentRecursiveGetTest() {
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        assertNull(lld.getRecursive(0));
        assertNull(lld.getRecursive(1));
        for (int i = 1; i < 4; i++) {
            lld.addLast(i);
        }
        lld.printDeque();
        assertNull(lld.getRecursive(3));
    }

    @Test
    public void randomizedTest(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        ArrayDeque<Integer> M = new ArrayDeque<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 5);
            if (operationNumber == 0 & L.size() < 8) {
//            replace with this after Checkpoint
//            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                M.addLast(randVal);
                assertEquals(L.get(L.size() - 1), M.get(M.size() - 1));
            } else if (operationNumber == 1 & L.size() < 8) {
//            replace with this after Checkpoint
//            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                L.addFirst(randVal);
                M.addFirst(randVal);
                assertEquals(L.get(0), M.get(0));
            } else if (operationNumber == 2) {
                int size = L.size();
                int sizeM = M.size();
                assertEquals(size, sizeM);
            } else if (operationNumber == 3) {
                if (!L.isEmpty()) {
                    int randVal = StdRandom.uniform(0, L.size());
                    int random = L.get(randVal);
                    int randomM = M.get(randVal);
                    assertEquals(random, randomM);
                } else {
                    assertNull(L.get(0));
                    assertNull(M.get(0));
                }
            } else if (operationNumber == 4) {
                if (!L.isEmpty()) {
                    int last = L.removeLast();
                    int lastM = M.removeLast();
                    assertEquals(last, lastM);
                } else {
                    assertNull(L.removeLast());
                    assertNull(M.removeLast());
                }
            } else if (operationNumber == 5) {
                if (!L.isEmpty()) {
                    int last = L.removeFirst();
                    int lastM = M.removeFirst();
                    assertEquals(last, lastM);
                } else {
                    assertNull(L.removeFirst());
                    assertNull(M.removeFirst());
                }
            }
        }
    }
}
