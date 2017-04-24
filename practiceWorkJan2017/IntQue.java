package practiceWorkJan2017;

//public class IntQue {
//
//	public static void main(String[] args) {

//		int result = 0;
//		short s = 42;
//		Long x = new Long("42");
//		Long y = new Long(42);
//		Short z = new Short("42");
//		Short x2 = new Short(s);
//		Integer y2 = new Integer("42");
//		Integer z2 = new Integer(42);
//
//		if (x == y)
//			result = 1;
//		if (x.equals(y) ) 
//			result = result + 10;
//		if (x.equals(z) ) 
//			result = result + 100;
//		if (x.equals(x2) ) 
//			result = result + 1000;
//		if (x.equals(z2) ) 
//			result = result + 10000;
//
//		System.out.println("result = " + result);

class Test1 {   
    Test1(int x) {
        System.out.println("Constructor called " + x);
    }
}
  
// This class contains an instance of Test1 
class IntQue {    
    Test1 t1 = new Test1(10);   
  
    IntQue(int i) { t1 = new Test1(i); } 
  
    public static void main(String[] args) {    
    	IntQue t2 = new IntQue(5);
    	
    }
}

