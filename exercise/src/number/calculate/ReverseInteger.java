package number.calculate;

public class ReverseInteger {

	public static void main(String[] args) {
		int x = -123456789;
		int y = reverseInteger(x);
		System.out.println(y);
	}

	private static int reverseInteger(int x) {

		int result = 0;
		while (x != 0) {
			int tail = x % 10;
			result = result * 10 + tail;
			x = x / 10;
		}
		return result;
	}
}
