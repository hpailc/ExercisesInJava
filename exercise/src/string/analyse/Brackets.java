package string.analyse;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Brackets {
	public static void main(String[] args) {
		String s = "({{}{}[]})()";
		System.out.println(isValid_2(s));
	}

	/********************************
	 * from LeetCode
	 ********************************
	 * 锟斤拷锟斤拷锟斤拷锟揭伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷佟锟斤拷浅锟斤拷锟斤拷锟�
	 * @param s
	 * @return
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
	 * 锟解法锟斤拷锟斤拷from leetcode
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
			else if (stack.isEmpty()) // 锟斤拷锟斤返锟斤拷false锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷为锟斤拷锟斤拷锟斤拷锟揭伙拷锟斤拷锟斤拷锟絪tack锟斤拷char
				return false; // 锟角憋拷锟斤拷锟脚的伙拷锟斤拷锟斤拷么锟斤拷锟斤拷筒锟斤拷每锟斤拷锟�
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
	 * 锟解法一锟斤拷锟皆硷拷锟斤拷锟斤拷锟斤拷摹锟�
	 ***************************************************
	 * 使锟矫碉拷锟斤拷List锟斤拷锟斤拷锟杰伙拷冉锟秸硷拷每占锟斤拷时锟戒。 每锟轿讹拷锟饺斤拷锟街凤拷锟斤拷锟斤拷List锟斤拷然锟斤拷锟节斤拷锟叫比较ｏ拷锟剿凤拷时锟斤拷锟斤拷诖妗�
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
