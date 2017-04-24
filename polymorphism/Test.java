package polymorphism;

public class Test {

	public static void main(String[] args) {
		// this code is external system code
		Shape obj = new Circle(); //1
//		Circle obj2 = new Circle(); //2
//		NewCircle obj3 = new NewCircle();
		Shape obj4 = new NewCircle();
		
		myInterfaceMethod(obj4);
	}
	
	// code which I don't want to change ever
	//1
	public static void myInterfaceMethod(Shape s){
		//now calling business method-
		s.draw();
	}
	
//	//2
//	public static void myInterfaceMethod2(Circle obj){
//		//now calling business method-
//		obj.draw();
//	}
//	//3
//	public static void myInterfaceMethod3(NewCircle obj){
//		//now calling business method-
//		obj.draw();
//	}

}
