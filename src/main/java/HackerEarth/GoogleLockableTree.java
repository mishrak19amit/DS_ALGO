package HackerEarth;

class GNode {
	boolean lockable;
	GNode lChild;
	GNode rChild;
	GNode parent;

	public GNode(boolean islocked, GNode parent) {
		this.lockable = islocked;
		this.lChild = null;
		this.rChild = null;
		this.parent = parent;
	}
}

public class GoogleLockableTree {

	public static boolean isChildLocked(GNode node) {
		if (null == node)
			return false;
		if (node.lockable)
			return true;
		return isChildLocked(node.lChild) || isChildLocked(node.rChild);
	}

	public static boolean isParentLocked(GNode node) {
		if (null == node)
			return false;
		if (node.lockable)
			return true;
		return isParentLocked(node.parent);
	}

	public static boolean is_Locked(GNode node) {
		if (null == node)
			return false;
		return isChildLocked(node.lChild) || isChildLocked(node.rChild) || isParentLocked(node.parent);
	}

	public static boolean lock(GNode node) {
		boolean isLocked = false;

		return isLocked;
	}

	public static boolean unLock(GNode node) {
		boolean isUnLocked = false;

		return isUnLocked;
	}

	public static boolean lockNode(GNode node, boolean forLock) {

		if (is_Locked(node)) {
			System.out.println("Not valid for Locking or Unlocking!");
			return false;

		} else {
			if(forLock) {

				System.out.println("Valid for Locking!");
				node.lockable = forLock;
			}
			else {

				System.out.println("Valid for Unlocking!");
				node.lockable = forLock;
			}
			return true;
		}

	}

	public static void main(String[] args) {

		GNode root = new GNode(false, null);
		root.lChild = new GNode(false, root);
		root.rChild = new GNode(false, root);
		root.lChild.lChild = new GNode(false, root.rChild);

		lockNode(root.lChild, true);
		lockNode(root.lChild, false);

	}

}
