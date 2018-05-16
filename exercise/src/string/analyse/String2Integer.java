package string.analyse;

public class String2Integer {

	public static void main(String[] args) {

		// System.out.println(Integer.MAX_VALUE);//2147483647

		String s = "+";
		int result = myAtio_1(s);
		System.out.println(result);
	}

	private static int myAtio_1(String str) {

		if (str == null || str == "")
			return 0;
		int i = -1;
		int sign = 0;
		int num = 0;
		while (++i < str.length()) {
			char c = str.charAt(i);
			if (sign == 0) {
				if (c == ' ')
					continue;
				else if (c == '-')
					sign = -1;
				else if (c == '+')
					sign = 1;
				else if (c >= '0' && c <= '9') {
					sign = 1;
					num = c - '0';
				} else
					return 0;
			} else if (Character.isDigit(c)) {
				int newNum = num * 10 + (c - '0') * sign;
				if(newNum != 0 && (Integer.signum(newNum) != sign || (newNum - (c-'0') * sign ) / 10 != num )){
					return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				num = newNum;
			} else {
				return num;
			}
		}

		return num;
	}

	private static int myAtio(String str) {
		str = str.trim();
		boolean isMinus = false;

		if (str.length() > 0) {
			if (str.charAt(0) == '-') {
				isMinus = true;
				str = str.substring(1);
			} else if (str.charAt(0) == '+') {
				str = str.substring(1);
			}
		}

		StringBuffer sb = new StringBuffer();
		if (str.equals("") || str.charAt(0) < '0' || str.charAt(0) > '9')
			return 0;
		int i = 0;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			sb.append(str.charAt(i++));
		}
		int result;
		try {
			result = Integer.parseInt(sb.toString());
		} catch (NumberFormatException e) {
			return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		return isMinus ? -1 * result : result;
	}
}
