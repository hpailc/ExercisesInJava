package string.analyse;

import java.util.ArrayList;
import java.util.List;

/*
 * ���� n �����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
 * ���磬���� n = 3�����ɽ��Ϊ��
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

	// ͨ���ݹ�õ������ıպ�()
	private static void backtrack(List<String> list, String string, int open, int close, int n) {
		
		if (string.length() == n * 2) {
			list.add(string);
			return;
		}

		if (open < n)		// ͨ�������ŵ���������������
			backtrack(list, string + "(", open + 1, close, n);
		if (close < open)	// ͨ�������������Ʊպ�
			backtrack(list, string + ")", open, close + 1, n);

	}

}
