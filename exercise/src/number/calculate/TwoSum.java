package number.calculate;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int nums[] = { 2, 5, 5, 11 };
		int target = 10;
		int result[] = twoSum(nums, target);
		if (result != null) {
			System.out.println(result[0] + "......" + result[1]);
		}
	}

	/*************************
	 * 解法一：自己思考的方法 
	 * ***********************
	 * 使用两个for循环来实现查找，外面的循环记录第一个目标的角标，内部的循环记录第二个目标的角标。
	 * 内部循环从外部循环的下一个位置开始查找。
	 * 
	 * 时间复杂度较高，n*n
	 */
	private static int[] sum2SatisfyTarget(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				if (target == sum) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	/***************************
	 * 解法二：参看LeetCode上面的解决方案
	 ***************************
	 *这个方法很有技巧，使用map配合for循环，遍历一遍就完成了。
	 * 时间复杂度为 n
	 */
	private static int[] twoSum(int[] nums, int target) {
		int result[] = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				return result;
			}
			map.put(nums[i], i);
		}

		return null;
	}
}
