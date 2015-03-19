import java.util.*;

class binary_search {

/* START SOLUTION */

public static double eqn (double x) {
	return Math.pow(x, 2);
}

// Searches between around about -10^1023 to 10^1023
// Loses precision as it moves away from 0.
public static double binarySearch(double goal) {

	// If we know our range within a few orders of magnitude we can knock
	// it down from about 1000 loops to 50.
	double front = Double.MIN_VALUE;
	double back = Double.MAX_VALUE;
	double mid = 0;
	double eps = Math.pow(10, -6);

	// Todo: work out optimum way to scale eps with mid for best precision.
	while (true) {

		if (Math.abs(eqn(mid) - goal) < eps)   return mid;
		if (goal < eqn(mid))                   back = mid;
		else                                   front = mid;
		
		mid = (front + back) / 2;
		}
}

/* END SOLUTION */


	public static void main(String[] arg) {
		System.out.println(binarySearch(144));
	}
}
