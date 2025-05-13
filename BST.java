class BSTNode {
    int key;
    BSTNode left, right;
	
	// Constructor to initialize a new BST node with a given key
    public BSTNode(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}

class BST {
    private BSTNode root;

	// Construct to initialize an empty BST
    public BST() {
        root = null;
    }
	
	// Getter method to access the root node
	public BSTNode getRoot() {
		return root;
	}

	// Implement the BSTSearchRecursive PseudoCode found in PA 7.9.1
    public BSTNode searchRecursive(BSTNode node, int key) {
		if (node != null) { 
            if (key == node.key) {
                return node;  //key is found 
            } else if (key < node.key) {
                return searchRecursive(node.left, key); //search left 
            } else {
                return searchRecursive(node.right, key); //search right
            }
        }
        return null; //no key 
		
    }
	
	// Implement the BSTSearch PseudoCode found in PA 7.9.1
	public BSTNode search(int key) {
		return searchRecursive(root, key); //search for key using root
	}

	// Checks if the tree contains a node with the given key
    public boolean contains(int key) {
        return search(key) != null;
    }

	// Inserts a key into the BST if it does not already exist
    public boolean insertKey(int key) {
        if (contains(key)) {
            return false; // Duplicate keys not allowed
        }
		// Create a new node
        BSTNode newNode = new BSTNode(key);
		// Call insertNode method
        insertNode(newNode);
        return true;
    }
	
	// Implement the BSTInsertNode PseudoCode found in Fig. 7.9.2
	private void insertNode(BSTNode node) {
		if (root == null) {
            root = node; //root equals  node 
        } else {
            insertRecursive(root, node);
        }
		
	}
			

	// Implement the BSTInsertRecursive PseudoCode found in Fig. 7.9.2
    private void insertRecursive(BSTNode parent, BSTNode nodeToInsert) {
		if (nodeToInsert.key < parent.key) { 
			if (parent.left == null) {
				parent.left = nodeToInsert; //insert left 
			}else {
				insertRecursive(parent.left, nodeToInsert); //move left 
			}
		} else { 
            if (parent.right == null) {
                parent.right = nodeToInsert; //insert right 
            } else {
                insertRecursive(parent.right, nodeToInsert); //keep moving right (similar to line 79)
            }
		}
	}
	
	// Implement a printInReverseOrder method discussed in Section 7.7 
	public void printInReverseOrder(BSTNode node) {
		if (node != null) {  //will pint nodes from right to left and format them properly as shown in example 
		printInReverseOrder(node.right); //go thorugh right subtree
		System.out.print(node.key + " ");
		printInReverseOrder(node.left); //go through left subtree 
			
		}
		return; 
		
	}

	// Implement the main method based on the program instructions
	public static void main(String[] args) {
		//Binary Search Tree 
		BST tree = new BST();
		//keys to insert 
		int [] keys = {35,41,13,57,3,83,88,51,38,20,11,22,27,21,48,8};
		
		for (int key :  keys) {
			tree.insertKey(key);//insert each key into BST
		}
		
		System.out.println("--------------------------------------");
		System.out.println("Binary Search Tree After Inserts"); //112-113 format to display 
		tree.printInReverseOrder(tree.getRoot()); // print BST in reverse (starting from 8 ending at 35) 
		System.out.println(); // will print numbers backwards 
		
        BSTPrint.print2D(tree.getRoot());// calls print 2d method from BSTPrint class 
		System.out.println();
		
		int exkey = 27; //intialize exkey to 27 (existing key)
		if (tree.search(exkey) != null) { //will search for exkey if not null
			System.out.println("Found node with key = " +  exkey + "."); // will display 
		} else {
			System.out.println("Key" + exkey + " not found.");
		}
		
		System.out.println();
		
		int nonkey = 89;//intialize (non existing key)
		if (tree.search(nonkey) != null) {// search if not null 
			System.out.println("Found node with key = " +  nonkey);
		} else {
			System.out.println("Key " + nonkey + " not found."); // will display since it is equal to null 
		}
	}
}