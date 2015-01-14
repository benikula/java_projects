package collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		
		list1.add("first");
		list1.add("second");
		list1.add("third");
		
		list2.addAll(list1);
		
		System.out.println(list1.get(2));
		
		for (Object o : list1)
		    System.out.println(o);
		
		for (Object o : list2)
		    System.out.println(o);
		
		System.out.println(list1.equals(list2));
		
		System.out.println(list1.remove(2));
		System.out.println(list1);
		System.out.println(list2.containsAll(list1));
		
		String[] s = list2.toArray(new String[0]);;
		
		System.out.println(s);
		
		System.out.println("\n");
		System.out.println(list2.indexOf("first"));
		
	}

}
