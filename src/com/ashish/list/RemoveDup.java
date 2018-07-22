package com.ashish.list;

import java.util.HashSet;

class Node{
	int data;
	Node next;
}
public class RemoveDup {
	
	public static void main(String[] args) {
		System.out.println("Number of Node");
		int [] values = {1,1,2,3,2,1,3,4,5,5};
		Node head = ListUtil.createListFromArray(values);
		ListUtil.printList(head);
		removeDuplicatesHashTable(head);
		removeDuplicateWithoutHashTable(head);
		System.out.println("");
		ListUtil.printList(head);
		
	}
	public static void removeDuplicatesHashTable(Node head){
		HashSet<Integer> hashTable = new HashSet<>();
		Node current = head;
		Node prev = null;
		while(current!=null){
			if(hashTable.contains(current.data)){
				prev.next = current.next;
			}else{
				prev = current;
				hashTable.add(current.data);
			}
			current = current.next;
		}
	}
	public static void removeDuplicateWithoutHashTable(Node head){
		Node current = head;
		while(current != null){
			Node runner = current;
			while(runner.next != null){
				if(runner.next.data == current.data){
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	
	
}

