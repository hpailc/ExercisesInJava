package number.others;

/**
 * �������������ֵ�����������
 * Reverse digits of an integer. Example1: x = 123, return 321 Example2: x =
 * -123, return -321 Note: The input is assumed to be a 32-bit signed integer.
 * Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {

	public static void main(String[] args) {
		int x = 1534236469;
		int y = reverseInteger(x);
		System.out.println(y);
	}

	private static int reverseInteger(int x) {

		int result = 0;

		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			//ͨ���жϼ��������ֵ��ԭ��ֵ�ĶԱȣ����ж����������ֵ�Ƿ�Խ��
			if ((newResult - tail) / 10 != result) {
				return 0;
			}
			result = newResult;
			x = x / 10;
		}

		return result;
	}
}
