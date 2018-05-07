package string.substring;

/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 *
 */
public class IndexOfNeedle {
	public static void main(String[] args) {
		String haystack = "mississippi";
		String needle = "issip";
		int index = strStr(haystack, needle);
		System.out.println(index);
	}

	public static int strStr(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}
	}
}
