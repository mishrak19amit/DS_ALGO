package org.amit.Treerevision;

import org.amit.Treerevision.PredecessorSuccessor.Node;

public class BinaryToDDL {
	
	Node root;

	  void printList(Node node)  
	    { 
	        while (node != null)  
	        { 
	            System.out.print(node.key + " "); 
	            node = node.right; 
	        } 
	    } 
	  
	  
	  Node bintree2list(Node root) {
		  
		  if(root==null) return root;
		  root.left=bintree2list(root.left);
		  root.right=root;
		  bintree2list(root.right);
		  
		  
	  }
	  
	
	public static void main(String[] args) {

		BinaryToDDL tree = new BinaryToDDL(); 
		   
        // Let us create the tree shown in above diagram 
        tree.root = new Node(10); 
        tree.root.left = new Node(12); 
        tree.root.right = new Node(15); 
        tree.root.left.left = new Node(25); 
        tree.root.left.right = new Node(30); 
        tree.root.right.left = new Node(36); 
   
        // Convert to DLL 
        Node head = tree.bintree2list(tree.root); 
   
        // Print the converted list 
        tree.printList(head); 
		
	}

}
