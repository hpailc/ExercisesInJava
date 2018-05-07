package array.remove;

public class RemoveElement {
	public static void main(String[] args) {
		int[] nums = {2,3,3,2};
		int val = 2;
		int len = removeElement(nums,val);
		System.out.println(len);
	}
	public static int removeElement(int[] nums,int val){
		int x = 0;
		for(int i = 0;i<nums.length;i++){
			if(nums[i] != val){
				nums[x++] = nums[i];
			}
		}
		return x;
	}
}
