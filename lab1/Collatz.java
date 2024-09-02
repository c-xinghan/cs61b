/** Class that prints the Collatz sequence starting from a given number.
 *  @author YOUR NAME HERE
 */
public class Collatz {

//    /** Buggy implementation of nextNumber! */
//    public static int nextNumber(int n) {
//        if (n  == 128) {
//            return 1;
//        } else if (n == 5) {
//            return 3 * n + 1;
//        } else {
//            return n * 2;
//        }
//    }

    /** Fixed implementation of nextNumber
     * if n is even, the next number is n/2
     * if n is odd, the next number is 3n + 1
     * if n is 1, the sequence is over.
     */
    public static int nextNumber(int n) {
        if (n == 1){
            return n;
        } else if (n % 2 == 0) {
            return n / 2;
        } else {
            return 3 * n + 1;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

