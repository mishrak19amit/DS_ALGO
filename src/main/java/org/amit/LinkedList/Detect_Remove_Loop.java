package org.amit.LinkedList;

public class Detect_Remove_Loop {
	static class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	void removeLoop(Node head, Node slow) {

		Node temp = slow;
		slow = slow.next;
		int count = 0;
		while (slow != temp) {
			slow = slow.next;
			count++;
		}
		temp = head;
		slow = head;
		while (count != 0) {
			temp = temp.next;
			count--;
		}
		while (temp.next != slow) {
			temp = temp.next;
			slow = slow.next;
		}
		if (temp.next == slow) {
			temp.next = null;
		}

	}

	void detectAndRemoveLoop(Node head) {

		Node slow = head;
		Node fast = head;

		while (fast.next != null) {

			fast = fast.next.next;
			slow = slow.next;

			if (slow == fast) {
				System.out.println("Loop present!");
				Detect_Remove_Loop obj = new Detect_Remove_Loop();
				obj.removeLoop(head, slow);
				return;

			}

		}

		System.out.println("Loop not present!");

	}

	void printlinkedList() {
		Node headnew = head;
		while (headnew != null) {
			System.out.println(headnew.data + " ");
			headnew = headnew.next;

		}
	}

	static Node head;

	public static void main(String[] args) {
		Detect_Remove_Loop list = new Detect_Remove_Loop();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);

		// Creating a loop for testing
		head.next.next.next.next.next = head.next.next;

		// list.printlinkedList();
		list.detectAndRemoveLoop(head);
		list.printlinkedList();
	}

}
