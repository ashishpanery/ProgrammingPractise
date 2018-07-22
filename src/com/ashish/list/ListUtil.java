package com.ashish.list;

public class ListUtil {
	public static void printList(Node node){
		if(node==null){
			System.out.println("Null");
			return;
		}
		while(node!=null){
			System.out.print(node.data+"->");
			node = node.next;
		}
	}
	public static Node createListFromArray(int[] arr){
		Node head = new Node();
		head.data = 1;
		Node curr = head;
		for(int i = 1; i< arr.length; i++){
			Node node = new Node();
			node.data = arr[i];
			node.next = null;
			curr.next = node;
			curr = node;
		}
		return head;
	}
}
