//MichelleSallard 
//Chpt5 PA

// Define a Node class to represent each element in the queue
class Node {
    int data;
    Node next;

    // Constructor to initialize a new node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define a Queue class to represent the queue implemented as a linked list 
class Queue {
    Node front;
    Node rear;

    // Constructor to initialize an empty queue
    public Queue() {
        front = null;
        rear = null;
    }
	
	// Enqueue operation: adds an item to the end of the queue, pseudocode found in PA 5.5.1
    public void enqueue(int item) {
        // Allocate new node and assign data
        // newNode.next is automatically set to null in the Node constructor
		Node newNode = new Node(item);
        
        if (front == null) {
            // If the queue is empty, set front to the new node
            front = newNode;
        } else {
            // Otherwise, link the new node at the end of the queue
            rear.next = newNode;
        }
        // Update the rear pointer to the new node
        rear = newNode;
    }
    
    // Dequeue operation: removes and returns the item from the front of the queue, pseudocode found in PA 5.5.1
    public int dequeue() {
		// If queue is empty return -1 (assuming only positive integers will be added) 
        if (front == null) {
			return -1;
        }
		System.out.println("Item " + front.data + " was removed from the queue."); //will print and display node removed
        // Save the data from the front node
        int dequeuedItem = front.data;
        // Move the front pointer to the next node
        front = front.next;
        // If the queue becomes empty, update the rear pointer to null
        if (front == null) {
		    System.out.println("An item was not dequeued."); //display no node because queue is empty;
            rear = null;
        }
		return dequeuedItem;
    }
    
    // Method to check if the queue is empty
    public boolean isEmpty() {
        // Implement method (front == null) {
		if (front == null) {
			System.out.println("The queue is empty."); // will print statement when front node empty
			return true; //returns true if empty
		} else
			System.out.println("The queue is not empty."); //print when not empty
			return false;   // returns false if queue is not empty 
    }
    
    // Method to peek at the front item without removing it
    public int peek() {
        // Implement method
		if (front == null ) { //if front is empty
			System.out.println("The queue is empty."); //not print nodes only statment
		return 0;   //returns 0 if front is equal to null 
		}else 
			System.out.println("The top item on the queue is: " + front.data); //will print front node
			return front.data; // will return item at top of queue if front is not 0
    }

    // Method to get the length of the queue
    public int getLength() {
		// Implement method
		int num = 0; //intialize length to 0
        Node curr = front; //begin from front of queue 
        while (curr != null) { //loop thorugh each node when not null
            num++; //increment count
            curr = curr.next; //next node 
			
        }
		System.out.println( "The queue's length is: "+ num);// will print length
        return num; //return length
		
		
    }	
	
    // Method to traverse and print the list, pseudocode found in PA 4.8.1
    public void displayQueue() {
		// Implement method
		Node curNode = front;
		
		while (curNode != null) { //print queue when not empty similar to example
			System.out.print(curNode.data + " -> ");
			curNode = curNode.next; //move to net node and be displayed
		}
		System.out.println("NULL"); //will print null when node empty
	}
	}

// Main class to demonstrate the queue operations
	public class QueueAsLinkedList {
		public static void main(String[] args) {
			Queue queue = new Queue();
			// Implement main method
			
		queue.displayQueue();  //display queue
		
		queue.isEmpty(); //will print statement if queue is empty 
		
		queue.peek();  // call peek and display folwing if empty or not empty
		
		queue.getLength(); //print length 
		
		queue.enqueue(1); //both will add 1 and 2 to queue 
		queue.enqueue(2);
		queue.peek(); //display node
		
		queue.enqueue(3);//add 3 to nodes
		queue.getLength();// print length
		
		queue.dequeue();//ca;; and display deque method
		queue.peek(); // display and print if node at front 
		 
		queue.enqueue(4); //add 4 to queue
		queue.displayQueue(); // show updated queue
		
		queue.enqueue(5); //add  5 to queue 
		queue.dequeue(); //remove queue 
		queue.enqueue(6); // add 
		
		queue.getLength(); //update and print length
		queue.displayQueue();// show queue based on example in PA 
		
		queue.dequeue(); //remove node 
		queue.isEmpty(); //will print and determine if queue is not or is empty
		
		queue.dequeue(); //remove node 
		queue.dequeue(); //romove node again
		queue.getLength(); //get updated length after removal of nodes
		
		queue.dequeue(); //remove node again
		queue.dequeue(); //remove node
		
		queue.isEmpty();// detemine whether or not queue is empty
		}
	}
	
	
