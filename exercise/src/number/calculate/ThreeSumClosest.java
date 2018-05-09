package number.calculate;

import java.util.Arrays;

/**
 * ����һ������ n ������������ nums �� һ��Ŀ��ֵ target���ҳ� nums �е�����������ʹ�����ǵĺ��� target ��ӽ����������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�
 * 
 * ���磬�������� nums = [-1��2��1��-4], �� target = 1.
 * 
 * �� target ��ӽ����������ĺ�Ϊ 2. (-1 + 2 + 1 = 2).
 *
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		int result = threeSumClosest_1(nums, 1);
		System.out.println(result);
	}


	/**
	 * LeetCode �Ͽ����ģ����ҵķ���˼·��һ���ģ�ֻ�Ǵ�������š�������һЩ����Ҫ�ı�����
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
	 * �Լ�����ThreeSum��ķ��������ǲ�������
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
				} else { // �����0�����ʾ����ӽ���ֵ�Ѿ��ҵ�����ֱ�ӷ���0
					return sum;
				}

			}
		}

		return result;
	}
}
