package gitHubPracties;

import java.util.Arrays;

public class Program3 {

	public static void main(String[] args) {
		 
//		int a = 5;
//		int b = 10;
//		int sum = 0;
//		 for(int i = a; i <=b; i++){
//			 System.out.println("numbers btw a to b is = "+ i);
//			 sum = sum + i;
//			 System.out.println("sum of all numbers is = "+ sum);
//		 }
//		 //System.out.println("sum of all numbers is = "+ sum);
		
		int[][] a = {{1,2,3,4},{1,2,3,4,5}};
		int [] b = new int[4];
		for(int m = 0; m < a.length; m++)
		{
			System.out.println(Arrays.toString(a[m]));
			for(int n = 0; n < a[m].length; n++)
			{
				System.out.println(a[m][n]);
				
				if(a[m][n]!= 0){
					
				}
				
			}
			
		}
	}

}
