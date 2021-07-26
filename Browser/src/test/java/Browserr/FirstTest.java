package Browserr;

public class FirstTest {

	public void main(String[] args) {
		
		int intarray[]= {12,14,3,3,15,4,78};
//		Arrays.toString(intarray);
//		intarray = ArrayUtils.remove(intarray, 2);
//		
//		for(int s: intarray) {
//			System.out.println(s);
//		}
		

//		
//		Scanner sc= new Scanner(System.in);
//		System.out.println("Please enter a number");
//		int x = sc.nextInt();
//		System.out.println("The number u entered is : "+x);
		
		for (int i=0;i<=4;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("---------------");
		
		for( int i=0;i<=4;i++) {
			for( int j=4;j>=i;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	//Code change
		
	}


