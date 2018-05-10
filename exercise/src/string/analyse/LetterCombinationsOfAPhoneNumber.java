package string.analyse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 * 
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 */
public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		String digits = "234";
		List<String> result = letterCombinations_2(digits);
		System.out.println(result);
	}

	/*
	 * LeetCode上看到的方法，非常的灵活的一个方法
	 */
	private static List<String> letterCombinations_1(String digits) {
		LinkedList<String> result = new LinkedList<>();
		if (digits.isEmpty())
			return result;
		String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		result.add("");
		// 每一次存入 list 中的字符串的长度，都跟前一次迭代digits的个数相同
		while (result.peek().length() != digits.length()) {
			String map = mapping[digits.charAt(result.peek().length()) - '0'];
			String t = result.remove();
			for (char c : map.toCharArray())
				result.add(c + t);
		}
		return result;
	}

	/* 这个方法跟上一个方法一样 */
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


	/* 迭代法 */
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
