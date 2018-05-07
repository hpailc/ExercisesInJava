package work.analyze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SplitLine2SomeParts {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("data\\abc.txt")));
		
		String line1 = reader.readLine();
		String line2 = reader.readLine();
		reader.close();
		
		String[] mem1 = line1.split(",");
		String[] mem2 = line2.split(",");
		
		for(int i = 0;i<mem1.length;i++){
			System.out.println("\tfloat " + mem1[i].split("\"")[1].toLowerCase() + ";\t/* " + mem2[i] + " */");
		}
	}
}
