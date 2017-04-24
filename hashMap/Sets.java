package hashMap;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


class person{
	private int id;
	private String name;

	public person(int id, String name){
		this.id = id;
		this.name = name;
	}
	public String toString(){
		return "{ID is: " + id + ": Name is: " + name + "}";

	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		person other = (person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

}


public class Sets {

	public static void main(String[] args) {

		        person p1 = new person(0,"ritu");
				person p2 = new person(1,"shilpa");
				person p3 = new person(2,"tejal");
				person p4 = new person(1,"shilpa");

				Map<person,Integer> map = new LinkedHashMap<person,Integer>();

		map.put(p1,4);
		map.put(p2,5);
		map.put(p3,6);
		map.put(p4,7);

		for(person key: map.keySet()){
			System.out.println(key + ": " + map.get(key));
		}

		Set<person> set = new LinkedHashSet<person>();

		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		
		System.out.println(set);
	}
}