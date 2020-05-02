import java.util.Scanner;

public class Common {

	public static void main(String[] args) {
		int a[] = new int[21];
		int b[] = new int[20];
		Scanner s = new Scanner(System.in);
		System.out.println("Enter no");
		int n = s.nextInt();
		int m = s.nextInt();
		for(int i =0;i<n;i++)
			a[i] = s.nextInt();
		for(int j =0;j<m;j++)
			b[j] = s.nextInt();
		s.close();
		for(int i =0;i<n;i++)
			for(int j =0;j<m;j++)
				if(a[i] == b[j])
					System.out.println(a[i]);
	}

}
