package string.analyse;

/**
 * ƥ��������ʽ�� . ����ʾ���ⵥ���ַ� * ����ʾ 0 �� �� ���֮ǰ���ַ�
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
	 * LeetCode ���ݹ�
	 * ʹ�õݹ�ķ�ʽ�����жϡ�
	 * ˼�룺
	 * 		ÿһ�αȽ�ֻ�Ƚ� ��һ���ַ��Ƿ�ƥ��  ��  �ڶ����ַ��� '*' �������Ȼ��ݹ�
	 */
	public static boolean isMatch_1(String s, String p) {
		if (p.isEmpty())
			return s.isEmpty();
		boolean first_match = (!s.isEmpty() && //�ж������ַ��������ַ��Ƿ�ƥ��
				(s.charAt(0) == p.charAt(0) || //
						p.charAt(0) == '.'));//

		if (p.length() >= 2 && p.charAt(1) == '*') {	// ���������ʽ�ĵڶ����ַ��ǡ�*��
			return (isMatch_1(s, p.substring(2)) || //1�����ַ���ƥ�䣬��*�����Խ�������ʽ�ĵ�һ����ƥ����ַ�����
					(first_match && //2������ĸƥ�䣬���ַ����ƶ�����һ���ַ������ж�
							isMatch_1(s.substring(1), p)));
		} else {
			return first_match && isMatch_1(s.substring(1), p.substring(1));
		}
	}

	/**
	 * �Լ���İ취��û���ܹ����
	 */
	public static boolean isMatch(String s, String p) {

		if (s.equals(p))
			return true;
		int i = 0;
		int j = 0;
		while (i < s.length() && j < p.length()) {
			// ����������һ���ַ�
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
							// ���������ˣ��Ƚ��鷳������Ƚ϶ࡣ���õݹ���������������Ժ���

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
