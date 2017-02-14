package algo.binarytree;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	public static  BinaryTreeNode root;
	public BinarySearchTree(){
		this.root = null;
	}
	
	
	public boolean find(int id){
		BinaryTreeNode current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}else if(id < current.data){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	
	
	public void insert(int id){
		BinaryTreeNode newNode = new BinaryTreeNode(id);
		if(root==null){
			root = newNode;
			return;
		}
		BinaryTreeNode current = root;
		BinaryTreeNode parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	
	public void delete1(int id){
		BinaryTreeNode par = null;		//parent node of current node
		BinaryTreeNode current = root;
		
		while(current!=null){		// In this loop, we are searching for the Node having the required ID
			if(current.data==id)
				break;
			par = current;
			
			if(id < current.data){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		
		if (current == null)
		{
			System.out.println(id + " not found");
			return;
		}
		
		/* Case C: 2 children*/
		/* find inorder successor and its parent  */
		BinaryTreeNode s,ps;	//s = successor and ps = parent of successor
		if (current.left != null && current.right != null)
		{
			ps = current;
			s = current.right;
			while (s.left != null)
			{
				ps = s;
				s = s.left;
			}
			current.data = s.data;
			current = s;
			par = ps;
		}
		
		/* Case B or Case A: 1 or no child */
		BinaryTreeNode ch;
		if(current.left != null)		//node to be deleted has left child
			ch = current.left;
		else							// Node to be deleted has right child or no child
			ch = current.right;			// if node to be deleted has no child (case A) than ch = null (because current.right = null)
		
		if (par == null)				// Node to be deleted is root node
			root = ch;
		else if (current == par.left)	//Node to be deleted is left child of its parent
			par.left = ch;
		else							//Node to be deleted is right child of its parent
			par.right = ch;				
		
	}
	
	public void display(BinaryTreeNode root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree b = new BinarySearchTree();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		
		System.out.println("Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		
		System.out.println("Delete Node with no children (2)");
		b.delete1(2);		
		b.display(root);
		System.out.println("\n Delete Node with one child (4) : ");
		b.delete1(4);		
		b.display(root);
		System.out.println("\n Delete Node with Two children (10) : ");
		b.delete1(10);		
		b.display(root);
	}
	
}
