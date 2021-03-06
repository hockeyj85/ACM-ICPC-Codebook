import java.util.*;

class longestIncreasingSubSequence{

/* START SOLUTION */

class Diamond implements Comparable<Diamond>{
	double weight;
	double clar;
	int lSubSeq = 1;
	Diamond (double weight, double clar) {this.weight = weight; this.clar = clar; }
	public int compareTo (Diamond o) {return Double.compare(this.weight, o.weight); }
	public String toString() { return "weight: " + weight + " clar: " + clar; } // for debug
}

// Requires array to be sorted.
// Looks through the list for find the longest sequence of:
// Weights: Strictly decreasing AND
// Clarity : Strictly increasing.
int lss(ArrayList<Diamond> ds) {

	// Work out all subsequences - O(n^2)
	for (int i = 1; i < ds.size(); i++) {
		Diamond d1 = ds.get(i);

		for (int j = 0; j < i; j++) {
			Diamond d2 = ds.get(j);
			
			// Stictly improving
			if (d1.clar < d2.clar && d1.weight > d2.weight) {
				int alt = d2.lSubSeq + 1;
				if (alt > d1.lSubSeq) d1.lSubSeq = alt;
			}
		}
	}

	// Find max
	int max = 0;
	for (Diamond d : ds ) {
		if (d.lSubSeq > max) max = d.lSubSeq;
	}
	return max;
}

/* END SOLUTION */

void s() {
	Scanner in = new Scanner(System.in);

	int T = in.nextInt();
	while (T-- != 0) {
		int N = in.nextInt();

		ArrayList<Diamond> ds = new ArrayList<Diamond>(N);
		for (int i = 0; i < N; i ++) {
			ds.add(new Diamond(in.nextDouble(), in.nextDouble()));
		}
		Collections.sort(ds);
		System.out.println(lss(ds));
	}
}

public static void main(String[] a) { new longestIncreasingSubSequence().s(); }
}
