package org.amit.LinkedList;

public class HalvesInCircularLL {
	static Node head, head1, head2;

	static class Node {

		int data;
		Node next, prev;

		Node(int d) {
			data = d;
			next = prev = null;
		}
	}
	
	
	void splitList()
	{
		Node temp=head;
		Node slow=head;
		Node fast=head.next.next;
		Node prev=head.next;
		while(fast!=temp)
		{
			slow=slow.next;
			prev=fast.next;
			fast=fast.next.next;
		}
		
		Node midNext=slow.next;
		
		slow.next=temp;
		head1=head;
		
		prev.next=midNext;
		head2=midNext;
		
		
		
	}

	/* Function to print nodes in a given singly linked list */
	void printList(Node node) {
		Node temp = node;
		if (node != null) {
			do {
				System.out.print(temp.data + " ");
				temp = temp.next;
			} while (temp != node);
		}
	}

	public static void main(String[] args) {
		HalvesInCircularLL list = new HalvesInCircularLL();

		// Created linked list will be 12->56->2->11
		list.head = new Node(12);
		list.head.next = new Node(56);
		list.head.next.next = new Node(2);
		list.head.next.next.next = new Node(11);
		list.head.next.next.next.next = list.head;

		System.out.println("Original Circular Linked list ");
		list.printList(head);
		// Split the list
		list.splitList();
		System.out.println("");
		System.out.println("First Circular List ");
		list.printList(head1);
		System.out.println("");
		System.out.println("Second Circular List ");
		list.printList(head2);
	}

}
