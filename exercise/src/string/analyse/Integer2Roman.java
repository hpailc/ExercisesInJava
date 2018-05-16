package string.analyse;

public class Integer2Roman {

	public static void main(String[] args) {
		int value = 1994;	//MCMXCIV
		String result = int2Roman_1(value);
		System.out.println(result);
	}

	/*
	 * LeetCode 上看到的比较牛的解法
	 */
	private static String int2Roman_1(int num) {
		String[] I = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
		String[] X = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String[] C = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String[] M = {"","M","MM","MMM"};
		return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
	}

	/*
	 * Symbol       Value
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000	
	 */
	private static String int2Roman(int value) {

		String s = String.valueOf(value);
		String result = "";
		for(int i = 0; i< s.length(); i++){
			int stage = (int) Math.pow(10, s.length()-1-i);
			result = parse2Roman(result, s.charAt(i), stage);
		}
		
		return result;
	}

	private static String parse2Roman(String result, char c, int stage) {
		if(stage == 1000){
			for(int i = 0; i < c - '0' ;i++) result += "M";
		}else if(stage == 100){
			if(c == '4' || c == '9')
				result += c == '4' ? "CD" : "CM";
			else{
				if(c-'0' > 5){
					result += "D";
					c -= 5;
				}
				for(int i = 0; i< c - '0';i++)
					result += "C";
			}
		}else if(stage == 10){
			if(c == '4' || c == '9')
				result += c=='4' ? "XL" : "XC";
			else{
				if(c-'0' > 5){
					result += "L";
					c -= 5;
				}
				for(int i = 0; i< c-'0';i++)
					result += "X";
			}
		}else{
			if(c == '4' || c == '9')
				result += c=='4'?"IV":"IX";
			else{
				if(c-'0' > 5){
					result += "V";
					c -= 5;
				}
				for(int i = 0;i<c-'0';i++)
					result += "I";
			}
		}
		return result;
	}
}
