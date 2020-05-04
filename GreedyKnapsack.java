package com.adesh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 class Item {
    Double cost; 
    double wt, val, ind; 
    public Item(int wt, int val, int ind) 
    { 
        this.wt = wt; 
        this.val = val; 
        this.ind = ind; 
        cost = new Double(val/wt ); 
    } 
} 
public class GreedyKnapsack {

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter no of weight and elements");
		int n = s.nextInt();
		int[] weight  = new int[n];
		int[] value = new int [n];
		System.out.println("Enter wieghts");
		for(int i=0; i<n; i++)
			weight[i] = s.nextInt();
		System.out.println("Enter values");
		for(int i=0; i<n; i++)
			value[i] = s.nextInt();
		System.out.println("Enter Capacity");
		int capacity = s.nextInt();
		s.close();	
		System.out.println("Maximum Profit is" + knapSack(weight, value, capacity));
		
	}
	public static double knapSack(int weight[], int value[], int capacity) throws Exception{
		Item[] val = new Item[weight.length]; 
		for(int i = 0; i< weight.length; i++)
			val[i] = new Item(weight[i], value[i], i);
		Arrays.sort(val, new Comparator<Item>() {
			@Override
			public int compare (Item obj1, Item obj2) {
				return obj2.cost.compareTo(obj1.cost) ;
			}
		});
		Double maxProfit = 0.0;
		for(Item i : val) {
			int currWie = (int) i.wt;
			double currVal = i.val;
			if(capacity - currWie >= 0) {
				capacity = capacity - currWie;
				maxProfit = maxProfit + currVal;	
			}
			else {
				double frac = ((double)capacity / currWie);
				maxProfit = maxProfit +  (frac*currVal);
				capacity = (int)(capacity - (currWie*frac));
				break;
			}
		}
		return maxProfit;
	}
}
