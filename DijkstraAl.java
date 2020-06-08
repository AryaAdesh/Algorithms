package com.adesh;

import java.util.Scanner;

public class DijkstraAl {
	static int V;
	static int minDistance(int dist[], Boolean sptSet[]) {
		int min = Integer.MAX_VALUE, minIndex = -1;
		for(int v=0;v<V;v++) 
			if(sptSet[v] == false && dist[v] < min) {
				min = dist[v];
				minIndex = v;
		}
		return minIndex;
	}
	static void print(int dist[]) {
		System.out.println("Vertex \t\t Distance");
		for(int i = 0;i<V;i++)
			System.out.println(i + "\t\t" + dist[i]);
	}
	static void dijkstra(int graph[][], int src) {
		int dist[] = new int[V];
		Boolean sptSet[] = new Boolean[V];
		for(int i = 0;i<V;i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;
		for(int y =0 ; y<V-1;y++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;
			for(int v=0;v<V;v++) {
				if(!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] +graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
			}
		}
		print(dist);
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
		System.out.println("Enter Source");
		int src = s.nextInt();
		dijkstra(graph, src);
		s.close();
	}
}
