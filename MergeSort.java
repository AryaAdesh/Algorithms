package com.adesh;

import java.util.Random;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		System.out.println("Enter the no of elements");
		int n = s.nextInt();
		int[] a = new int[n];
		for(;;) {
		System.out.println("Enter choice : ");
		System.out.println("1.Best case senario\n 2.Average case senario\n 3.Worst case senario");
		int ch = s.nextInt();
		switch(ch) {
		case 1 : System.out.println("Best case");
					for(int i = 0; i<n;i++) 
						a[i] = i;
					System.out.println("Time taken best and sorted array are :" + (start(a, n)/1000000000) +"s");
					break;
		case 2: System.out.println("Average Case");
				for(int i = 0;i<n;i++)
					a[i] = r.nextInt(n);
				System.out.println("Time taken average and sorted array are :" + (start(a, n)/1000000000) +"s");
				break;
		case 3: System.out.println("Worst Case");
				for(int i = 0; i<n ; i++)
					a[i] = n-i;
				System.out.println("Time taken for worst and sorted array are :" + (start(a, n)/1000000000) +"s");
				break;
			}
		}	
	}
	static double start(int[] a, int n) {
		double start, stop;
		start = System.nanoTime();
		mergesort(a, 0, n-1);
		stop = System.nanoTime();
		display(a);
		return stop-start;	
	}
	private static void display(int[] a) {
		for(int g=0;g<a.length;g++)
			System.out.println(a[g]);
		
	}
	private static void mergesort(int[] a, int low, int high) {
		int mid;
		if(high > low) {
		mid = (low + high)/2;
		mergesort(a, low, mid);
		mergesort(a, mid+1, high);
		merge(a, low, mid, high);
		}
	}
	private static void merge(int[] a, int low, int mid, int high) {
		int k,h = low,j = mid+1,i = low;
		int[] b = new int[a.length];
		while(h<=mid && j<= high) {
			if(a[h] <= a[j])
				b[i++] = a[h++];
			else
				b[i++] = a[j++];					
		}
		if(h>mid) {
			for(k = j; k<=high; k++)
				b[i++] = a[k];
		}
		else {
			for(k = h;k<=mid;k++)
				b[i++] = a[k];
		}
		for(k = low; k<=high; k++) {
			a[k] = b[k];
		}	
	}
}

