package com.ashish.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUsingBFS extends Graph{

	public ShortestPathUsingBFS(int numberOfVertices) {
		super(numberOfVertices);
	}
	public String printArray(int[] arr){
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i = 0; i< arr.length; i++){
			sb.append(arr[i]+",");
		}
		sb.append("]");
		return sb.toString();
	}
	public int getShortestPath(int u, int v){

		int distanceArr[] = new int[V];
		for (int i = 0; i < V; i++) {
			distanceArr[i] = -1;
        }
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(u);
		visited[u] = true;
		distanceArr[u] =0;
		
		
		while(!queue.isEmpty()){
			int node = queue.poll();
			for(int connectedNode: adj[node]){
				if(!visited[connectedNode]){
					distanceArr[connectedNode] = distanceArr[node]+1;
					System.out.println("node:"+connectedNode+", distance="+printArray(distanceArr));
					queue.add(connectedNode);
					visited[connectedNode] = true;
					
				}
				
			}
		}
		for(int i = 0; i< visited.length; i++){
			System.out.print(visited[i]+",");
		}
		return distanceArr[v];
		
	}
	
	public static void main(String[] args) {
		
		ShortestPathUsingBFS bfs = new ShortestPathUsingBFS(10);
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 7);
		bfs.addEdge( 1, 7);
		bfs.addEdge( 1, 2);
		bfs.addEdge(2, 3);
		bfs.addEdge( 2, 5);
		bfs.addEdge( 2, 8);
		bfs.addEdge( 3, 4);
		bfs.addEdge(3, 5);
		bfs.addEdge( 4, 5);
		bfs.addEdge( 5, 6);
		bfs.addEdge( 6, 7);
		bfs.addEdge( 7, 8);
		bfs.addEdge( 7, 0);
		bfs.addEdge( 9, 9);
		System.out.println(bfs.getShortestPath(7, 4));

		
	}

}
