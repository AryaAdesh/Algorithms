import java.util.Scanner;

public class Sieve {

	public static void main(String[] args) {
		int j = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = s.nextInt();
		s.close();
		int a[] = new int[n];
		for(int p = 2;p < n;p++)
			a[p] = p;
		for(int p = 2;p<Math.sqrt((double)n);p++)
			if(a[p] != 0) {
				j =p * p;
				while(j <= n) {
					a[j] = 0;
					j = j+p;
				}
			}
		
		for(int p =0; p<n;p++)
			if(a[p] != 0)
				System.out.println(a[p]);
	}

}
