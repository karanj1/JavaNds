package ds.AVLtree;
import java.util.Scanner;


public class AVLTree {
	
	private Node root;
	
	static boolean taller;
	static boolean shorter;
	
	public AVLTree()
	{
		root =null;
	}
	
	public boolean isEmpty()
	{
		return (root == null);
	}
	
	public void display()
	{
		display(root,0);
		System.out.println();
	}
	private void display(Node p, int level)
	{
		int i;
		if (p == null)
			return;
		
		display(p.right, level+1);
		System.out.println();
		
		for(i=0; i<level; i++)
			System.out.print("    ");
		System.out.print(p.data);
		
		display(p.left, level+1);
	}
	
	public void inorder()
	{
		inorder(root);
		System.out.println();
	}
	private void inorder(Node p)
	{
		if(p == null)
		{
			return;
		}
		inorder(p.left);
		System.out.print(p.data+ " ");
		inorder(p.right);
	}
	
	public void insert(int x)
	{
		root = insert(root, x);
	}
	private Node insert(Node p,int x) 		// insertion id Similar to BST with addition of taller variable and SubtreeCheck methods
	{
		if (p == null)
		{
			p = new Node (x);
			taller = true;
		}
		else if (x < p.data)
		{
			p.left = insert (p.left, x);
			if(taller == true)
				p = insertionLeftSubtreeCheck(p);
		}
		else if (x > p.data)
		{
			p.right = insert (p.right, x);
			if(taller == true)
				p = insertionRightSubtreeCheck(p);
		}
		else
		{
			System.out.println(x + " already present in tree");
			taller = false;
		}
		
		return p;
	}
	
	private Node insertionLeftSubtreeCheck(Node p) 
	{
		switch(p.balance)
		{
		case 0:		// was balanced
			p.balance = 1;		// now left heavy due to insertion on left side
			break;
		case -1:		// was right heavy
			p.balance = 0;		// now balanced
			taller = false;
			break;
		case 1:		// was left heavy // now would be 2, if we dont do balancing in next line
			p = insertionLeftBalance(p);		//Left balancing 
			taller = false;
			break;
		}
		return p;
	}

	private Node insertionLeftBalance(Node p) {
		Node a,b;
		
		a = p.left;
		if(a.balance == 1) // case L_3A : insertion in AL // see video "Insertion in AVLTree - 3 @ 5:40 minutes"
		{
			p.balance = 0;
			a.balance = 0;
			p = rotateRight(p);
		}
		else		//case L_3B // see video "Insertion in AVLTree - 3"
		{
			b = a.right;
			switch(b.balance)
			{
			case 1: 		//case L_3B1: insertion in BL
				p.balance = -1;
				a.balance = 0;
				break;
			case -1: 		//case L_3B2: insertion in BR
				p.balance = 0;
				a.balance = 1;
				break;
			case 0: 		//case L_3B3: B is newly inserted node
				p.balance = 0;
				a.balance = 0;
				break;
			}
			b.balance = 0;
			p.left = rotateLeft(a);
			p = rotateRight(p);
		}
		return p;
	}

	private Node insertionRightSubtreeCheck(Node p) 
	{
		switch(p.balance)
		{
		case 0:		// was balanced
			p.balance = -1;		// now Right heavy due to insertion on Right side
			break;
		case 1:		// was left heavy
			p.balance = 0;		// now balanced
			taller = false;
			break;
		case -1:		// was right heavy	// now would be -2, if we dont do balancing in next line
			p = insertionRightBalance(p);		//Right balancing
			taller = false;
			break;
		}
		return p;
	}


