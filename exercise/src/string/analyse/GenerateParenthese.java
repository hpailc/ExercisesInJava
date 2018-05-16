package string.analyse;

import java.util.ArrayList;
import java.util.List;

/*
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 *	   [
 *		  "((()))",
 *		  "(()())",
 *		  "(())()",
 *		  "()(())",
 *		  "()()()"
 *		]
 */
public class GenerateParenthese {

	public static void main(String[] args) {

		List<String> result = generateParenthesis(3);
		System.out.println(result);
	}

	private static List<String> generateParenthesis(int i) {
		List<String> list = new ArrayList<>();
		backtrack(list, "", 0, 0, i);
		return list;
	}

	// 通过递归得到完整的闭合()
	private static void backtrack(List<String> list, String string, int open, int close, int n) {
		
		if (string.length() == n * 2) {
			list.add(string);
			return;
		}

		if (open < n)		// 通过左括号的数量来控制总数
			backtrack(list, string + "(", open + 1, close, n);
		if (close < open)	// 通过右括号来控制闭合
			backtrack(list, string + ")", open, close + 1, n);

	}

}
