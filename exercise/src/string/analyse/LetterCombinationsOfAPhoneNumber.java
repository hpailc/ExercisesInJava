package string.analyse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ
 * 
 * ʾ��:
 * ���룺"23"
 * �����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 */
public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		String digits = "234";
		List<String> result = letterCombinations_2(digits);
		System.out.println(result);
	}

	/*
	 * LeetCode�Ͽ����ķ������ǳ�������һ������
	 */
	private static List<String> letterCombinations_1(String digits) {
		LinkedList<String> result = new LinkedList<>();
		if (digits.isEmpty())
			return result;
		String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		result.add("");
		// ÿһ�δ��� list �е��ַ����ĳ��ȣ�����ǰһ�ε���digits�ĸ�����ͬ
		while (result.peek().length() != digits.length()) {
			String map = mapping[digits.charAt(result.peek().length()) - '0'];
			String t = result.remove();
			for (char c : map.toCharArray())
				result.add(c + t);
		}
		return result;
	}

	/* �����������һ������һ�� */
	private static List<String> letterCombinations(String digits) {
		LinkedList<String> result = new LinkedList<>();
		String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		if (digits.length() == 0)
			return result;
		result.add("");
		for (int i = 0; i < digits.length(); i++) {
			int index = Character.getNumericValue(digits.charAt(i));
			while (result.peek().length() == i) {
				String t = result.remove();
				for (char c : mapping[index].toCharArray()) {
					result.add(t + c);
				}
			}
		}
		return result;
	}


	/* ������ */
	static String[] array = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	private static List<String> letterCombinations_2(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits.length() == 0)
			return result;
		int first = digits.charAt(0) - '0';
		char[] combination = array[first].toCharArray();
		if (digits.length() > 1) {
			List<String> res = letterCombinations_2(digits.substring(1, digits.length()));
			for (char c : combination) {
				for (String r : res) {
					result.add(c + r);
				}
			}
		} else {
			for (char c : combination)
				result.add(c + "");
		}
		return result;
	}
	
}
