package array.sort;

/**
 * 算法思路：
 * 		首先要明确找到的中位数是什么？即找到这个数之后，比它小的数和比它大的数的个数是一样的。
 * 		在这两个排好序的数组中，如果这个数在A[]中，那么假设它的位置是i，那么它在B[]中一定有一个对应的位置，
 * 		这个位置假设为j。那么 i+j=m-i+n-j （或者：i+j=m-i+n-j+1）
 * @author 55083
 *
 */
public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2};
		double result = findMedianSortedArrays(nums1, nums2);
		System.out.println(result);
	}

	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int m = nums1.length;
		int n = nums2.length;
		if (m > n) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}

		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin < iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;

			if (i < iMax && nums2[j - 1] > nums1[i]) {
				iMin = iMin + 1;
			} else if (i > iMin && nums2[j] < nums1[i - 1]) {
				iMax = iMax - 1;
			} else {
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = nums2[j - 1];
				} else if (j == 0) {
					maxLeft = nums1[i - 1];
				} else {
					maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}

				int minRight = 0;
				if (i == m) {
					minRight = nums2[j];
				} else if (j == n) {
					minRight = nums1[i];
				} else {
					minRight = Math.min(nums2[j], nums1[i]);
				}

				return (maxLeft + minRight) / 2.0;
			}

		}

		return 0.0;
	}
}
