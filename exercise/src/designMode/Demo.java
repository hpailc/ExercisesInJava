package designMode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Demo {
	
/*	"name",
	"email",
	"address",
	"job",
	"hobits",
	"age"*/
	@Test
	public void testSetAndGet() throws IOException{
		Person p = new Person();
		p.set("name", "zhangsan");
		p.set(2, "zhangsan@sina.com");
		p.set("address", "北京海淀");
		p.set("job", "programmer");
		p.set("hobits", "台球");
		p.set(6, 20);
		
		FileWriter fw = new FileWriter(new File("D:\\a.txt"));
		fw.write(p.toString());
		
		System.out.println(p.get("name"));
		System.out.println(p.get("email"));
		System.out.println(p.get("address"));
		System.out.println(p.get("job"));
		System.out.println(p.get("hobits"));
		System.out.println(p.get("age"));
		
		fw.close();
	}
	
	@Test
	public void testReadJson() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\a.txt")));
		String len;
		while((len=br.readLine())!=null){
			Person p = new Person();
			p.fromString(len);
			System.out.println(p);
		}
		br.close();
		
	}
	
	@Test
	public void testIndexOfList(){
		String strs[] = {"name","age"};
		List<String> list = Arrays.asList(strs);
		
		System.out.println(list.indexOf("name"));
		
	}
}
