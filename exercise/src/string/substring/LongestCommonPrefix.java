package string.substring;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings. �����ַ��������е������ǰ׺��
 * 
 * @author Administrator
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String strs[] = { "abcdefg", "abcdgdf", "abceifljv", "abcdfioei", "abceg" };
		String prefix = longestCommonPrefix_2(strs);
		System.out.println(prefix);
	}

	private static String longestCommonPrefix_2(String[] strs) {

		StringBuffer result = new StringBuffer();

		if (strs != null && strs.length > 0) {
			Arrays.sort(strs);

			for (int i = 0; i < strs[0].length(); i++) {

			}

		}

		return result.toString();
	}

	/********************************
	 * LeetCode
	 ********************************
	 */
	private static String longestCommonPrefix_1(String[] strs) {

		if (strs == null || strs.length == 0)
			return "";
		String pre = strs[0];
		int i = 1;
		while (i < strs.length) {
			// �ڲ�ѭ�����������õķǳ��м��ɣ�ͨ��ÿ��ѭ����pre��length-1������
			while (strs[i].indexOf(pre) < 0)
				pre = pre.substring(0, pre.length() - 1);
			i++;
		}

		return pre;
	}

	/****************************
	 * ԭ��
	 ****************************
	 * ʹ������ѭ��Ƕ������ɲ���
	 */
	private static String longestCommonPrefix(String[] strs) {

		if (strs.length < 1) {
			return "";
		}
		String prefix = strs[0];

		for (int o = 1; o < strs.length; o++) {
			int length = prefix.length() < strs[o].length() ? prefix.length() : strs[o].length();
			prefix = prefix.substring(0, length);
			for (int i = 0; i < length; i++) {
				if (prefix.charAt(i) != strs[o].charAt(i)) {
					prefix = prefix.substring(0, i);
					break;
				}
			}
		}

		return prefix;
	}
}
