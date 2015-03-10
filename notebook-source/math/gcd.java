import java.util.*;

class gcd{

/**
 * Greatest common denominator using euclids algorithm.
 */


/* START SOLUTION */
public static long gcd(long a, long b) {
	return (b == 0) ? a : gcd(b, a % b);
}
/* END SOLUTION */


public static void main(String[] args) {
	System.out.println(gcd(150, 100));
}	


}
