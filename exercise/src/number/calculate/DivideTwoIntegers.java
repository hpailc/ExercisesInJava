package number.calculate;

/*
 *  两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 
 * 示例一：
 * 		输入: dividend = 10, divisor = 3
 * 		输出: 3
 * 
 * 示例二：
 * 		输入: dividend = 7, divisor = -3
 * 		输出: -2
 * 
 * 说明:
 * 		被除数和除数均为 32 位有符号整数。
 * 		除数不为 0。
 * 		假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class DivideTwoIntegers {

	public static void main(String[] args) {
		
		System.out.println(divide(100, 3));
	}

	private static int divide(int dividend, int divisor) {

		if(dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		if(dividend > 0 && divisor > 0) return dividHelper(-dividend, -divisor);
		else if(divisor > 0) return -dividHelper(dividend, -divisor);
		else if(dividend > 0) return -dividHelper(-dividend, divisor);
		else return dividHelper(dividend, divisor);
	}

	private static int dividHelper(int dividend, int divisor) {
		if(divisor < dividend) 
			return 0;
		int cur = 0;
		int res = 0;
		while( (divisor << cur) >= dividend && divisor << cur < 0 && cur <31) cur++;
		res = dividend - (divisor << cur-1);
		if(res > divisor) return 1 << cur-1;
		return (1 << cur-1) + divide(res, divisor);
	}
	
}
