package com.ashish.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

	public static void main(String[] args) {
		int arr[][] = { {2, 6, 12, 34},
						{1, 9, 20, 1000},
						{23, 34, 90, 2000}};
		int k = arr.length;
		int n = arr[0].length;
		System.out.println(Arrays.toString(mergeArray(arr, k, n)));
	}
	
	static int[] mergeArray(int[][] arr , int k, int n){
		
		PriorityQueue<MinHeapNode> queue = new PriorityQueue<>();
		int total = 0;
		for(int i = 0; i < k; i++){
			queue.add(new MinHeapNode(arr[i], 0));
			total = total + arr[i].length;
		}
		int[] output = new int[total];
		int m = 0;
		while(!queue.isEmpty()){
			MinHeapNode node = queue.poll();
			output[m++] = node.arr[node.i];
			if(node.i < node.arr.length-1){
				queue.add(new MinHeapNode(node.arr, node.i+1));
			}
		}
		
		return output;
	}
		
}
class MinHeapNode implements Comparable<MinHeapNode>{
	int[] arr;
	int i; //index of the array
	public MinHeapNode(int[] arr, int i) {
		this.arr = arr;
		this.i = i;
	}
	@Override
	public int compareTo(MinHeapNode o) {
		return this.arr[this.i] - o.arr[o.i];
	}
}
