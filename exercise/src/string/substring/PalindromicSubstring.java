package string.substring;

/**
 * 求字符串中的最大回文字符串。 回文字符串：从左往右、从右往左看都一样的字符串。成镜像的。
 * 
 * @author 55083
 *
 */
public class PalindromicSubstring {
	private static int lo, maxlen;

	public static void main(String[] args) {
		String s = "bb";
		String result = longestPalindrome(s);
		System.out.println(result);
	}

	/**
	 * LeetCode上看到的。方法是：每取到一个字符，就往两边看，看两边的字符是否相同。直到不同为止。
	 * @param s
	 * @return
	 */
	private static String longestPalindrome(String s) {
		if (s.length() < 2)
			return s;
		for (int i = 0; i < s.length() - 1; i++) {
			extendPalindrome(s, i, i);
			extendPalindrome(s, i, i + 1);
		}
		return s.substring(lo, lo + maxlen);
	}

	private static void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxlen < k - j - 1) {
			maxlen = k - j - 1;
			lo = j + 1;
		}
	}
}
