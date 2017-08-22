package ds.BinaryThreadedTree;

import java.util.Scanner;


public class ThreadedBinaryTree {

	private Node root;
	
	public ThreadedBinaryTree()
	{
		root = null;
	}
	
	public boolean isEmpty()
	{
		return (root == null);
	}
	
	private Node inorderPredecessor(Node p)
	{
		if(p.leftThread == true)
			return p.left;
		else
		{
			p = p.left;
			while(p.rightThread == false)		// while p.right is not a thread 
				p = p.right;
			return p;
		}
	}
	
	private Node inorderSuccessor(Node p)
	{
		if(p.rightThread == true)
			return p.right;
		else
		{
			p = p.right;
			while(p.leftThread == false)
				p = p.left;
			return p;
		}
	}
	
	public void inorder()
	{
		if(root == null)
		{
			System.out.print("Tree is empty");
			return;
		}
		
		/* Find the leftmost node of the tree */
		Node p = root;
		while(p.leftThread == false)
			p = p.left;
		
		while(p != null)
		{
			System.out.print(p.data + " ");
			if (p.rightThread == true)
				p = p.right;
			else
			{
				p = p.right;
				while (p.leftThread == false)
					p = p.left;
			}
		}
		System.out.println();
	}
	
	public void insert(int x)		// this method is similar to insertion method of BST
	{
		Node p =root;
		Node par = null;
		
		while (p!=null)
		{
			par = p;
			if (x < p.data) 	// if data to be inserted is less than current.data
			{
				if (p.leftThread == false)		// if left link is not thread
					p = p.left;
				else							// if left link is thread or null than break
					break;		
			}
			else if(x > p.data)
			{
				if (p.rightThread == false)
					p = p.right;
				else
					break;
			}
			else
			{
				System.out.println(x + " already present in the tree");
				return;
			}
		}
		
		Node newNode = new Node(x);
		if (par == null)			//if root is null
			root = newNode;
		else if(x < par.data)	/* inserting as left child */
		{
			newNode.left = par.left;
			newNode.right = par;
			par.leftThread = false;
			par.left = newNode;
		}
		else 				/* inserting as right child */ // if (x > par.data)
		{
			newNode.right = par.right;
			newNode.left = par;
			par.rightThread = false;
			par.right = newNode;
		}
	}
	
	public void delete(int x)		// this method is similar to deletion method of BST
	{
		Node p =root;
		Node par = null;
		
		while (p!=null)
		{
			if(x == p.data)
				break;
			par = p;
			if (x < p.data) 	// if data to be inserted is less than current.data
			{
				if (p.leftThread == false)		// if left link is not thread
					p = p.left;
				else							// if left link is thread or null than break
					break;		
			}
			else 			//if(x > p.data)
			{
				if (p.rightThread == false)
					p = p.right;
				else
					break;
			}
		}
		
		if (p == null || p.data != x)  // if x is not present in the tree
		{
			System.out.println(x + " not found");
			return;
		}
		
		/* Case C: 2 children*/			
		if(p.leftThread == false && p.rightThread == false)	 /* find inorder successor and its parent  */
		{
			Node s, ps;	//s = successor and ps = parent of successor
			ps = p;
			s = p.right;
			while (s.left != null)
			{
				ps = s;
				s = s.left;
			}
			p.data = s.data;
			p = s;
			par = ps;
		}
		
		/* Case A: No child */
		if(p.leftThread == true && p.rightThread == true)	// Obviously, leaf node will have leftthread and rightthread == true
		{
			if (par == null)
				root = null;
			else if (p == par.left)		// if the current node 'p' is left child of its parent 'par'
			{
				par.leftThread = true;	// untill now, parent's left link was point to 'p', so it was not thread. but now it will be a thread
				par.left = p.left;		// parent.left link will be thread to node where p's thread link was pointing // p's predecessor will be par's predecessor
			}
			else						// if the current node 'p' is right child of its parent 'par'
			{
				par.rightThread = true;
				par.right = p.right;	// p's successor will be par's successorsuccessor
			}
			return;
		}
		
		/* case B : 1 child */
		Node ch;
		if(p.leftThread == false)		//node to be deleted has left child
			ch = p.left;
		else							// Node to be deleted has right child or no child
			ch = p.right;			// if node to be deleted has no child (case A) than ch = null (because current.right = null)
		
		if (par == null)				// Node to be deleted is root node
			root = ch;
		else if (p == par.left)	//Node to be deleted is left child of its parent
			par.left = ch;
		else							//Node to be deleted is right child of its parent
			par.right = ch;		
		
		Node pred = inorderPredecessor(p);
		Node succ = inorderSuccessor(p);
		
		if(p.leftThread == false)		// if p has left child, right is a thread  // understand from the video  // Deletion -Threaded Binary Tree
			pred.right = succ;
		else							// if p has right child, left is a thread
			succ.left = pred;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadedBinaryTree tree = new ThreadedBinaryTree();
		int choice,x;
		
Scanner scan = new Scanner (System.in);
		
		while (true)
		{
			System.out.println("1.Insert a new node");
			System.out.println("2. Delete a Node");
			System.out.println("3. Inorder Traversal");
			System.out.println("4.Quite");
			System.out.println("Enter Your Choice : ");
			choice = scan.nextInt();
			
			if (choice == 4)
				break;
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter the data to be inserted : ");
				x = scan.nextInt();
				tree.insert(x);
				break;
			case 2:
				System.out.println("Enter the data to be deleted : ");
				x = scan.nextInt();
				tree.delete(x);
				break;
			case 3:
				tree.inorder();
				break;
			}
		}
	scan.close();
	}

}
