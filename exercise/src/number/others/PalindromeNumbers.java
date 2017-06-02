package number.others;

/**
 * �ж�һ��������ֵ�ǲ��ǻ������� Determine whether an integer is a palindrome. Do this without
 * extra space.
 * 
 * @author Administrator
 *
 */
public class PalindromeNumbers {

	public static void main(String[] args) {
		int x = 1234321;
		boolean flag = isPalindromeNumbers_1(x);
		System.out.println(flag);
	}

	/***************************************
	 * LeetCode
	 ***************************************
	 * ˼·��ֵ�ý���ĵط��ǣ���whileѭ������������Ϊ:x>rev
	 * �������ĺô��ǣ����ý�������ֵ��ȫ��ת�����ٽ����жϣ�ֻ�÷�תһ������жϾͿ����ˣ�
	 * ��ʡ��һ���ʱ�䣬ͬʱ���õ���ȥ�������������
	 * 
	 * @param x
	 * @return
	 */
	private static boolean isPalindromeNumbers_1(int x) {

		int rev = 0;
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}

		return rev == x || rev / 10 == x;
	}

	/**************************
	 * ԭ��
	 **************************
	 * ˼·���ǽ������������ֵ���з�ת��Ȼ����ԭ����ֵ���бȽ� ע�⣺ 1�������в�û���漰����ֵԽ�����⣻ 2����������false
	 * 
	 * @param x
	 * @return
	 */
	private static boolean isPalindromeNumbers(int x) {

		int reverse = 0;
		int y = x;
		while (y != 0) {
			reverse = reverse * 10 + y % 10;
			y = y / 10;
		}
		if (reverse == x && x >= 0) {
			return true;
		}
		return false;
	}

}
