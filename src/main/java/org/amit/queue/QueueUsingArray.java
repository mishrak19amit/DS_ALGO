package org.amit.queue;

public class QueueUsingArray {
	static int arr[];
	static int front, rear, size;

	public static void initializeQueue(int cap) {
		arr = new int[cap];
		front = 0;
		rear = 0;
		size = 0;
	}

	public static void add(int item) {
		if (size == arr.length) {
			System.out.println("Queue is full, not able to insert!");
			return;
		} else {
			front = (size + rear) % arr.length;
			size++;
			arr[front] = item;
		}
	}

	public static int pop() {
		if (size == 0) {
			System.out.println("Queue is empty!");
			return Integer.MIN_VALUE;
		} else {
			size--;
			int item = arr[rear];
			rear = (rear + 1) % arr.length;
			return item;

		}
	}

	public static void main(String[] args) {
		int capacity = 5;
		initializeQueue(capacity);
		add(2);
		add(3);
		add(4);
		System.out.println(pop());
		add(5);
		add(6);
		add(7);
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());

	}

}
