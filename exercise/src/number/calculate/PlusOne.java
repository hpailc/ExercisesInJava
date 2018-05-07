package number.calculate;

public class PlusOne {

	public static void main(String[] args) {
		int digits[] = {9,9,9,9,9};
		int result[] = plusOne_1(digits);
		for(int x : result)
		System.out.print(x);
	}

	private static int[] plusOne_1(int[] digits){
		
		for(int i = digits.length-1;i>=0;i--){
			if(digits[i]<9){
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		
		int result[] = new int[digits.length+1];
		result[0] = 1;
		return result;
	}
	
	private static int[] plusOne(int[] digits) {
		int carry = 1;
        int index = digits.length - 1;
        while (index >= 0 && carry > 0)	//这里的"carry>0"很巧妙，只有当carry>0是表示有进位
        {
            digits[index] = (digits[index] + carry) % 10;
            carry = digits[index] == 0 ? 1 : 0;
            index--;
        }
        
        if (carry > 0)
        {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        
        return digits;
	}
	
}
