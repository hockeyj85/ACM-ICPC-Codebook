import java.util.*;

class gcd{

/**
 * Greatest common denominator using euclids algorithm.
 * And LCM
 */


/* START SOLUTION */
static long gcd(long a, long b) { return (b == 0) ? a : gcd(b, a % b); }
static long lcm(long a, long b) { return a * (b / gcd(a, b)); }
/* END SOLUTION */


public static void main(String[] args) {
	System.out.println("150, 100\ngcd: " + gcd(150, 100) + "\tlcm: " + lcm(150, 100));
}	


}
