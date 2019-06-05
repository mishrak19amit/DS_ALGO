package org.amit.Treerevision;

public class MinDistanceNode {

	static int staticdis1=0;
	static int staticdis2=0;
	static boolean checked1=false;
	static boolean checked2=false;
	static int getNodedistance(int a, int b) {
		Node commonnode = getCommonNodeUtil(root, a, b);
		System.out.println("Common node: "+ commonnode.data);
		if (checkOneSide(commonnode, a, b)) {
			 disNode1(commonnode, a,0); 
			 disNode2(commonnode, b,0);
			 return Math.abs(staticdis1-staticdis2);
		} else {
			disNode1(commonnode, a,0); 
			 disNode2(commonnode, b,0);
			 return staticdis1+staticdis2;
			//return disNode(commonnode, a,0) + disNode(commonnode, b,0);
		}
	}

	static boolean checkOneSide(Node head, int a, int b) {
		return !(containNode(head.left, a) || containNode(head.left, b))
				&& (containNode(head.right, a) || containNode(head.right, b));
	}

	static boolean containNode(Node head, int a) {
		if (head == null)
			return false;
		if (head.data == a)
			return true;
		return containNode(head.left, a) || containNode(head.right, a);
	}
	static void disNode1(Node comnode, int a, int dis) {
		if (comnode == null)
			return ;
		if(comnode.data==a) {
			if(!checked1) {
				staticdis1=dis;
				checked1=!checked1;
			}
			
		}
		if(comnode.left!=null)
		 disNode1(comnode.left, a, dis+1);
		if(comnode.right!=null)
		 disNode1(comnode.right, a, dis+1);
        return ;
	}
	
	static void disNode2(Node comnode, int a, int dis) {
		if (comnode == null)
			return ;
		if(comnode.data==a) {
			if(!checked2) {
				staticdis2=dis;
				checked2=!checked2;
			}
		}
		if(comnode.left!=null)
		 disNode2(comnode.left, a, dis+1);
		if(comnode.right!=null)
		 disNode2(comnode.right, a, dis+1);
        return ;
	}

	static Node getCommonNodeUtil(Node head, int a, int b) {
		if (head == null)
			return head;
		if (head.data == a || head.data == b)
			return head;
		Node lhead = getCommonNodeUtil(head.left, a, b);
		Node rhead = getCommonNodeUtil(head.right, a, b);
		if (lhead != null && rhead != null)
			return head;
		else
			return lhead != null ? lhead : rhead;
	}

	static Node root;

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);

		System.out.println("Distance between node is: "+getNodedistance(8, 7));
	}
}
