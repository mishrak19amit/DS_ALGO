package org.amit.Treerevision;

import org.amit.Treerevision.DeleteNodeFromBST.Node;

public class PredecessorSuccessor {
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
	PredecessorSuccessor() {
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
	
	void findPredSuc(int data) {
		 findPredSucUtil(root, data);
	}
	
	void findPredSucUtil(Node root, int data) {
		if(root==null) {
			System.out.println("Predecessor and successor not available!");
			return;
		}
		
		if(root.key<data)
		{
			findPredSucUtil(root.right, data);
		}
		else if(data<root.key){
			int suc=root.key;
			
			
			System.out.println("Succ: "+suc);
			if(root.left!=null) {
				int pred=root.left.key;
				System.out.println("Pred: "+pred);
			}
			else {
				System.out.println("Predecessor not available");
			}
			
			
			
			return;
		}
		else {
			
			if(root.right!=null) {
				int suc=root.right.key;
				System.out.println("Succ: "+suc);
			}
			else {
				System.out.println("Successor not available");
			}
            
			if(root.left!=null) {
				int pred=root.left.key;
				System.out.println("Pred: "+pred);
			}
			else {
				System.out.println("Predecessor not available");
			}
			
			
			
			return;
			
		}
	}

	public static void main(String[] args) {
		PredecessorSuccessor tree=new PredecessorSuccessor();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		int key=90;
		
		tree.findPredSuc(key);
	}

}
