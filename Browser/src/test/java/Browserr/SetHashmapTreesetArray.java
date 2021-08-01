package Browserr;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class SetHashmapTreesetArray {

	public static void main(String[] args) {


		ArrayList<String> de = new ArrayList<String>(Arrays.asList("ram","ram","shayam","kaam","naam"));

		de.add("pagal");
		de.add("Nalayak");
		System.out.println(de);

		de.remove(2);
		System.out.println(de);

		de.removeAll(Collections.singleton("ram"));
		System.out.println(de);

		ArrayList<Integer> dee = new ArrayList<Integer>(Arrays.asList(9,8,7,1,1,2,3,4,5));
		System.out.println(dee);

		TreeSet<String> map = new TreeSet<String>();
		map.add("C");
		map.add("F");
		map.add("A");
		map.add("H");
		map.add("X");
		map.add("D");
		map.add("Q");
		System.out.println(map);

		Set<String> def = new TreeSet<String>();
		def.add("o");
		def.add("B");
		def.add("A");
		def.add("o");
		def.add("o");
		System.out.println(def);
		
		int [] ch = {1,2,3,4,5,6};
		
		int i = 0;
		while(ch[i]>0) {
			System.out.println(ch[i]);
			i++;
			
		}
		
	}

}
