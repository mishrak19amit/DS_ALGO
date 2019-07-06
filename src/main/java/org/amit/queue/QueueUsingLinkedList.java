package org.amit.queue;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}
}

public class QueueUsingLinkedList {

	static Node front, rear;

	public static void initializeQueue() {
		front = null;
		rear = null;
	}

	public static void push(int val) {
		if (front == null) {
			front = new Node(val);
			rear=front;
		} else {
			front.next = new Node(val);
			front = front.next;
		}

	}

	public static int pop() {
		if (rear == null) {
			System.out.println("Queue is Empty!");
			return Integer.MIN_VALUE;
		}

		else {
			int item = rear.data;

			if (rear == front) {
				rear = null;
				front = null;
			} else {
				rear = rear.next;
			}
			return item;
		}

	}

	public static void main(String[] args) {
		initializeQueue();
		push(2);
		push(3);
		push(4);
		System.out.println(pop());
		push(5);
		push(6);
		push(7);
		push(8);
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());

	}

}
