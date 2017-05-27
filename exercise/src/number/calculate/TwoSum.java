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
	 * �ⷨһ���Լ�˼���ķ��� 
	 * ***********************
	 * ʹ������forѭ����ʵ�ֲ��ң������ѭ����¼��һ��Ŀ��ĽǱ꣬�ڲ���ѭ����¼�ڶ���Ŀ��ĽǱꡣ
	 * �ڲ�ѭ�����ⲿѭ������һ��λ�ÿ�ʼ���ҡ�
	 * 
	 * ʱ�临�ӶȽϸߣ�n*n
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
	 * �ⷨ�����ο�LeetCode����Ľ������
	 ***************************
	 *����������м��ɣ�ʹ��map���forѭ��������һ�������ˡ�
	 * ʱ�临�Ӷ�Ϊ n
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
