package org.amit.Treerevision;

class Node {
	Node left, right;
	int data;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class TreeTraversal {
	static Node root = null;

	void printPreorder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);

	}

	void printInorder(Node root) {
		if (root == null)
			return;
		printPreorder(root.left);
		System.out.print(root.data + " ");
		printPreorder(root.right);

	}

	void printPostorder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);

	}

	public static void main(String[] args) {
		TreeTraversal tree = new TreeTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder(root);

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder(root);

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder(root);
	}
}
