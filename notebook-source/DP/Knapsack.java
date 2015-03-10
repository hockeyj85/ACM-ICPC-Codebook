import java.util.*;

class Knapsack {


/* START SOLUTION */
public static int knapsack(int N, int W, int[] v, int[] w) {
	int[] m = new int[W*N];

	for (int j = 0; j < W + 1; j++) {
		for (int i = 0; i < N; i++) {
			if (w[i] <= j) {
				m[j] = max(m[j], m[j-w[i]] + v[i]);
			}
		}
	}

	return m[W + (N-1)];
}
/* END SOLUTION */

public static int max(int x, int y) {
	return x > y ? x : y;
}

public static void main(String[] args) {

}

}