	private Node insertionRightBalance(Node p) {
Node a,b;
		
		a = p.right;
		if(a.balance == -1) // case R_3A : insertion in AR // see video "Insertion in AVLTree - 3 @ 6:40 minutes"
		{
			p.balance = 0;
			a.balance = 0;
			p = rotateLeft(p);
		}
		else		//case R_3B // see video "Insertion in AVLTree - 3"
		{
			b = a.left;
			switch(b.balance)
			{
			case -1: 		//case R_3B1: insertion in BR
				p.balance = 1;
				a.balance = 0;
				break;
			case 1: 		//case R_3B2: insertion in BL
				p.balance = 0;
				a.balance = -1;
				break;
			case 0: 		//case R_3B3: B is newly inserted node
				p.balance = 0;
				a.balance = 0;
				break;
			}
			b.balance = 0;
			p.right = rotateRight(a);
			p = rotateLeft(p);
		}
		return p;
	}
	
	private Node rotateRight(Node p)
	{
		Node a = p.left;
		p.left = a.right;
		a.right = p;
		return a;
	}
	private Node rotateLeft(Node p)
	{
		Node a = p.right;
		p.right = a.left;
		a.left = p;
		return a;
	}
	
	/***** delete methods *******/
	
	public void delete(int x){
		root = delete (root, x);
	}

	private Node delete(Node p, int x) 
	{
		Node ch, s;
		if (p == null)
		{
			System.out.println(x + " not found");
			shorter = false;
		}
		else if (x < p.data)
		{
			p.left = delete (p.left, x);
			if(shorter == true)
				p = deleteLeftSubtreeCheck(p);
		}
		else if (x > p.data)
		{
			p.right = delete (p.right, x);
			if(shorter == true)
				p = deleteRightSubtreeCheck(p);
		}
		else
		{
			if(p.left != null && p.right != null)		//2 children
			{
				s= p.right;
				while(s.left!=null)
					s=s.left;
				p.data = s.data;
				p.right = delete(p.right, s.data);
				if(shorter == true)
					p = deleteRightSubtreeCheck(p);
			}
			else										// 1 child
			{
				if(p.left != null)	//only left child
					ch = p.left;
				else		//only right child or no child
					ch = p.right;
				p=ch;
				shorter = true;
			}
		}
		return p;
	}

	private Node deleteLeftSubtreeCheck(Node p) {
		switch(p.balance)
		{
		case 0:		// was balanced
			p.balance = -1;		// now right heavy due to deletion on left side
			shorter = false;
			break;
		case 1:		// was left heavy
			p.balance = 0;		// now balanced
			break;
		case -1:		// was right heavy // now would be -2, if we dont do balancing in next line
			p = deletionRightBalance(p);		//Right balancing 
		}
		return p;
	}
	
	private Node deletionRightBalance(Node p) {
		// TODO Auto-generated method stub
		return null;
	}

	private Node deleteRightSubtreeCheck(Node p) 
	{
		switch(p.balance)
		{
		case 0:		// was balanced
			p.balance = 1;		// now left heavy due to deletion on right side
			shorter = false;
			break;
		case -1:		// was right heavy
			p.balance = 0;		// now balanced
			break;
		case 1:		// was left heavy // now would be 2, if we dont do balancing in next line
			p = deletionLeftBalance(p);		//Left balancing 
		}
		return p;
	}

	
	private Node deletionLeftBalance(Node p) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree tree = new AVLTree();
		int choice, x;
		Scanner scan = new Scanner (System.in);
		
		while (true)
		{
			System.out.println("1.Display Tree");
			System.out.println("2.Insert a new node");
			System.out.println("3. Delete a Node");
			System.out.println("4. Inorder Traversal");
			System.out.println("5.Quite");
			System.out.println("Enter Your Choice : ");
			choice = scan.nextInt();
			
			if (choice == 5)
				break;
			
			switch(choice)
			{
			case 1:
				tree.display();
				break;
			case 2:
				System.out.println("Enter the data to be inserted : ");
				x = scan.nextInt();
				tree.insert(x);
				break;
			case 3:
				System.out.println("Enter the data to be deleted : ");
				x = scan.nextInt();
				//tree.delete(x);
				break;
			case 4:
				tree.inorder();
				break;
			}
		}
	scan.close();
	}

}
