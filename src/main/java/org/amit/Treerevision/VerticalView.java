package org.amit.Treerevision;

public class VerticalView {

	static Node root = null;

	public static void main(String[] args) {
		VerticalView tree = new VerticalView();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Top View of binary tree is ");
		tree.printVerticalView(root);
	}

	private void printVerticalView(Node root) {
		if (root == null)
			return;
		int height = getHeight(root);

		System.out.println("Height of the tree is: "+ height);
		
		int arr[] = new int[height * 2 - 1];

		if (root != null) {
			arr[height-1] = root.data;

			putLeftTopView(root.left, arr, height - 2);
			putRightTopView(root.right, arr, height);
		}

		printTopView(arr);
	}

	private void printTopView(int[] arr) {
		for (int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				System.out.print(arr[i] + " ");
			}
		}

	}

	private void putRightTopView(Node right, int[] arr, int i) {

		if (right == null)
			return;
		if (arr[i] == 0) {
			arr[i] = right.data;
		}
		putRightTopView(right.right, arr, i + 1);
		putRightTopView(right.left, arr, i - 1);
	}

	private void putLeftTopView(Node left, int[] arr, int i) {

		if (left == null)
			return;
		if (arr[i] == 0) {
			arr[i] = left.data;
		}
		putRightTopView(left.left, arr, i - 1);
		putRightTopView(left.right, arr, i + 1);
	}

	private int getHeight(Node root) {
		if (root == null)
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));

	}

}
