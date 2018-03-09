package number.calculate;

public class MaximumSubArray {

	public static void main(String[] args) {
		int nums[] = { 8, -19, 5, -4, 20 };
		int result = maxSubArray_1(nums);
		System.out.println(result);
	}

	/**
	 * LeetCode �Ͽ����ģ���ţ��˼·������������ˡ�
	 * 
	 * @param A
	 * @return
	 */
	public static int maxSubArray_1(int[] A) {
		int maxSoFar = A[0], maxEndingHere = A[0];
		for (int i = 1; i < A.length; ++i) {
			maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}


	/**
	 * �Լ���ķ����������⣬��û���
	 * 
	 * @param nums
	 * @return
	 */
	private static int[] maxSubArray(int[] nums) {

		int first = 0; // ��¼�Ӽ��Ŀ�ʼλ��
		int last = 0; // ��¼�Ӽ��ĳ���
		int temp = nums[0]; // ��¼��ʱֵ
		int max = nums[0]; // ��¼�����
		for (int i = 1; i < nums.length; i++) {
			// 1����ǰ���� ���� max���򽫵�ǰ����Ϊ���ֵ��
			if (nums[i] > max) {
				if (i == last + 1 && max > 0) {
					max += nums[i];
					last = i;
				} else {
					max = Math.max((max + temp + nums[i]), nums[i]);
					first = i; // ���õ�ǰ�����±�Ϊ��ʼλ��
					last = i; // ��ֹλ��
					temp = 0; // ������ʱֵ
				}
			} else {
				if (i == 1)
					temp = nums[i];
				else
					temp += nums[i];
				if (temp > 0) {
					max += temp;
					last = i;
					temp = 0;
				}
			}
		}
		int result[] = new int[last - first + 1];
		int x = 0;
		for (int i = first; i < last + 1; i++) {
			result[x++] = nums[i];
		}

		return result;
	}

}
