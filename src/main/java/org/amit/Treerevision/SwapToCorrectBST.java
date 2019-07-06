package org.amit.Treerevision;

class TNode {

	int data;
	TNode left, right;

	TNode(int d) {
		data = d;
		left = right = null;
	}
}

public class SwapToCorrectBST {

	void printInorder(TNode node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(" " + node.data);
		printInorder(node.right);
	}

	TNode node11 = null, node12 = null, node21 = null, node22 = null;

	public void correctBST(TNode root) {
		correctBSTUtil(root);
		swap();
	}

	public void correctBSTUtil(TNode root) {

		if (root == null || (root.left == null && root.right == null))
			return;
		if (root.right != null) {
			if (root.right.data < root.data)
				if (node11 == null) {
					node11 = root;
					node12 = root.right;
				} else {
					node21 = root;
					node22 = root.right;
					return;
				}
		}

		if (root.left != null) {
			if (root.data < root.left.data)
				if (node11 == null) {
					node11 = root;
					node12 = root.left;
				} else {
					node21 = root;
					node22 = root.left;
					return;
				}
		}

		correctBSTUtil(root.left);
		correctBSTUtil(root.right);

	}

	public void swap() {
		TNode temp = node12;
		TNode temp21 = node22.left;
		TNode temp22 = node22.right;

		if (node12 == node11.left) {
			node11.left = node22;
			node11.left.left = node12.left;
			node11.left.right = node12.right;
		} else {
			node11.right = node22;
			node11.right.right = node12.right;
			node11.right.left = node12.left;
		}

		if (node22 == node21.left) {
			node21.left = temp;
			node21.left.left = temp21;
			node21.left.right = temp22;
		} else {
			node21.right = temp;
			node21.right.left = temp21;
			node21.right.right = temp22;
		}

	}

	public static void main(String[] args) {

		TNode root = new TNode(6);
		root.left = new TNode(10);
		root.right = new TNode(2);
		root.left.left = new TNode(1);
		root.left.right = new TNode(3);
		root.right.right = new TNode(12);
		root.right.left = new TNode(7);

		System.out.println("Inorder Traversal" + " of the original tree");
		SwapToCorrectBST tree = new SwapToCorrectBST();
		tree.printInorder(root);

		tree.correctBST(root);

		System.out.println("\nInorder Traversal" + " of the fixed tree");
		tree.printInorder(root);

	}
}
