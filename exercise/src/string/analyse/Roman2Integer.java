package string.analyse;

public class Roman2Integer {

	public static void main(String[] args) {
		String s = "MCMXCIV";
		int value = romanToInt_2(s);
		System.out.println(value);

	}

	private static int romanToInt_2(String s) {
		int result = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int c = s.charAt(i);
			int pre = i > 0 ? s.charAt(i - 1) : 0;
			if ((c == 'V' || c == 'X') && pre == 'I') {
				result += c == 'V' ? 4 : 9;
				i--;
			} else if ((c == 'L' || c == 'C') && pre == 'X') {
				result += c == 'L' ? 40 : 90;
				i--;
			} else if ((c == 'D' || c == 'M') && pre == 'C') {
				result += c == 'D' ? 400 : 900;
				i--;
			} else {
				switch (c) {
				case 'I':
					result += 1;
					continue;
				case 'V':
					result += 5;
					continue;
				case 'X':
					result += 10;
					continue;
				case 'L':
					result += 50;
					continue;
				case 'C':
					result += 100;
					continue;
				case 'D':
					result += 500;
					continue;
				case 'M':
					result += 1000;
					continue;
				}
			}
		}
		return result;
	}

	private static int romanToInt_1(String s) {

		int result = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (i != 0 && isPreBigger(s.charAt(i), s.charAt(i - 1))) {
				result += intValue(s.charAt(i)) - intValue(s.charAt(--i));
			} else {
				result += intValue(s.charAt(i));
			}
		}
		return result;
	}

	private static boolean isPreBigger(char c1, char c2) {
		return intValue(c1) > intValue(c2) ? true : false;
	}

	private static int intValue(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

	/*
	 * 最直观的方法，但是看起来有点长
	 */
	private static int romanToInt(String s) {

		if (s == null || s.equals(""))
			return 0;
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'M':
				result += 1000;
				continue;
			case 'D':
				result += 500;
				continue;
			case 'C':
				if (s.charAt(i + 1) == 'D') {
					result += 400;
					i++;
				} else if (s.charAt(i + 1) == 'M') {
					result += 900;
					i++;
				} else {
					result += 100;
				}
				continue;
			case 'L':
				result += 50;
				continue;
			case 'X':
				if (s.charAt(i + 1) == 'L') {
					result += 40;
					i++;
				} else if (s.charAt(i + 1) == 'C') {
					result += 90;
					i++;
				} else {
					result += 10;
				}
				continue;
			case 'V':
				result += 5;
				continue;
			case 'I':
				if (s.charAt(i + 1) == 'V') {
					result += 4;
					i++;
				} else if (s.charAt(i + 1) == 'X') {
					result += 9;
					i++;
				} else {
					result += 1;
				}
				continue;
			}
		}
		return result;
	}
}
