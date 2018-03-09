package string.substring;

/**
 * ���ַ����е��������ַ����� �����ַ������������ҡ��������󿴶�һ�����ַ������ɾ���ġ�
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
	 * LeetCode�Ͽ����ġ������ǣ�ÿȡ��һ���ַ����������߿��������ߵ��ַ��Ƿ���ͬ��ֱ����ͬΪֹ��
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
