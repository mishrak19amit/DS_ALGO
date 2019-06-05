package org.amit.Treerevision;

public class LevelOrderTraversal {
	static Node root;
    static int count=0;
	void levelOrder(Node root) {

		if (root == null)
			return;
		int height = getHeight(root);
		System.out.println("Height :" + height);
		System.out.println("Level order traversal: ");
		int max=0;
		for (int i = 0; i < height; i++) {
			levelOrderPrint(root, i);
			if(max<count)
				max=count;
			count=0;
		}
		System.out.println("Max width: "+ max);
	}

	void levelOrderPrint(Node root, int level) {
		if (root == null)
			return;
		if (level == 0) {
			count++;
			System.out.print(root.data + " ");
		}

		else {
			levelOrderPrint(root.left, level - 1);
			levelOrderPrint(root.right, level - 1);
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
		LevelOrderTraversal tree = new LevelOrderTraversal();
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		tree.levelOrder(root);
	}

}
