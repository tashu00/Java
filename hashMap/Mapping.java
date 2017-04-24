package hashMap;

import java.util.HashMap;
import java.util.Map;

public class Mapping {

	public static void main(String[] args) {

		HashMap<Integer,String> map = new HashMap<Integer,String>();

		map.put(4,"Four");
		map.put(5,"Five");
		map.put(2,"Six");
		map.put(7,"Seven");
		map.put(8,"Eight");
		map.put(1,"Nine");
		map.put(1,"ten");

		//String text = map.get(5);
		//System.out.println(text);

		for(Map.Entry<Integer, String> entry:map.entrySet()){
			int key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println(key + ": " + value);

		}
	}

}
