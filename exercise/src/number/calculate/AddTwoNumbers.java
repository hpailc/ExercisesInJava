package number.calculate;

import java.util.LinkedList;
import java.util.List;

public class AddTwoNumbers {

	public static void main(String[] args) {
		List<Integer> list1 = new LinkedList<>();
		list1.add(2);
		list1.add(4);
		list1.add(3);
		List<Integer> list2 = new LinkedList<>();
		list2.add(5);
		list2.add(6);
		list2.add(9);

		List<Integer> result = addTwoNumbers(list1, list2);

		System.out.println(result.toString());
		
		
	}

	
	
	private static List<Integer> addTwoNumbers(List<Integer> list1, List<Integer> list2) {

		List<Integer> result = new LinkedList<>();
		boolean exceed = false;
		for (int i = 0; i < list1.size(); i++) {
			int temp = 0;
			if (exceed) {
				exceed = false;
				temp = list1.get(i) + list2.get(i) + 1;
			} else {
				temp = list1.get(i) + list2.get(i);
			}
			if (temp > 9) {
				temp = temp - 10;
				exceed = true;
			}
			result.add(temp);
			if (i == list1.size() - 1 && exceed) {
				result.add(1);
			}
		}
		return result;
	}
}
