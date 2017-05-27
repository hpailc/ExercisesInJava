package sort.subarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组，你需要找到一个连续的子数组，如果将这个子数组进行升序排序，那么整个数组也会按升序排序。 需要找到最短的这样的属组，并输出其长度。
 * 
 * Input: [2, 6, 4, 8, 10, 9, 15] Output: 5 Explanation: You need to sort
 * [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in
 * ascending order.
 */
public class SortWithSubarray {

	public static void main(String[] args) throws Exception {
		int arr[] = { 6, 4, 8, 2, 10, 9, 15 };
		int x = findUnsortedSubarray(arr);
		System.out.println(x);
	}

	/* 很厉害的一个算法
	 * **************************
	 * 从左往右比较，找出最后的位置
	 * 从右往左比较，找出开始的位置。
	 ***************************/
	public static int findUnsortedSubarray(int[] A) {
		int n = A.length, beg = -1, end = -2, min = A[n - 1], max = A[0];
		for (int i = 1; i < n; i++) {
			max = Math.max(max, A[i]);
			min = Math.min(min, A[n - 1 - i]);
			if (A[i] < max)
				end = i;
			if (A[n - 1 - i] > min)
				beg = n - 1 - i;
		}
		return end - beg + 1;
	}


	/*
	 * 从键盘要读取要用来排序的属组
	 */
	private static int[] readArrayFromKeyboard() throws IOException {

		List<Integer> list = new ArrayList<Integer>();
		System.out.println("请依次输入数组中的数，以“exit”结束输入");
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String len;
		while (!(len = bufr.readLine()).equals("exit")) {
			int value = Integer.parseInt(len);
			list.add(value);
		}

		int values[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			values[i] = list.get(i);
		}
		bufr.close();
		return values;
	}
}
