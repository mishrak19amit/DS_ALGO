package org.amit.LinkedList;

import org.amit.LinkedList.SwapTwoNodes.Node;

public class ReverseLinkedList {
	class Node {
		int data;
		Node next;

		Node(int val) {
			this.data = val;
			this.next = null;
		}
	}

	static Node root;

	void addNode(int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			Node head = root;
			while (head.next != null)
				head = head.next;
			head.next = new Node(data);
		}

	}
	
	public static void printNodes() {

		Node head = root;

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

	}
	
	
	public static void reverseList()
	{
		if(root==null) return;
		
		Node head=root;
		Node prev=null;
		Node nextNoode=head;
		while(nextNoode!=null)
		{
			nextNoode=head.next;
			head.next=prev;
			prev=head;
			head=nextNoode;
			
		}
		
		
		if(prev!=null)
			root=prev;
	}

	public static void main(String[] args) {

		ReverseLinkedList obj = new ReverseLinkedList();
		obj.addNode(7);
		obj.addNode(1);
		obj.addNode(3);
		obj.addNode(2);
		obj.addNode(4);
		obj.addNode(5);
		obj.addNode(6);
		
		printNodes();
		
		System.out.println();
		reverseList();
		
		printNodes();
		
	}

}
