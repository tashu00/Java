package hashMap;

import java.util.LinkedList;

public class Iterator {

	public static void main(String[] args) {
		
		LinkedList<String> animals = new LinkedList<String>();
		
		animals.add("cat");
		animals.add("fox");
		animals.add("rat");
		animals.add("bat");
		animals.add("owl");
		
		for(String animal: animals){
			System.out.println(animal);
		}
	}

}
