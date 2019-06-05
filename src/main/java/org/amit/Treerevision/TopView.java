package org.amit.Treerevision;

public class TopView {
	static Node root;
	//static int height = 0;

	void getTopView(Node root, int arr[], int height) {
		if (root == null)
			return;
		arr[height] = root.data;
		getTopViewLeft(root.left, arr,height - 1);
		getTopViewRight(root.right, arr,height + 1);
	}

	void getTopViewLeft(Node root, int arr[], int height) {
		if (root == null)
			return;
		if(0<=height&&height<=arr.length/2&&arr[height]==0)
		arr[height] = root.data;
		getTopViewLeft(root.left, arr, height - 1);
		getTopViewLeft(root.right, arr, height - 1);

	}

	void getTopViewRight(Node root, int arr[], int height) {
		if (root == null)
			return;
		if(height<arr.length&&arr.length/2<=height&&arr[height]==0)
		arr[height] = root.data;
		getTopViewLeft(root.right,arr, height + 1);
		getTopViewLeft(root.left,arr, height + 1);

		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0)
			System.out.println(arr[i]+" ");
		}
	}

	int getHeight(Node root) {
		if (root == null)
			return 0;
		int leftheight = 1 + getHeight(root.left);
		int rightheight = 1 + getHeight(root.right);

		return Math.max(leftheight, rightheight);
	}

	public static void main(String[] args) {
		TopView tree = new TopView();
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		
		int height = tree.getHeight(root);
		int arr[] = new int[height * 2 - 1];
		tree.getTopView(root, arr,height-1);
	}

}
