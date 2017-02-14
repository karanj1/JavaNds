package ds.btree;

import java.util.Scanner;


public class Btree {
	
	private static final int M = 5;
	private static final int MAX = M-1;				// Max number of key allowed in any Node
	private static final int MIN = (int)Math.ceil((double)M/2) - 1;		// min number of keys allowed in any node with exception of the root node.
	
	private Node root;
	
	public Btree()
	{
		root = null;
	}
	
	public boolean Search(int x)
	{
		if (Search(x, root) ==  null)
			return false;
		return true;
	}
	
	private Node Search(int x, Node p) 
	{
		if (p == null)		/* Key x not present in the tree */
			return null;
		
		IntHolder n = new IntHolder(0);
		if (SearchNode(x, p , n) == true) 		/* Key x found in the Node p */
			return p;
		
		return Search(x, p.child[n.value]);		// search in nth child of p
			
	}
	
	private boolean SearchNode(int x, Node p, IntHolder n) 
	{
		if (x < p.key[1])	// key x is less than leftmost key so child (n.value) will be 0(leftmost for the node p)
		{
			n.value = 0;
			return false;
		}
		
		n.value = p.numKeys;
		while((x < p.key[n.value]) && n.value >1 )
			n.value --;
		
		if (x == p.key[n.value])
			return true;
		else
			return false;
	}
	

	public void Inorder()
	{
		Inorder(root);
	}
	
	private void Inorder(Node p) 
	{
		if(p == null)
			return;
		
		int i;
		for(i = 0; i < p.numKeys; i++)
		{
			Inorder(p.child[i]);
			System.out.print(p.key[i+1] + "  ");
		}
		Inorder(p.child[i]);		// because, no. of children = no. of keys + 1; // there is no key after last subtree of node/children
	}
	
	public void Display()
	{
		Display(root, 0);
	}
	
	private void Display(Node p, int blanks)
	{
		if (p != null)
		{
			int i;
			for (i = 1; i <= blanks; i++)
				System.out.print("");
			
			for (i = 1; i <= p.numKeys; i++)
				System.out.print(p.key[i] + " ");
			System.out.println("\n");
			
			for (i = 0; i <= p.numKeys; i++)
				Display(p.child[i], blanks+1);
		}
	}
	

	public void Insert(int x)
	{
		IntHolder iKey = new IntHolder(0);
		NodeHolder iKeyRchild = new NodeHolder(null);
		
		boolean taller = Insert(x, root, iKey, iKeyRchild);
		
		if(taller) // if height increased by one, new root node has to be created
		{
			Node temp = new Node(M);
			temp.child[0] = root;
			root = temp;
			
			root.numKeys = 1;
			root.key[1] = iKey.value;
			root.child[1] = iKeyRchild.value;
		}
		
	}
	
	private boolean Insert(int x, Node p, IntHolder iKey, NodeHolder iKeyRchild) 
	{
		if (p == null)	// first base case : key not found
		{
			iKey.value = x;
			iKeyRchild.value = null;
			return true;
		}
		
		IntHolder n = new IntHolder(0);
		
		if(SearchNode(x, p , n) == true)		//second base case : key found // seachnode will update the value of n
		{
			System.out.println(" key already present in the tree");
			return false; // no need to insert the key
		}
		
		// if p is not null and key x is not present in node p then:
		boolean flag = Insert(x, p.child[n.value], iKey, iKeyRchild);
		
		if(flag == true)  // if true then we try to insert the key iKey into the node p
		{
			if (p.numKeys < MAX)
			{
				InsertByShift(p, n.value, iKey.value, iKeyRchild.value);
				return false;		//Insertion is over
			}
			else		// if p.numKeys == MAX , Split of node P is required
			{
				Split(p, n.value, iKey, iKeyRchild);
				return true;		// Insertion not over : Median key yet to be inserted
			}
		}
		return false;
	}
	
	private void InsertByShift(Node p, int n, int iKey, Node iKeyRchild) {
		
		for (int i = p.numKeys; i > n; i--)
		{
			p.key[i+1] = p.key[i];
			p.child[i+1] = p.child[i];
		}
		
		p.key[n+1] = iKey;
		p.child[n+1] = iKeyRchild;
		p.numKeys++;
	}

	private void Split(Node p, int n, IntHolder iKey, NodeHolder iKeyRchild) {
		int i, j;
		int lastKey;
		Node lastChild;
		
		if(n == MAX)
		{
			lastKey = iKey.value;
			lastChild = iKeyRchild.value;
		}
		else
		{
			lastKey = p.key[MAX];
			lastChild = p.child[MAX];
			
			for (i = p.numKeys - 1; i>n; i--)
			{
				p.key[i+1] = p.key[i];
				p.child[i+1] = p.child[i];
			}
			p.key[i+1] = iKey.value;
			p.child[i+1] = iKeyRchild.value;
		}
		
		int d = (M + 1) / 2;
		int medianKey = p.key[d]; 
		Node newNode = new Node(M); 
		newNode.numKeys = M - d; 
		
		newNode.child[0] = p.child[d]; 
		for (i=1, j=d+1; j<=MAX; i++, j++) 
		{
			newNode.key[i] = p.key[j]; 
			newNode.child[i] = p.child[j]; 
		}
		newNode.key[i] = lastKey; 
		newNode.child[i] = lastChild; 
		
		p.numKeys = d - 1; 
		
		iKey.value = medianKey; 
		iKeyRchild.value = newNode; 
	}

	
	


	public static void main(String[] args) {
		
		Btree tree = new Btree();
		int choice, x;
		Scanner scan = new Scanner (System.in);
		
		while (true)
		{
			System.out.println("1. Search");
			System.out.println("2. Insert");
			System.out.println("3. Delete");
			System.out.println("4. Display");
			System.out.println("5. Inorder Traversal");
			System.out.println("6. Quite");
			System.out.println("Enter Your Choice : ");
			choice = scan.nextInt();
			
			if (choice == 6)
				break;
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter the key to be searched : ");
				x = scan.nextInt();
				if(tree.Search(x)==true)
					System.out.println("Key Present");
				else
					System.out.println("Key not Present");
			case 2:
				System.out.println("Enter the key to be inserted : ");
				x = scan.nextInt();
				tree.Insert(x);
				break;
			case 3:
				System.out.println("Enter the key to be deleted : ");
				x = scan.nextInt();
				//tree.delete(x);
				break;
			case 4:
				System.out.println("BTree is : ");
				tree.Display();
				System.out.println("\n");
				break;
			case 5:
				tree.Inorder();
				System.out.println("\n");
				break;
			default:
				System.out.println("Wrong Choice\n");
				break;
			}
		}
	scan.close();
	}

}
