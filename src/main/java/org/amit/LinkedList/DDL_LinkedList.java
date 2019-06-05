package org.amit.LinkedList;

public class DDL_LinkedList {
	class Node {
		int data;
		Node next;

		Node(int val) {
			this.data = val;
			this.next = null;
		}
	}

	Node root;

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

	void printlinkedList() {
		Node head = root;
		while (head != null) {
			System.out.println(head.data + " ");
			head = head.next;

		}
	}

	void deletekey(int key) {
		if (root == null)
			return;
		Node head = root;
		Node prev = null;
		if (head.data == key) {
			head = head.next;
			return;
		}
		while (head.data != key && head != null) {
			prev = head;
			head = head.next;
		}
		if (head != null) {
			prev.next = head.next;
		}
		// root=head;
		return;
	}

	void reversLinedList() {
		if (root == null || root.next == null)
			return;
		Node prev = null;
		Node next = root;
		while (root != null) {
			next=root.next;
			root.next = prev;
			prev = root;
			root = next;
		}
		root = prev;
	}
	
	void deleteatpos(int pos)
	{
		if(root==null)
			return;
		Node head=root;
		Node prev=null;
		if(pos==0)
		{
			root=root.next;
			return ;
		}
		while(head!=null&&0<pos) {
			pos--;
			prev=head;
			head=head.next;
		}
		if(pos==0&&head!=null)
		{
			prev.next=prev.next.next;
			
		}
	}

	public static void main(String[] args) {

		DDL_LinkedList obj = new DDL_LinkedList();
		obj.addNode(7);
		obj.addNode(1);
		obj.addNode(3);
		obj.addNode(2);
		obj.printlinkedList();
		System.out.println("");
		//obj.deletekey(1);
		obj.printlinkedList();
		//obj.reversLinedList();
		System.out.println("");
		//obj.printlinkedList();
		obj.deleteatpos(4);
		System.out.println("");
		obj.printlinkedList();
	}
}
