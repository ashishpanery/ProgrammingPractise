package com.ashish.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	 int V;
	protected LinkedList<Integer> adj[];
	
	public Graph(int numberOfVertices) {
		V = numberOfVertices;
		adj = new LinkedList[numberOfVertices];
		for(int i = 0; i< numberOfVertices; i++){
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	public void DFS(int sourceNode, boolean visited[]){
		
		if(!visited[sourceNode]){
			System.out.println(sourceNode);
			visited[sourceNode] = true;
			adj[sourceNode].forEach(node->{
				DFS(node, visited);
			});
		}
	}
	public void DFS(int sourceNode){
		boolean visited[] = new boolean[V];
		for(int i =0 ; i< V; i++){
			visited[i] = false;
		}
		DFS(sourceNode,visited);
	}
	
	public void BFS(int sourceNode){
		
		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[V];
		queue.add(sourceNode);
		visited[sourceNode] = true;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.println(node);
			adj[node].forEach(connectedNode -> {
				if(!visited[connectedNode]){
					queue.add(connectedNode);
					visited[connectedNode] = true;
				}

			});

		}
	}
	public boolean isCyclePresent(int sourceNode, boolean[] visited, boolean[] recStack){
		if(recStack[sourceNode])
			return true;
		visited[sourceNode] = true;
		recStack[sourceNode] = true;
		Iterator<Integer> node = adj[sourceNode].listIterator();
		while(node.hasNext()){
			int n = node.next();
			if(isCyclePresent(n, visited, recStack))
				return true;
			
		}
		recStack[sourceNode] = false;
		return false;
	}
	public boolean isCycle(){
		boolean[] visited = new boolean[V];
		boolean[] revStack = new boolean[V];
		for(int i =0 ; i< V; i++){
			if(isCyclePresent(i, visited, revStack)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
//		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
//		graph.addEdge(3, 3);
//		graph.DFS(2);
//		System.out.println("BFS");
//		graph.BFS(2);
		System.out.println(graph.isCycle());
		
		
	}
	

}
