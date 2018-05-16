package array.analyze;

/*
 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai) ��
 * �� n ����ֱ�ߣ�ʹ�ô�ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0)��
 * �ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
 * ע�⣺�㲻����б������n ������2��
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = { 500,10,10,5000,501 };
		int result = maxArea(height);
		System.out.println(result);
	}

	
	/*
	 * LeetCode
	 * ˼·����������˼��������������
	 * 1������ߺ����ұߵ������㣬ӵ�����Ŀ�ȣ�
	 * 2������м����������Ҫ�����������ֻ���ڸ߶��ϱ����Ǹߣ�
	 * 3�����԰�����ߺ����ұߵ�����ֵ�н�С���Ǹ�ȥ�������м����Ѱ�Ҹ����ֵ��
	 */
	private static int maxArea_1(int[] height) {
		int left = 0;
		int right = height.length -1;
		int maxArea = 0;
		while(left < right){
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right -left));
			if(height[left] < height[right])
				left++;
			else
				right--;
		}
		return maxArea;
	}



	/**
	 * ��ʱ
	 * @param height
	 * @return
	 */
	private static int maxArea(int[] height) {

		int area = 0;
		int max = area;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				area = Math.min(height[i], height[j]) * (j - i);
				max = area > max ? area : max;
			}
		}
		return max;
	}

}
