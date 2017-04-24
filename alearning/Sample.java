package alearning;
import polymorphism.Shape;

public class Sample {
	
	int x;	// class variable(no need to initialize) + instance variable, always
			// need an object before using 
	String y;	// same as above
	private boolean isPrime;	// same as above
	protected Integer newInt;	// same as above
	public Shape myShape;	// same as above, need to import user-defined class if not part of same package
	public static int a;	// class variable(no need to initialize) + static variable, 
							//can be used from both static and non-static methods
	
	public int myLogicMethod(int a, int b){
		return a+b+x;
	}
	public void myLogicMethod2(int a){
		myLogicMethod(3,4);	// instance method can call another instance method or variable without object.
		myStaticMethod("vikas");	//can always call static methods since static have just one copy on class level, so no confusion
	}
	public static void myStaticMethod(String z){
		int aa;		// local variable- need to be initialized before use.
		System.out.println(a);
		//System.out.println(x);// x can't be called from static method without object. Compiler confused which particular x to call
		aa=10;	// initialized before use - so works fine
		System.out.println(aa);
		System.out.println("z= "+z);
		}
	
	public static void main(String[] args){
		//System.out.println(x);// x can't be called from static method without object
		System.out.println("a = "+a);
		
		Sample refSample = new Sample();
		System.out.println("x = "+refSample.x);
		System.out.println("isPrime = "+refSample.isPrime);	// since class variable-so already initialized by constructor
		
		System.out.println("myShape = "+refSample.myShape);	// since class variable-so already initialized by constructor, since reference variable so null
		
		myStaticMethod("vinay");
		Sample.myStaticMethod("vinay"); // need class name if called outside of this class.
		
		//myLogicMethod(3,4); // since non-staic (instance) method, needs an object
		//Sample.myLogicMethod(3,4); // class name is not enough, object is needed.
		refSample.myLogicMethod(3,4);
		
	}
	
}
