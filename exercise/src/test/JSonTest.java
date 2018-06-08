package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class JSonTest {

	@Test
	public void test2Json() throws IOException{
		Person p = new Person();
		p.setName("zhangsan");
		p.setAge(20);
		
		FileWriter fw = new FileWriter(new File("D:\\abc.txt"));
		fw.write(p.toString());
		
		fw.write(p.toString());
		fw.close();
	}
	
	@Test
	public void testFromJson() throws IOException{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\abc.txt"))));
		String line;
		while((line = bufr.readLine())!=null){
			Person p = new Person().fromString(line);
			System.out.println(p.getName());
			System.out.println(p.getAge());
		}
		bufr.close();
	}
}
