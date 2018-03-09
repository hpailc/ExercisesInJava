package string.analyse;

public class ZigZagConversion {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		String result = convret(s, 3);
		System.out.println(result);

	}

	private static String convret(String s, int num) {
		boolean down = true;
		StringBuffer[] bufs = new StringBuffer[num];
		for (int i = 0; i < num; i++)
			bufs[i] = new StringBuffer();

		int i = 0;
		while (i < s.length()) {
			for (int x = 0; x < num && i < s.length(); x++)
				bufs[x].append(s.charAt(i++));
			for (int x = num - 2; x > 0 && i < s.length(); x--)
				bufs[x].append(s.charAt(i++));
		}
		for (int x = 1; x < bufs.length; x++)
			bufs[0].append(bufs[x].toString());

		return bufs[0].toString();
	}
}
