package number.others;

/**
 * 判断一个整形数值是不是回文数。 Determine whether an integer is a palindrome. Do this without
 * extra space.
 * 
 * @author Administrator
 *
 */
public class PalindromeNumbers {

	public static void main(String[] args) {
		int x = 1234321;
		boolean flag = isPalindromeNumbers_1(x);
		System.out.println(flag);
	}

	/***************************************
	 * LeetCode
	 ***************************************
	 * 思路中值得借鉴的地方是，在while循环的条件设置为:x>rev
	 * 这样做的好处是，不用将整个数值完全反转过来再进行判断，只用反转一半进行判断就可以了，
	 * 节省了一半的时间，同时不用单独去处理负数的情况。
	 * 
	 * @param x
	 * @return
	 */
	private static boolean isPalindromeNumbers_1(int x) {

		int rev = 0;
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}

		return rev == x || rev / 10 == x;
	}

	/**************************
	 * 原创
	 **************************
	 * 思路就是将传入的整形数值进行反转，然后与原来的值进行比较 注意： 1，方法中并没有涉及到数值越界问题； 2，负数返回false
	 * 
	 * @param x
	 * @return
	 */
	private static boolean isPalindromeNumbers(int x) {

		int reverse = 0;
		int y = x;
		while (y != 0) {
			reverse = reverse * 10 + y % 10;
			y = y / 10;
		}
		if (reverse == x && x >= 0) {
			return true;
		}
		return false;
	}

}
