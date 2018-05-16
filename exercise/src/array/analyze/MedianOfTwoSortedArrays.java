package array.analyze;

/*
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 示例：
 * 		nums1 = [1, 3]
		nums2 = [2]
		
		中位数是 2.0
 * 
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
		int[] nums2 = { 2 };
		double result = findMedianSortedArrays(nums1, nums2);
		System.out.println(result);
	}

	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int m = nums1.length;
		int n = nums2.length;
		int imin = 0;
		int imax = m;
		int half_len = (m + n + 1) / 2;

		while (imin <= imax) {
			int i = (imin + imax) / 2;
			int j = half_len - i;

			if (i > imin && nums1[i - 1] > nums2[j]) {
				imax--;

			} else if (i < imax && nums2[j - 1] > nums1[i]) {
				imin++;

			} else {
				int max_left = 0;
				if (i == 0) {
					max_left = nums2[j - 1];
				} else if (j == 0) {
					max_left = nums1[i - 1];
				} else {
					max_left = Math.max(nums1[i - 1], nums2[j - 1]);
				}

				if ((m + n) % 2 == 1)
					return max_left;

				int min_right = 0;
				if (i == m) {
					min_right = nums2[j];
				} else if (j == n) {
					min_right = nums1[i];
				} else {
					min_right = Math.min(nums1[i], nums2[j]);
				}

				return (max_left + min_right) / 2.0;
			}
		}
		return 0.0;

	}
	
	private static double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays_1(nums2, nums1);
		}

		int l1 = nums1.length;
		int l2 = nums2.length;
		int iMin = 0;
		int iMax = l1;
		int halfLen = (l1 + l2 + 1) / 2;

		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;

			if (i > iMin && nums1[i - 1] > nums2[j]) {
				// i is too big
				iMax--;

			} else if (i < iMax && nums2[j - 1] > nums1[i]) {
				// i is too small
				iMin++;

			} else {
				// i is right
				int leftMax = 0;
				if (i == 0) {
					leftMax = nums2[j - 1];
				} else if (j == 0) {
					leftMax = nums1[i - 1];
				} else {
					leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
				}
				if ((l1 + l2) % 2 == 1) {
					return leftMax;
				}

				int rightMin = 0;
				if (i == l1) {
					rightMin = nums2[j];
				} else if (j == l2) {
					rightMin = nums1[i];
				} else {
					rightMin = Math.min(nums1[i], nums2[j]);
				}
				return (leftMax + rightMin) / 2.0;
			}
		}
		return 0.0;
	}
}
