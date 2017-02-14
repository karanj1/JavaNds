package algo.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		
		BinaryTreeTraverse bt = new BinaryTreeTraverse();
		
		System.out.print("InOrder Travesal:\n");
		bt.inorderRecursive(root);
		
		System.out.print("\n\nPreOrder Travesal:\n");
		bt.preorderRecursive(root);
		
		System.out.print("\n\nPostOrder Travesal:\n");
		bt.postorderRecursive(root);
		
		System.out.print("\n\nlevelOrderQueue Travesal:\n");
		bt.levelOrderQueue(root);
		
	}

	
	public void inorderRecursive(BinaryTreeNode root) {
		if (root != null) {
			inorderRecursive(root.left);
			System.out.print(root.data + " ");
			inorderRecursive(root.right);
		}
	}
	
	public void preorderRecursive(BinaryTreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorderRecursive(root.left);
			preorderRecursive(root.right);
		}
	}
	
	public void postorderRecursive(BinaryTreeNode root) {
		if (root != null) {
			postorderRecursive(root.left);
			postorderRecursive(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	public void levelOrderQueue(BinaryTreeNode root) {
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		if (root == null)
			return;
		q.add(root);
		while (!q.isEmpty()) {
			BinaryTreeNode n = q.poll();
			System.out.print(" " + n.data);
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}
	}
}
