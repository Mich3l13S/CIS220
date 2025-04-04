// Class to represent the key-value pair (Item)
class Item {
    String key;  
    String value;  
    Item next;  

    // Constructor to initialize the key-value pair and set the next pointer to null
    public Item(String key, String value) {
        this.key = key;  
        this.value = value;  
        this.next = null;  
    }
}

// Class to represent a hash table 
class HashTable {
    private Item[] hashTable;  
    private int length;  

    // Constructor to initialize the hash table with a specified size
    public HashTable (int size) {
        this.length = size;  
        this.hashTable = new Item[length];  
    }

    // Hash method to get the index for a given key
    public int hash(String key) {
        // Implement the method based on the PseudoCode provided in Figure 6.8.3, with 1 modification:
		// DO NOT mod(%) the stringHash by the number of buckets.
		int hashMultiplier = 13; //intialize multiplier to thirteen
		int InitialValue = 0;
		 int stringHash = InitialValue; //intialize stringhash to zero 
			for (int i = 0; i < key.length(); i++) { //loop process each value in string 
				char strChar = key.charAt(i);
				stringHash = (stringHash * hashMultiplier) + strChar;
			}
			return stringHash; //return stringhash without mod (removed mod)
			

		
    }

    // Method to Insert the specified key-value pair into the hash table, pseudocode found in Figure 6.3.1 with 
    public boolean hashInsert(String key, String value) {
        int bucketIndex = hash(key) % length;  

        Item currentItem = hashTable[bucketIndex];  
        Item previousItem = null;  

        while (currentItem != null) {  
            if (currentItem.key.equals(key)) {  
                currentItem.value = value;  
                return true;  
            }
            previousItem = currentItem;  
            currentItem = currentItem.next;
        }

        Item newItem = new Item(key, value);  
        if (hashTable[bucketIndex] == null) {  
            hashTable[bucketIndex] = newItem;  
        } else {
            previousItem.next = newItem;  
        }
        return true;  
    }

    // Method to search for the specified key and return the corresponding value, pseudocode found in Figure 6.3.1
    public String hashGet(String key) {
        int bucketIndex = hash(key) % length;  
        Item item = hashTable[bucketIndex];  

        while (item != null) {  
            if (item.key.equals(key)) {  
                return item.value;  
            }
            item = item.next;  
        }

        return null;  
    }

    // Method to remove the key-value pair from the hash table, pseudocode found in Figure 6.3.1
    public boolean hashRemove(String key) {
        int bucketIndex = hash(key) % length;  
        Item currentItem = hashTable[bucketIndex];  
        Item previousItem = null;  

        while (currentItem != null) {  
            if (currentItem.key.equals(key)) {  
                if (previousItem == null) {  
                    hashTable[bucketIndex] = currentItem.next;  
                } else {  
                    previousItem.next = currentItem.next;  
                }
                return true;  
            }
            previousItem = currentItem;  
            currentItem = currentItem.next;
        }

        return false;  
    }

    // Method to print the entire hash table, showing each bucket and its key-value pairs
	// Update the method to display the hash for each key-value pair
    public void printTable() { 
        for (int i = 0; i < length; i++) {  
            System.out.print("Bucket " + i + ": ");  
            Item currentItem = hashTable[i];
				
				//will print key-value pairs and its hash 
            if (currentItem == null) {  
                System.out.println("empty");  
            } else {
                while (currentItem != null) { 
                    System.out.print("[" + "Hash is: " + currentItem.hashCode()  +", " + "key is: " + currentItem.key +", " + "value is: " + currentItem.value + "] ");
                    currentItem = currentItem.next;  
                }
                System.out.println();    //will print all values of hash table untl there no longer any values found 
            }
        }
    }

    // Main method for testing the HashTable class
	// Implement the main method per the assignment instructions
    public static void main(String[] args) {
        HashTable table = new HashTable(5);  // Create a hash table with 5 buckets
		
		//insert values into hashtable 
		table.hashInsert( "keyA1", "value1");
		table.hashInsert( "keyB2", "value2");
		table.hashInsert( "keyC3", "value3");
		table.hashInsert( "keyD23", "value23");
		table.hashInsert( "keyE45", "value45");
		table.hashInsert( "keyF52", "value52");
		
		//will print hash table an its content
		System.out.println("HashTable contents:");
		table.printTable();
		System.out.println();
		
		 // willl remove key F52 using if then statement 
		boolean remove = table.hashRemove("keyF52");
		if (remove) {
            System.out.println( "keyF52 was removed");
			
        } else {
            System.out.println( " key F52 was not removed");
			
        }
		
		System.out.println();
		
		//will attempt to get a nonexisting key in hashtable 
		String exist =  table.hashGet("keyZ6");
		if (exist != null) {
			System.out.println("keyZ6 was found ");
		} else 
			System.out.println("keyZ6 was not found");
		
		
		System.out.println();
		
		String get = table.hashGet("keyC3");  //wil look for key C3 and get its value 
		if (get != null) {
            System.out.println(table.hashGet("keyC3"));
			
        } else {
            System.out.println("not found");
			
        }
		
		System.out.println();
		
		//insertt following key-value paiirs into hashtable 
		table.hashInsert("keyG18", "value18");
		table.hashInsert("keyH7", "value7");
		table.hashInsert("keyI33", "value33");
		
		System.out.println("HashTable contents after additional inserts, removal, and update:");
		table.printTable();
			
			
    }
}
