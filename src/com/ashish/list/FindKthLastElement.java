package com.ashish.list;

public class FindKthLastElement {

	public static void main(String[] args) {
		System.out.println("Number of Node");
		int[] values = { 1, 1, 2, 3, 2, 1, 3, 4, 5, 5 };
		int k = 3;
		Node head = ListUtil.createListFromArray(values);
		ListUtil.printList(head);
		System.out.println("");
		System.out.println("Kth:" + getKthLastElement(head, k));
		getKthLastElementRecursive(head, k);
		FindKthLastElement.counter counter = new FindKthLastElement.counter();
		counter.val = 0;
		getKthLastElementByPassByRefrence(head, k, counter);

	}

	public static int getKthLastElement(Node head, int k) {

		if (head == null) {
			return -1;
		}
		int count = 1;
		Node current = head;
		Node KthNode = head;
		while (current != null) {
			if (k < count) {
				KthNode = KthNode.next;
			}
			current = current.next;
			count++;
		}
		return (k > count ? -1 : KthNode.data);

	}
	public static int getKthLastElementRecursive(Node head, int k){
		if(head == null)
			return 0;
		int val = getKthLastElementRecursive(head.next, k)+1;
		if(val == k){
			System.out.println("Kth Element:"+head.data);
		}
		return val;
	}
	
	public static Node getKthLastElementByPassByRefrence(Node head, int k, FindKthLastElement.counter counter){
		if(head == null)
			return null;
		
		Node node = getKthLastElementByPassByRefrence(head.next, k, counter);
		counter.val = counter.val + 1;
		if(counter.val == k){
			System.out.println("node data:"+head.data);
			return head;
		}
		return node;
		
	}
	static class counter{
		int val;
	}
}
