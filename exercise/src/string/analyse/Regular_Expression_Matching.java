package string.analyse;

/**
 * 匹配正则表达式： . ：表示任意单个字符 * ：表示 0 个 或 多个之前的字符
 *
 */

public class Regular_Expression_Matching {

	public static void main(String[] args) {

		String s = "aa";
		String p = "a*";
		boolean result = isMatch_1(s, p);

		System.out.println(result);
	}

	/**
	 * LeetCode ：递归
	 * 使用递归的方式进行判断。
	 * 思想：
	 * 		每一次比较只比较 第一个字符是否匹配  和  第二个字符是 '*' 的情况，然后递归
	 */
	public static boolean isMatch_1(String s, String p) {
		if (p.isEmpty())
			return s.isEmpty();
		boolean first_match = (!s.isEmpty() && //判断两个字符串的首字符是否匹配
				(s.charAt(0) == p.charAt(0) || //
						p.charAt(0) == '.'));//

		if (p.length() >= 2 && p.charAt(1) == '*') {	// 如果正则表达式的第二个字符是“*”
			return (isMatch_1(s, p.substring(2)) || //1，首字符不匹配，“*”可以将正则表达式的第一个不匹配的字符消掉
					(first_match && //2，首字母匹配，则将字符串移动到下一个字符继续判断
							isMatch_1(s.substring(1), p)));
		} else {
			return first_match && isMatch_1(s.substring(1), p.substring(1));
		}
	}

	/**
	 * 自己想的办法，没有能够完成
	 */
	public static boolean isMatch(String s, String p) {

		if (s.equals(p))
			return true;
		int i = 0;
		int j = 0;
		while (i < s.length() && j < p.length()) {
			// 如果都是最后一个字符
			if (i == s.length() - 1 && j == p.length() - 1) {
				if (s.charAt(i) == p.charAt(j)) {
					return true;
				} else if (p.charAt(j) == '.') {
					return true;
				} else if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				if (s.charAt(i) == p.charAt(j)) {
					i++;
					j++;
				} else if (p.charAt(j) == '.') {
					i++;
					j++;
				} else if (p.charAt(j) == '*') {
					if (s.charAt(i) == p.charAt(j - 1)) {
						if (i == s.length() - 1) {
							// 卡在这里了，比较麻烦，情况比较多。不用递归很难做到。留待以后考虑

						}

					} else if (p.charAt(j - 1) == '.') {
						i++;
					} else {
						j++;
					}
				} else {
					if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
						j++;
						continue;
					}
					return false;
				}
			}
		}

		return false;
	}

}
