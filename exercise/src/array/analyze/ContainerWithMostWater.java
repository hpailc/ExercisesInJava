package array.analyze;

/*
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 注意：你不能倾斜容器，n 至少是2。
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = { 500,10,10,5000,501 };
		int result = maxArea(height);
		System.out.println(result);
	}

	
	/*
	 * LeetCode
	 * 思路：这个题的意思就是求最大面积。
	 * 1，最左边和最右边的两个点，拥有最大的宽度；
	 * 2，如果中间的其他点想要比他们面积大，只能在高度上比他们高；
	 * 3，所以把最左边和最右边的两个值中较小的那个去掉，往中间继续寻找更大的值。
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
	 * 超时
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
