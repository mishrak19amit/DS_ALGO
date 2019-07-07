package org.amit.Treerevision;

public class DeleteNodeFromBST {

	/* Class containing left and right child of current node and key value */
	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	// Root of BST
	Node root;

	// Constructor
	DeleteNodeFromBST() {
		root = null;
	}

	public Node insertUtil(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		} else {
			if (data < root.key) {
				root.left = insertUtil(root.left, data);
			} else {
				root.right = insertUtil(root.right, data);
			}

			return root;
		}
	}

	public void insert(int data) {

		root = insertUtil(root, data);
	}

	void inorderUtil(Node root) {
		if (root == null)
			return;
		inorderUtil(root.left);
		System.out.print(root.key + " ");
		inorderUtil(root.right);

	}

	void inorder() {
		inorderUtil(root);
	}

	int getMin(Node root) {
		if (root.left == null) {
			int minval = root.key;
			root = null;
			return minval;
		}

		else
			return getMin(root.left);
	}

	Node deleteKeyUtil(Node root, int data) {
		if (root == null)
			return root;

		if (data < root.key) {
			root.left = deleteKeyUtil(root.left, data);
		} else if (root.key < data) {
			root.right = deleteKeyUtil(root.right, data);
		} else {

			if (root.right == null) {
				return root.left;
			} else if (root.left == null) {
				return root.right;
			}

			root.key = getMin(root.right);
			root.right = deleteKeyUtil(root.right, root.key);

		}

		return root;

	}

	void deleteKey(int data) {
		deleteKeyUtil(root, data);
	}

	public static void main(String[] args) {
		DeleteNodeFromBST tree = new DeleteNodeFromBST();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println("Inorder traversal of the given tree");
		tree.inorder();

		System.out.println("\nDelete 20");
		tree.deleteKey(20);
		System.out.println("Inorder traversal of the modified tree");
		tree.inorder();
  
        System.out.println("\nDelete 30"); 
        tree.deleteKey(30); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
  
        System.out.println("\nDelete 50"); 
        tree.deleteKey(50); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 

	}

}
