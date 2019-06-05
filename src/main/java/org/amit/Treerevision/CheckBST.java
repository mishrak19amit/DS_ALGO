package org.amit.Treerevision;

public class CheckBST {

	static Node root;

	boolean checkBST(Node root) {

		if (root == null)
			return true;
		// return true;
		if (root.left != null)
			if (root.left.data > root.data)
				return false;
		if (root.right != null)
			if (root.right.data < root.data)
				return false;
		if (checkBST(root.left) && checkBST(root.right))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		CheckBST tree = new CheckBST();
		root = new Node(4);
		root.left = new Node(2);
	    root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(6);

		if (tree.checkBST(root))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}

}
