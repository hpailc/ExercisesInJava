package string.length;

public class LengthOfLastWord {
	public static void main(String[] args) {
		String s = "a";
		System.out.println(lengthOfLastWord(s));
	}

	public static int lengthOfLastWord(String s) {
		return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
	}
}
