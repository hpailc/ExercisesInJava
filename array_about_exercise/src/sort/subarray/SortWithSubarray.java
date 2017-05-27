package sort.subarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���������飬����Ҫ�ҵ�һ�������������飬���������������������������ô��������Ҳ�ᰴ�������� ��Ҫ�ҵ���̵����������飬������䳤�ȡ�
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

	/* ��������һ���㷨
	 * **************************
	 * �������ұȽϣ��ҳ�����λ��
	 * ��������Ƚϣ��ҳ���ʼ��λ�á�
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
	 * �Ӽ���Ҫ��ȡҪ�������������
	 */
	private static int[] readArrayFromKeyboard() throws IOException {

		List<Integer> list = new ArrayList<Integer>();
		System.out.println("���������������е������ԡ�exit����������");
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
