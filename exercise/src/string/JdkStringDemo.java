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
		int testInt[] = {1,'a','b'};	//�ַ�'a','b'....����ֱ�ӵ��� int ����ʹ��
		for(int content : testInt){
			System.out.println(content);
		}
		char x = 58;					// int ����Ҳ����ֱ�ӵ��� char ʹ��
		System.out.println(x);
	}
}
