package string;

import org.junit.Assert;
import org.junit.Test;

public class JdkStringDemo {

	@Test
	public void testInitialization(){
		String string = new String();
		Assert.assertTrue(string.equals(""));
	}
	
	@Test
	public void testCharIsInt(){
		int testInt[] = {1,'a','b'};	//字符'a','b'....可以直接当做 int 类型使用
		for(int content : testInt){
			System.out.println(content);
		}
		char x = 58;					// int 类型也可以直接当做 char 使用
		System.out.println(x);
	}
}
