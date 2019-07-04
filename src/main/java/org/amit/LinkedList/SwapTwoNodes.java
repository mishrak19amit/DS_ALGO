package org.amit.LinkedList;

public class SwapTwoNodes {

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

	public static void swapNodeHeadUtil(Node prev) {

		Node firsttemp = root.next;
		Node secondtemp = prev.next;
		root.next = prev.next.next;
		prev.next = root;
		root = secondtemp;
		root.next = firsttemp;

	}

	public static void swapTwoNodes(Node point1, Node point2) {
		Node temp1 = point1.next;
		Node temp2 = point2.next;
		Node temp3 = point1.next.next;
		Node temp4 = point2.next.next;
		point1.next = temp2;
		point2.next = temp1;
		point1.next.next = temp3;
		point2.next.next = temp4;

	}

	public static void swapNode(int a, int b) {
		Node head = root;
		Node point1 = null, point2 = null;
		if (head == null)
			return;
		if (a == 1) {
			Node prev = head;
			for (int i = b - 1; 0 < i; i--) {
				prev = head;
				head = head.next;
			}

			if (head == null) {
				System.out.println("Second node not present!");
				return;
			}

			swapNodeHeadUtil(prev);
		}

		else if (b == 1) {
			Node prev = head;
			for (int i = a - 1; 0 < i; i--) {
				prev = head;
				head = head.next;
			}

			if (head == null) {
				System.out.println("First node not present!");
				return;
			}

			swapNodeHeadUtil(prev);

		}

		else {

			point1 = head;
			for (int i = a - 1; 0 < i; i--) {
				point1 = head;
				head = head.next;
			}

			if (head == null) {
				System.out.println("First node not present!");
				return;
			}

			head = root;
			point2 = head;
			for (int i = b - 1; 0 < i; i--) {
				point2 = head;
				head = head.next;
			}

			if (head == null) {
				System.out.println("Second node not present!");
				return;
			}

			swapTwoNodes(point1, point2);

		}

	}

	public static void printNodes() {

		Node head = root;

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

	}

	public static void main(String[] args) {

		SwapTwoNodes obj = new SwapTwoNodes();
		obj.addNode(7);
		obj.addNode(1);
		obj.addNode(3);
		obj.addNode(2);
		obj.addNode(4);
		obj.addNode(5);
		obj.addNode(6);

		printNodes();

		System.out.println();
		swapNode(1, 4);

		printNodes();

		System.out.println();
		swapNode(2, 4);

		printNodes();

		System.out.println();
		swapNode(2, 8);

		printNodes();
	}
}
