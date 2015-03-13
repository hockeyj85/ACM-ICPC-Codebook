import java.util.*;

class Main {

	// Spawns an instance of itself so we can use non-static objects
	public static void main(String[] args) {
		Main m = new Main();
		m.begin();
	}

	// True entry point
	public void begin() {
		Scanner in = new Scanner(System.in);

		System.out.println("I am a non static object");	
		// etc...
	}
}
