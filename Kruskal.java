package com.adesh;

import java.util.Arrays;
import java.util.Scanner;

class Graph{
	class Edge implements Comparable<Edge>{
		int src, dest, weight;
		@Override
		public int compareTo(Edge compareEdge) {
			return this.weight - compareEdge.weight;
		}
		
	};
	class Subset{
		int parent, rank;
	};
	int V, E;
	Edge[] edge;
	Graph(int v, int e){
		edge = new Edge[e];
		V = v;
		for(int i = 0; i<e; i++)
			edge[i] = new Edge();
	}
	int find(Subset subsets[], int src_dsc) {
		if(subsets[src_dsc].parent != src_dsc)
			subsets[src_dsc].parent = find(subsets, subsets[src_dsc].parent );
		return subsets[src_dsc].parent;
	}
	void union(Subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		if(subsets[xroot].parent < subsets[yroot].parent)
			subsets[xroot].parent = yroot;
		else if(subsets[xroot].parent > subsets[yroot].parent)
			subsets[yroot].parent = xroot;
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
			
	}
	void kruskalsAl() {
		Edge[] result = new Edge[V];
		int e = 0;
		int i = 0;
		for(i = 0; i<V; i++)
			result[i] = new Edge();
		Arrays.sort(edge);
		Subset subsets[] = new Subset[V];
		for(i = 0; i<V; i++)
			subsets[i] = new Subset();
		for(int v = 0; v<V; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}
		i = 0;
		while(e < V-1) {
			Edge nextEdge = new Edge();
			nextEdge = edge[i++];
			int x = find(subsets, nextEdge.src);
			int y = find(subsets, nextEdge.dest);
			if(x != y) {
				result[e++] = nextEdge;
				union(subsets, x, y);
			}
		}
			System.out.println("The resultant MST is");
			for(i = 0;i<V-1;i++)
				System.out.println(result[i].src + "to" + result[i].dest + "weight" + result[i].weight);
		
		
		
		
	}
}
public class Kruskal {

	public static void main(String[] args) {
		System.out.println("Enter no of Vertices and edges");
		Scanner s = new Scanner(System.in);
		int vert = s.nextInt();
		int edges = s.nextInt();
		Graph G = new Graph(vert, edges);
		System.out.println("Enter Graph edge source, destination, weight");
		for(int i = 0; i<=vert; i++) {
			G.edge[i].src = s.nextInt();
			G.edge[i].dest = s.nextInt();
			G.edge[i].weight = s.nextInt();
		}
		s.close();
		G.kruskalsAl();
	}
}
