package com.adesh;
import java.util.*;
public class PrimsAl {
	public static int V;
	static int minKey(int key[], Boolean mstSet[]) {
		int min = Integer.MAX_VALUE, minIndex = -1;
		for(int v= 0; v<V; v++) 
			if(mstSet[v] == false && key[v] < min) {
				min = key[v];
				minIndex = v;
		}
		return minIndex;
	}
	static void printMST(int parent[], int graph[][]) {
		System.out.println("Edge \tWeight");
		for(int i = 1;i<V;i++)
			System.out.println(parent[i] + "-"+ i + "\t" + graph[i][parent[i]]);
	}
	static void primMST(int graph[][]) {
		int parent[] = new int[V];
		int key[] = new int[V];
		Boolean[] mstSet = new Boolean[V];
		for(int i = 0;i < V;i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		for(int y = 0; y<V-1;y++) {
			int u = minKey(key, mstSet);
			mstSet[u] = true;
			for(int v = 0;v<V;v++) 
				if(graph[u][v] !=0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
			}
		}
		printMST(parent, graph);			
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		V = s.nextInt();
		int[][] graph = new int[V][V];
		for(int i = 0;i<V;i++)
			for(int j = 0;j<V;j++)
				graph[i][j] = s.nextInt();
		primMST(graph);
		s.close();
	}

}
