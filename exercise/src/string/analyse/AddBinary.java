package string.analyse;

/**
 * Given two binary strings, return their sum (also a binary string). The input
 * strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1: Input: a = "11", b = "1" Output: "100"
 * 
 * Example 2: Input: a = "1010", b = "1011" Output: "10101"
 * 
 */
public class AddBinary {
	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		String result = addBinary_2(a, b);
		System.out.println(result);
	}

	private static String addBinary_2(String a, String b) {

		String s = "";
		int i = a.length() - 1;
		int j = b.length() - 1;
		int c = 0;
		while (i >= 0 || j >= 0 || c == 1) {
			c += i >= 0 ? a.charAt(i--) - '0' : 0;
			c += j >= 0 ? b.charAt(j--) - '0' : 0;
			s = (c % 2) + s;
			c /= 2;
		}
		return s;
	}

	private static String addBinary_1(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			sum += i >= 0 ? a.charAt(i--) - '0' : 0;
			sum += j >= 0 ? b.charAt(j--) - '0' : 0;
			carry = sum / 2;
			sb.append(sum % 2);
		}
		if (carry == 1)
			sb.append(1);
		return sb.reverse().toString();
	}

	private static String addBinary(String a, String b) {

		if (a.length() < b.length())
			return addBinary(b, a);
		StringBuffer sb = new StringBuffer();
		int j = b.length() - 1;
		boolean carry = false;
		for (int i = a.length() - 1; i >= 0; i--) {
			int x = a.charAt(i) - '0';
			int y = 0;
			if (j >= 0) {
				y = b.charAt(j) - '0';
				j--;
			}
			if (carry) {
				carry = x + y + 1 > 1 ? true : false;
				sb.append((x + y + 1) % 2);
			} else {
				carry = x + y > 1 ? true : false;
				sb.append((x + y) % 2);
			}
		}
		if (carry)
			sb.append(1);

		return sb.reverse().toString();
	}
}
