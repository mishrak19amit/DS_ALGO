package org.amit.Treerevision;

public class BTAncestors {

	Node root;
	
	public static void main(String[] args) {
		
		BTAncestors tree = new BTAncestors(); 
        
        /* Construct the following binary tree 
                  1 
                /   \ 
               2     3 
              /  \ 
             4    5 
            / 
           7 
        */
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.left.right.left = new Node(8); 
        tree.root.left.right.left.left = new Node(10); 
        tree.root.left.right.left.right = new Node(11); 
        tree.root.left.left.left = new Node(7); 
   
        tree.printAncestors(tree.root, 11); 
	}

	public boolean printAncestors(Node node, int val) {
	
		if(null == node)
			return false;
		if(node.data==val)
		{
			System.out.print(node.data+" ");
			return true;
		}
		else {
			if(printAncestors(node.left, val)|| printAncestors(node.right, val)) {
				System.out.print(node.data+" ");
				return true;
			}
			else {
				return false;
			}
		}
		
	}
	
}
