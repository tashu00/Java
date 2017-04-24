package gitHubPracties;

public class program1 {

	public static void main(String[] args) {
       int n = 5;
       int multi = 1;
		for(int i = 1;i <= n; i++ ){
			 multi = multi * i;
			 System.out.println("calculation "+multi+ "*"+ i +"= "+multi);
		}
        System.out.println(multi);
	}

}
