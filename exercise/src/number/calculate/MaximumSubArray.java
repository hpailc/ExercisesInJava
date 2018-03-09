package number.calculate;

public class MaximumSubArray {

	public static void main(String[] args) {
		int nums[] = { 8, -19, 5, -4, 20 };
		int result = maxSubArray_1(nums);
		System.out.println(result);
	}

	/**
	 * LeetCode 上看到的，很牛，思路清晰，简洁明了。
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
	 * 自己想的方法，有问题，还没解决
	 * 
	 * @param nums
	 * @return
	 */
	private static int[] maxSubArray(int[] nums) {

		int first = 0; // 记录子集的开始位置
		int last = 0; // 记录子集的长度
		int temp = nums[0]; // 记录临时值
		int max = nums[0]; // 记录最大数
		for (int i = 1; i < nums.length; i++) {
			// 1，当前数据 大于 max，则将当前数置为最大值。
			if (nums[i] > max) {
				if (i == last + 1 && max > 0) {
					max += nums[i];
					last = i;
				} else {
					max = Math.max((max + temp + nums[i]), nums[i]);
					first = i; // 设置当前数的下标为起始位置
					last = i; // 终止位置
					temp = 0; // 重置临时值
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
