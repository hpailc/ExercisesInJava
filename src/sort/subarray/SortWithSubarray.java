package sort.subarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortWithSubarray {

	public static void main(String[] args) throws Exception {
		int value[] = readArrayFromKeyboard();
		
	}

	/*
	 * 从键盘要读取要用来排序的属组
	 */
	private static int[] readArrayFromKeyboard() throws IOException {
		
		List<Integer> list = new ArrayList<Integer>();
		System.out.println("请依次输入数组中的数，以“exit”结束输入");
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String len;
		while(!(len=bufr.readLine()).equals("exit")){
			int value = Integer.parseInt(len);
			list.add(value);
		}
		
		int values[] = new int[list.size()];
		for(int i=0;i<list.size();i++){
			values[i] = list.get(i);
		}
		bufr.close();
		return values;
	}
}
