import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Champernowne {

	// 0.123456789101112131415161718192021...
	// d12 = 12th digit = 1
	// d10 = 10th digit = 10

	public static void main(String[] args) {

		String hugeString = "";
		List<Integer> list = new ArrayList<>();
		list.toString();

		for (int i = 1; i < 1000001; i++) {
			list.add(i);
		}
		
	    hugeString = list.toString();
	    hugeString = hugeString.replaceAll("\\[", "");
	    hugeString = hugeString.replaceAll("\\]", "");
	    hugeString = hugeString.replaceAll(", ","");
	    System.out.println(hugeString);

		System.out.println(hugeString.charAt(1 - 1));
		BigInteger a = new BigInteger(String.valueOf(hugeString.charAt(1 - 1)));
		System.out.println(hugeString.charAt(10 - 1));
		BigInteger b = new BigInteger(String.valueOf(hugeString.charAt(10 - 1)));
		System.out.println(hugeString.charAt(100 - 1));
		BigInteger c = new BigInteger(String.valueOf(hugeString.charAt(100 - 1)));
		System.out.println(hugeString.charAt(1000 - 1));
		BigInteger d = new BigInteger(String.valueOf(hugeString.charAt(1000 - 1)));
		System.out.println(hugeString.charAt(10000 - 1));
		BigInteger e = new BigInteger(String.valueOf(hugeString.charAt(10000 - 1)));
		System.out.println(hugeString.charAt(100000 - 1));
		BigInteger f = new BigInteger(String.valueOf(hugeString.charAt(100000 - 1)));
		System.out.println(hugeString.charAt(1000000 - 1));
		BigInteger g = new BigInteger(String.valueOf(hugeString.charAt(1000000 - 1)));
		BigInteger multiply = a.multiply(b.multiply(c.multiply(d.multiply(e.multiply(f.multiply(g))))));
		System.out.println(multiply);
	}
}
