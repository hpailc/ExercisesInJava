package string.analyse;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Brackets {
	public static void main(String[] args) {
		String s = "({{}{}[]})()";
		System.out.println(isValid_3(s));
	}

	/********************************
	 * from LeetCode
	 ********************************
	 * 很巧妙的一个方法，代码量最少。非常优雅
	 * @param s
	 * @return
	 */
	private static boolean isValid_3(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '[')
				stack.push(']');
			else if (c == '{')
				stack.push('}');
			else if (stack.peek() == null || stack.pop() != c)
				return false;

		}
		return stack.isEmpty();
	}

	/*********************************
	 * from leetCode
	 **********************************
	 * @param s
	 * @return
	 */
	private static boolean isValid_2(String s) {
		char[] chArr = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (Character c : chArr) {
			if (c == '(' || c == '[' || c == '{')
				stack.push(c);
			else {
				if (c == ')') {
					if (stack.isEmpty() || stack.peek() != '(')
						return false;
					stack.pop();
				}
				if (c == ']') {
					if (stack.isEmpty() || stack.peek() != '[')
						return false;
					stack.pop();
				}
				if (c == '}') {
					if (stack.isEmpty() || stack.peek() != '{')
						return false;
					stack.pop();
				}
			}
		}

		return stack.isEmpty();
	}

	/*******************************************
	 * 解法二：from leetcode
	 *******************************************
	 * Use a stack to store the characters of string.
	 * 
	 * @param s
	 * @return
	 */
	private static boolean isValid_1(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[')
				stack.push(c);
			else if (stack.isEmpty()) // 这里返回false的意义是因为：如果第一个进入stack的char
				return false; // 是闭括号的话，那么后面就不用看了
			if (c == ')') {
				if (stack.peek() == '(')
					stack.pop();
				else
					return false;
			}
			if (c == '}') {
				if (stack.peek() == '{')
					stack.pop();
				else
					return false;
			}
			if (c == ']') {
				if (stack.peek() == '[')
					stack.pop();
				else
					return false;
			}
		}

		return stack.isEmpty();
	}

	/***************************************************
	 * 解法一：自己想出来的。
	 ***************************************************
	 * 使用的是List，可能会比较占用空间和时间。 每次都先将字符存入List，然后在进行比较，浪费时间和内存。
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {

		List<Character> list = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
			if (list.size() > 1) {
				char last = list.get(list.size() - 1);
				char sec_last = list.get(list.size() - 2);
				if (last == '}' && sec_last == '{') {
					list.remove(list.size() - 1);
					list.remove(list.size() - 1);
				}
				if (last == ')' && sec_last == '(') {
					list.remove(list.size() - 1);
					list.remove(list.size() - 1);
				}
				if (last == ']' && sec_last == '[') {
					list.remove(list.size() - 1);
					list.remove(list.size() - 1);
				}
			}
		}

		return list.size() == 0 ? true : false;
	}
}
