import java.util.*;

class endian_swap { public static void main (String[] a) { new endian_swap().begin(); }

/* START SOLUTION */

// Big endian stores most significant BYTE at lowest address
// Mask of a byte at a time and shift it
int swapEndian(int i) {
    return ((i&0xff)<<24)|((i&0xff00)<<8)|((i&0xff0000)>>8)|((i>>24)&0xff);
}

/* END SOLUTION */

void begin() {
	Scanner in = new Scanner(System.in);

	while (in.hasNextInt()) {
		int i = in.nextInt();
		System.out.println(i + " converts to " + swapEndian(i));
	}
}	
}
