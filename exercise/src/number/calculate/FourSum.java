package number.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * ����һ������ n ������������ nums ��һ��Ŀ��ֵ target���ж� nums ���Ƿ�����ĸ�Ԫ�� a��b��c �� d ��ʹ�� a + b + c + d ��ֵ�� target ��ȣ�
 * �ҳ��������������Ҳ��ظ�����Ԫ�顣
 * 
 * ���в����԰����ظ�����Ԫ�顣
 * 
 * ʾ����
 * �������� nums = [1, 0, -1, 0, -2, 2]���� target = 0��
 * ����Ҫ�����Ԫ�鼯��Ϊ��
 *		[
 *		  [-1,  0, 0, 1],
 *		  [-2, -1, 1, 2],
 *		  [-2,  0, 0, 2]
 *		]
 * @author 55083
 *
 */
public class FourSum {

	public static void main(String[] args) {

		int[] nums = { 1, 0, -1, 0, -2, 2 };
		int target = 0;

		List<List<Integer>> result = fourSum_1(nums, target);
		System.out.println(result);
	}

	/*
	 * LeetCode �Ͽ����ķ��������Ӷ�O(n^2)-O(n^3)
	 * ������bug��[0,0,0,0]��������Ͳ���
	 */
	private static List<List<Integer>> fourSum_1(int[] nums, int target) {

		Arrays.sort(nums);
		Map<Integer, List<int[]>> twoMap = new HashMap<>();
		Set<List<Integer>> res = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1])
					continue;

				if (twoMap.containsKey(target - (nums[i] + nums[j]))) {

					List<int[]> pairs = twoMap.get(target - (nums[i] + nums[j]));
					for (int[] pair : pairs) {
						int m1 = Math.min(pair[0], i);
						int m2 = Math.min(pair[1], j);
						int m3 = Math.max(pair[0], i);
						int m4 = Math.max(pair[1], j);

						if (m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4)
							continue;
						res.add(Arrays.asList(nums[m1], nums[Math.min(m2, m3)], nums[Math.max(m2, m3)], nums[m4]));
					}
				}
				twoMap.computeIfAbsent(nums[i] + nums[j], key -> new ArrayList<>()).add(new int[] { i, j });
			}
		}

		return new ArrayList<List<Integer>>(res);
	}

	/*
	 * ����3Sum��˼·�޸ĵõ��ķ��������Ӷ�ΪO(n^3)
	 */
	private static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 4)
			return result;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			int fSum = target - nums[i];
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1])
					continue;
				int tSum = fSum - nums[j];
				int k = j + 1;
				int l = nums.length - 1;
				while (k < l) {
					int twoSum = nums[k] + nums[l];
					if (twoSum == tSum) {
						result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
						k++;
						while (k < l && nums[k] == nums[k - 1])
							k++;
						l--;
					} else if (twoSum < tSum) {
						k++;
					} else {
						l--;
					}
				}
			}
		}

		return result;
	}

}
