package com.adesh;

import java.util.Scanner;

class  Euclid{
	 public static int gcd (int m, int n) {
		while(n != 0) {
			int r = (m % n);
			m = n;
			n = r;	
		}
		return m;
	}
	
}
public class Gcd {
	public static void main(String[] args) {
		int m, n;
		Scanner s = new Scanner(System.in);
		m = s.nextInt();
		n = s.nextInt();
		s.close();
		System.out.println(Euclid.gcd(m, n));
	}
}
