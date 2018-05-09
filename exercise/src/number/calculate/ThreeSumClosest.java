package number.calculate;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		int result = threeSumClosest_1(nums, 1);
		System.out.println(result);
	}


	/**
	 * LeetCode 上看到的，跟我的方法思路是一样的，只是代码更优雅。减少了一些不必要的变量的
	 */
	private static int threeSumClosest_1(int[] nums, int target) {

		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[2];
		for(int i = 0; i < nums.length-2; i++){
			if(i != 0 && nums[i] == nums[i-1])
				continue;
			int j = i + 1;
			int k = nums.length - 1;
			while(j < k){
				int sum = nums[i] + nums[j] + nums[k];
				result = Math.abs(result  - target) < Math.abs(sum - target) ? result : sum;
				if(result == target)
					return target;
				if(sum - target < 0)
					j++;
				else
					k--;
			}
		}
		
		return result;
	}


	/**
	 * 自己根据ThreeSum想的方法，还是不够优雅
	 */
	private static int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);
		int closest = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (target - sum < 0) {
					if (sum - target < closest) {
						closest = sum - target;
						result = sum;
					}
					k--;
				} else if (target - sum > 0) {
					if (target - sum < closest) {
						closest = target - sum;
						result = sum;
					}
					j++;
				} else { // 如果是0，则表示“最接近的值已经找到”，直接返回0
					return sum;
				}

			}
		}

		return result;
	}
}
