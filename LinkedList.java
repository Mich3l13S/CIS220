//MichelleSallard
//Chpt4 PA
// Define a Node class to represent each element in the list
class Node {
    int data;
    Node next;

    // Constructor to initialize a new node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define a List class to represent the singly linked list
class List {
    Node head;
    Node tail;

    // Constructor to initialize an empty list
    public List() {
        head = null;
        tail = null;
		// Method to sum data values in the list
	}
	
	public int sumDataValues() {
			int sum = 0; //initialize sum
			Node current = head; //make current node the head 
			while (current != null) { //when the current is not empty
				sum += current.data;  //add data to current node 
				current = current.next; //move on to next node 
			}
			System.out.println("The sum of the list data values is: " + sum); //print sum of noded then return sum
			return sum;
    }

    // Method to append an item to the list, pseudocode found in PA 4.2.6
    public void listAppend(int item) {
		// Create node to add
        Node newNode = new Node(item);
        listAppendNode(newNode);
    }

    // Method to append a node to the list, pseudocode found in PA 4.2.6
    private void listAppendNode(Node newNode) {
        // If list is empty, new head and tail node
		if (head == null) {  
            head = newNode;
            tail = newNode;
		// list not empty, new tail node
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to prepend an item to the list, pseudocode found in PA 4.2.9
    public void listPrepend(int item) {
		// Create node to add
        Node newNode = new Node(item);
        listPrependNode(newNode);
    }

    // Method to prepend a node to the list, pseudocode found in PA 4.2.9
    private void listPrependNode(Node newNode) {
		// If list is empty, new head and tail node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
			// list not empty, new head node
            newNode.next = head;
            head = newNode;
        }
    }

    // Method to insert a node after a specific node in the list, pseudocode found in PA 4.3.4
    public void listInsertNodeAfter(Node currentNode, Node newNode) {
		// If list is empy, new head and tail node
        if (head == null) {  
            head = newNode;
            tail = newNode;
		// Inserting after list's tail node, new tail node	
        } else if (currentNode == tail) {
            tail.next = newNode;
            tail = newNode;
		// Inserting in middle of list	
        } else {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }
	
	// Method searches for a node with a specific data value, pseudocode found in PA 4.3.1 
	public Node listSearch(int key) {
        Node curNode = head;
        while (curNode != null) {
            if (curNode.data == key) {

                return curNode;
            }
            curNode = curNode.next;
        }
        return null;
    }

	// Method to insert a new item after a specific item, pseudocode found in Figure 4.3.1
    public boolean listInsertAfter(int currentItem, int newItem) {
		// Search for the node to insert after
        Node currentNode = listSearch(currentItem);
        if (currentNode != null) {
            Node newNode = new Node(newItem);
            newNode.next = null;
			// Call listInsertNodeAfter method
            listInsertNodeAfter(currentNode, newNode);
            // Success
            return true;
        }
        // Failure
        return false; 
    }

    // Method to remove a node after a specific node in the list, pseudocode found in PA 4.4.1
    public void listRemoveNodeAfter(Node curNode) {
        Node sucNode;
		// Special case, remove head
        if (curNode == null) {  
            sucNode = head.next;
            head = sucNode;
			// Removed last item
            if (sucNode == null) {  
                tail = null;
            }
		// Node exists after curNode	
        } else if (curNode.next != null) {
            sucNode = curNode.next.next;
            curNode.next = sucNode;
			// Removed tail, set tail to curNode
            if (sucNode == null) {  
                tail = curNode;
            }
        }
    }
	
	// Method to remove a node with a specific data value, pseudocode found in Figure 4.4.1
	public boolean listRemove(int itemToRemove) {
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (current.data == itemToRemove) {
				// Call listRemoveNodeAfter method
                listRemoveNodeAfter(previous);
                // Success
                return true;
            }
            previous = current;
            current = current.next;
        }
        // Not found
        return false; 
    }

    // Method to traverse and print the list, pseudocode found in PA 4.8.1
    public void listTraverse() {
		// Start at head
        Node curNode = head;  
        while (curNode != null) {
			// Prints the node's data
            System.out.print(curNode.data + " -> ");
			// Traverse to next node in the list
            curNode = curNode.next;
        }
        System.out.println("NULL");
    }

    // Method to find the insertion position for a data value, pseudocode found in figure 4.9.1 
	public Node listFindInsertionPosition(int dataValue) {
		// curNodeA keeps track of the node before the insertion position
        Node curNodeA = null;
		// curNodeB starts at the head and traverses the list list
        Node curNodeB = head;
		// Traverse the list until we find the correct insertion position
		// Stop when curNodeB is null (end of list) or dataValue is small than or equal to curNode
        while (curNodeB != null && dataValue > curNodeB.data) {
			// Move curNodeA to curNodeB (keeping track of previous node)
			curNodeA = curNodeB;
			// Move curNodeB to the next node
            curNodeB = curNodeB.next;
        }
		// Return curNodeA, which is the node after which the new value should be inserted
		// If curNodeA is null, it means the new value should be inserted at the head
        return curNodeA;
    }

    // Method to perform insertion sort on the list, pseudocode found in PA 4.9.1 
    public void listInsertionSortSinglyLinked() {
		// Initalize beforeCurrent to the head of the list
        Node beforeCurrent = head;
		// Start curNode from the second node (if head is not null)
        Node curNode = head != null ? head.next : null;
		// Traverse through the linked list
        while (curNode != null) {
			// Store the next node before manipulating curNode
            Node next = curNode.next;
			// Find the correct position for curNode in the sorted portion of the list
            Node position = listFindInsertionPosition(curNode.data);
			// If curNode is already in the correct position, move beforeCurrent foward
			if (position == beforeCurrent) {
				beforeCurrent = curNode;
            } else {
				// Removes the curNode from its current position
                listRemoveNodeAfter(beforeCurrent);
				// If position is null, curNode should be inserted at the beginning
                if (position == null) {
                    listPrependNode(curNode);
                } else {
					// Insert curNode after the found position
                    listInsertNodeAfter(position, curNode);
                }
            }
			// Move to the next node in the original list
            curNode = next;
        }
    }
}

// Implement sumDataValues function

// Main class to demonstrate the linked list operations
public class LinkedList {
	// Main method
    public static void main(String[] args) {
		
        List myList = new List();

                           
        System.out.print("List: ");
        myList.listTraverse();
        myList.sumDataValues();// print and detemine sum

        // Add 10 and 20
        myList.listAppend(10);
        myList.listAppend(20);

        //adds 30 to front of list
        myList.listPrepend(30);

        // Insert 40 after head (30)
        myList.listInsertAfter(myList.head.data, 40);

        // Insert 50 at the end after 20 (tail)
        myList.listInsertAfter(myList.tail.data, 50);

        // Insert 60 after node 10
        myList.listInsertAfter(10, 60);

        // Insert 70 after 40
        myList.listInsertAfter(40, 70);

        System.out.print("List: ");
        myList.listTraverse(); //print list of updated nodes
		

        // Remove head node
        myList.listRemoveNodeAfter(null);

        // remove node after node with value 70
        Node node70 = myList.listSearch(70);
        myList.listRemoveNodeAfter(node70);

        System.out.print("List: ");
        myList.listTraverse(); //rprint updated list in format given in example

        //search for node 50
        if (myList.listSearch(50) != null) {
            System.out.println("Node 50 was found.");
        } else {
            System.out.println("Node 50 was not found");          
        }  // if loop will determine and print if node was found or not

        // look for node with value 15
        if (myList.listSearch(15) != null) { 
            System.out.println("Node 15 found");
        } else {
            System.out.println("Node 15 was not found.");
        } //will determine and also print whether or not node with value was fond
		

        //will sort list
        myList.listInsertionSortSinglyLinked();

        System.out.print("Sorted list: ");
        myList.listTraverse(); //print updated and sorted list

        myList.sumDataValues(); // print sum of all the values in the nodes
        
    }
}
