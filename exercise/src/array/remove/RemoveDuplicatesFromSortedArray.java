package array.remove;

/**
 * Given a sorted array,remove the duplicates in place such that each element
 * appear only once and return the new length. Do not allocate extra space for
 * another array, you must do this in place with constant memory.
 * 
 * For example, Given input array nums=[1,1,2]
 * 
 * Your function should return length=2, with the first two elements of nums
 * beeing 1 and 2respectively. It doesn't matter what you leave beyond the new
 * length.
 *
 */
public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		int value = removeDuplicates(nums);
		System.out.println(value);
		for (int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);
	}

	public static int removeDuplicates(int[] nums) {
		int result = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != nums[i + 1]) {
				nums[result++] = nums[i+1];
			}
		}

		return result;
	}
}
