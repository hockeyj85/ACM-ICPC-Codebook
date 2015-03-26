import java.util.*; 

class powersets { 

public static void main (String[] a) { new powersets().begin(); }

/* START SOLUTION */

// Generate all power sets of an array using a bit mask
// Inluding the empty set
void powerSets(int[] array) {

	int setSize = array.length;
	for (int i = 0; i < (1 << setSize); i++) {

		// Generate a mask for the set
		boolean[] mask = new boolean[setSize];
		for (int j = 0; j < setSize; j++) {
			mask[j] = (~i & (1 << j)) == 0;
		}

		// Generate a powerset
		Set<Integer> set = new HashSet<Integer>(setSize);
		for (int j = 0; j < setSize; j++) {
			if (mask[j]) set.add(array[j]);
		}

		// Use it to perform some function (printing here)
		System.out.println(set);
	}
}

/* END SOLUTION */

void begin() {
	Scanner in = new Scanner(System.in);

	int[] array = {1, 2, 3, 4, 5};
	powerSets(array);
}}
