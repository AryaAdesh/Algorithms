package com.adesh;

import java.util.Scanner;

public class FloydWarshall {
	static final int  INF = 9999;
	public static int V;
	public static void floydWarshall(int graph[][]) {
		int dist[][] = new int[V][V];
		int i, j, k;
		for(i=0;i<V;i++)
			for(j=0;j<V;j++)
				dist[i][j] = graph[i][j];
		for(i=0;i<V;i++)
			for(j=0;j<V;j++)
				for(k=0;k<V;k++)
					if(dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
		print(dist);
		
		
	}

	private static void print(int[][] dist) {
		int i, j;
		for(i=0;i<V;i++) {
			for(j=0;j<V;j++) {
				if(dist[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}	
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the no of vertices");
		V = s.nextInt();
		int graph[][] = new int[V][V];
		System.out.println("Enter Cost Adjecency Matrix");
		for(int i = 0;i<V;i++)
			for(int j = 0;j<V;j++)
					graph[i][j] = s.nextInt();
		s.close();
		floydWarshall(graph);

	}

}
