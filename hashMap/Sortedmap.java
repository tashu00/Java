package hashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Sortedmap {

	public static void main(String[] args) {
		
		HashMap<Integer,String> hashMap = new HashMap<Integer,String>();
		LinkedHashMap<Integer,String> linkedmap = new LinkedHashMap<Integer,String>();
		TreeMap<Integer,String> treemap = new TreeMap<Integer,String>();
		
		testMap(treemap);
	}
	
	public static void testMap(Map<Integer,String> map){
		map.put(8,"apple");
		map.put(5,"grapes");
		map.put(2,"orange");
		map.put(6,"barries");
		map.put(4,"kiwi");
		map.put(7,"beans");
		map.put(3,"rice");
		map.put(1,"wheat");
		
		for(Integer key: map.keySet()){
			String value = map.get(key);
			
			System.out.println(key + ": " + value);
		}

	}

}
