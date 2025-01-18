package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        BuggyAList<Integer> buggy = new BuggyAList<>();
        AListNoResizing<Integer> noResize = new AListNoResizing<>();
        for (int i = 4; i <= 7; i += 1){
            buggy.addLast(i);
            noResize.addLast(i);
            assertEquals(buggy.size(), noResize.size());
        }
        for (int j = 4; j <= 7; j += 1){
            buggy.removeLast();
            noResize.removeLast();
            assertEquals(buggy.size(), noResize.size());
        }
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> M = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
//            int operationNumber = StdRandom.uniform(0, 2);
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                M.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeM = M.size();
//                System.out.println("size: " + size + ", sizeM: " + sizeM);
                assertEquals(size, sizeM);
            } else if (operationNumber == 2 & L.size() != 0) {
                // getLast
                int last = L.getLast();
                int lastM = M.getLast();
//                System.out.println("getLast: " + last + ", getLastM: " + lastM);
                assertEquals(last, lastM);
            } else if (operationNumber == 3 & L.size() != 0) {
                int last = L.removeLast();
                int lastM = M.removeLast();
//                System.out.println("removeLast()");
                assertEquals(last, lastM);
            }
        }
    }
}
