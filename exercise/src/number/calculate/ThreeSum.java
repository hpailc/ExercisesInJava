package number.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组 
 * 
 * 注意：答案中不可以包含重复的三元组。 
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 *  [ [-1, 0, 1], [-1, -1, 2] ]
 *
 */
public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result = threeSum_2(nums);
		System.out.println(result);
	}

	/**
	 * LeetCode上看到的方法。两个指针的方法，只有两个循环
	 * 
	 * @param nums
	 * @return
	 */
	private static List<List<Integer>> threeSum_2(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] == 0) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					while (j < k && nums[j] == nums[j - 1])
						j++;
					k--;
				} else if (nums[i] + nums[j] + nums[k] < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return result;
	}

	/**
	 * 三个指针，三个循环 这个方法最简单，不排序的话，会有重复，排序的话会时间超时。
	 * 
	 * @param nums
	 * @return
	 */
	private static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1])
					continue;
				for (int k = j + 1; k < nums.length; k++) {
					if (k != j + 1 && nums[k] == nums[k - 1])
						continue;
					if (nums[i] + nums[j] + nums[k] == 0) {
						list.add(Arrays.asList(nums[i], nums[j], nums[k]));
					}
				}
			}
		}

		return list;
	}

	/**
	 * 两个指针，非排序算法 LeetCode上看到的不用排序的O(n²)的解法
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum_1(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Set<Integer> firstNum = new HashSet<>();

		for (int i = 0; i < nums.length - 2; i++) {
			if (!firstNum.contains(nums[i])) {
				int sum = -nums[i];
				Set<Integer> secondNum = new HashSet<>();
				Set<Integer> thirdNum = new HashSet<>();
				for (int j = i + 1; j < nums.length; j++) {
					if (!firstNum.contains(nums[j]) && !thirdNum.contains(nums[j])) {
						if (secondNum.contains(sum - nums[j])) {
							res.add(Arrays.asList(nums[i], nums[j], sum - nums[j]));
							thirdNum.add(nums[j]);
						} else {
							secondNum.add(nums[j]);
						}
					}
				}

				firstNum.add(nums[i]);
			}
		}
		return res;
	}

}
