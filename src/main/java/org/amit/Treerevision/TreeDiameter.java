package org.amit.Treerevision;

public class TreeDiameter {
static Node root;

int diameter(Node root) {
	
	if(root==null)
		return 0;
	int leftheight=getHeight(root.left);
	int rightheight=getHeight(root.right);
	int diameter=leftheight+rightheight+1;
	int leftdia=diameter(root.left);
	int rightdia=diameter(root.right);
	
	return Math.max(diameter, Math.max(leftdia,rightdia));
}

int getHeight(Node root) {
	if(root==null)
		return 0;
	int leftheight=1+getHeight(root.left);
	int rightheight=1+getHeight(root.right);
	
	return Math.max(leftheight, rightheight);
}

	public static void main(String[] args) {
		TreeDiameter tree= new TreeDiameter();
		root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
  
        System.out.println("The diameter of given binary tree is : "
                           + tree.diameter(root)); 
	}
}
