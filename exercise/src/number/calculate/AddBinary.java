package number.calculate;

public class AddBinary {

	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		String result = AddBinary(a,b);
		System.out.println(result);
	}

	private static String AddBinary(String a, String b) {
		StringBuffer sb = new StringBuffer();
		int carry = 0;
		int a_len = a.length()-1;
		int b_len = b.length()-1;
		while(a_len >= 0 || b_len >= 0){
			int sum = carry;
			if(a_len >= 0) sum += a.charAt(a_len--) - '0';
			if(b_len >= 0) sum += b.charAt(b_len--) - '0';
			sb.append(sum%2);
			carry = sum / 2;
		}
		if(carry != 0) sb.append(carry);
		return sb.reverse().toString();
	}
}
