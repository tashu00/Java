package gitHubPracties;

import java.util.Arrays;

public class Program2 {

	public static void main(String[] args) {

		int[][] a = {{4,5,1,3},{13,27,18,26},{32,35,37,39},{1000,1001,857,1}};
		int[] b = new int[a.length];
		for(int i= 0; i < a.length; i++)
		{
			System.out.println("for i = "+ i + " Array = "+Arrays.toString(a[i]));
			int maxNum = a[i][0];
			System.out.println("Max number "+ maxNum);
			for(int j= 0; j < a[i].length; j++)
			{
				System.out.println("for j = "+ j + " a[i][j] = "+a[i][j]);
				if(a[i][j] > maxNum)
				{
					maxNum = a[i][j];
				}

			}
			System.out.println("MaxNum in each array " + maxNum);
			b[i] = maxNum;
			System.out.println("Here is new array b "+ Arrays.toString(b));
		}
	}

}
