package com.adesh;

import java.util.Scanner;

public class KnapsackDP {
	public static int knapsack(int P[], int m, int wt[], int n) {
		int i, w;
		int k[][] = new int[n+1][m+1];
		for(i=0;i<=n;i++) {
			for(w=0;w<=m;w++) {
				if(i == 0 || w == 0)
					k[i][w] = 0;
				else if(wt[i-1] <= w)
					k[i][w] = Math.max(k[i-1][w], (k[i-1][w - wt[i-1]] + P[i-1]));
				else
					k[i][w] = k[i-1][w];
			}
		}
		return k[n][m];				
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter no of items");
		int n = s.nextInt();
		int P[] = new int[n];
		System.out.println("Enter the profit in order of wieighs");
		for(int i = 0;i<n;i++)
			P[i] = s.nextInt();
		System.out.println("Enter wieghts");
		int wt[] = new int[n];
		for(int i = 0;i<n;i++)
			wt[i] = s.nextInt();
		System.out.println("Enter capacity");
		int m = s.nextInt();
		System.out.println("The profit is" + knapsack(P, m, wt, n));
		s.close();
	}	
}