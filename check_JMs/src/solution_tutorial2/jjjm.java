package solution_tutorial2;

import java.util.HashMap;
import java.util.Map;

public class jjjm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "AAABC BBBAD";
		
		String[] words = test.split(" ");
		String tom = words[0];
		String jerry = words[1];
		
		// Key, Value
		// map.put(key, value)
		// key = "a"
		// value = 1
		/*
		 * map = [ { "a", 1 } ]
		 */
		Map<String, Integer> map_tom = new HashMap<String, Integer>();
		Map<String, Integer> map_jerry = new HashMap<String, Integer>();
		
		for (int i = 0; i < tom.length(); i++) {
			String str = String.valueOf(tom.charAt(i));
			
			if (!map_tom.containsKey(str)) {
				map_tom.put(str, 1);
			}
			else {
				int val = map_tom.get(str) + 1;
				map_tom.put(str, val);
			}
		}
		
		for (int i = 0; i < jerry.length(); i++) {
			String str = String.valueOf(jerry.charAt(i));
			
			if (!map_jerry.containsKey(str)) {
				map_jerry.put(str, 1);
			}
			else {
				int val = map_jerry.get(str) + 1;
				map_jerry.put(str, val);
			}
		}
		
		System.out.println("Tom ---------------------");
		
		for (Map.Entry<String, Integer> entry : map_tom.entrySet()) {
			System.out.println("Key : " + entry.getKey() + ", " + "Value : " + entry.getValue());
		}
		
		System.out.println("Jerry --------------------");
		for (Map.Entry<String, Integer> entry : map_jerry.entrySet()) {
			System.out.println("Key : " + entry.getKey() + ", " + "Value : " + entry.getValue());
		}
		
		
		int maxTom = 0;
		int maxJerry = 0;
		String maxTomKey = "";
		String amxJerryKey = "";
		
		for (int val : map_tom.values()) {
			if (maxTom < val) {
				maxTom = val;
			}
		}
		
		for (int val : map_jerry.values()) {
			if (maxJerry < val) {
				maxJerry = val;
			}
		}
		
		System.out.println(maxTom);
		System.out.println(maxJerry);
	}
}
