package polymorphism;

public class ExtraQue
{
	public static void main(String[] args)
	{
//		Second n = new Second(20); 
//		System.out.println(n.i);
//		
		String str = "geeks";
        str.toUpperCase();
        str += "forgeeks";
        String string = str.substring(2,13);
        string = string + str.charAt(4);;
        System.out.println(string);
	    
}

class First
{
	int i = 10;

	public First(int j)
	{
		System.out.println(i); 
		this.i = j * 10;
	}
}

class Second extends First
{
	public Second(int j)
	{
		super(j); 
		System.out.println(i); 
		this.i = j * 20;
	}
}

}


