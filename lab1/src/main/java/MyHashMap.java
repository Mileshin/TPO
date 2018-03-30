import java.util.ArrayList;

/**
 * Created by Andrey on 23.03.2018.
 */


class HashNode<K, V>
{
    K key;
    V value;
    // Reference to next node
    HashNode<K, V> next;

      public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
      }

    public String toString() {
        return "("+key + ":" + value + "->" + next + ")";
    }
}

// Class to represent entire hash table
class MyHashMap<K, V>
{
    // bucketArray is used to store array of chains
    private ArrayList<HashNode<K, V>> bucketArray;

    private int numBuckets; // Current capacity of array list
    private int size;       // Current size of array list

    //// Log
    public boolean debug;
    public ArrayList<String> logList;
    public void resetLogList(){
        logList = new ArrayList<>();
    }
    private void logMe(String str){
        if(debug){
            if(logList != null) {
                logList.add(str);
            }
            System.out.println(str);
        }
    }
    ////

    // Constructor (Initializes capacity, size and
    // empty chains.
    public MyHashMap() {
        bucketArray = new ArrayList<>();
        numBuckets = 5;
        size = 0;

        // Create empty chains
        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(null);
        }
    }

    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }

    // This implements hash function to find index
    // for a key
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        if (index < 0) index = 0;
        return index;
    }

    // Method to remove a given key
    public V remove(K key) {
        // Apply hash function to find index for given key
        int bucketIndex = getBucketIndex(key);

        // Get head of chain
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // Search for key in its chain
        HashNode<K, V> prev = null;
        while (head != null) {
            // If Key found
            if (head.key.equals(key)) break;
            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key was not there
        if (head == null)
            return null;

        // Reduce size
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        return head.value;
    }

    // Returns value for a key
    public V get(K key)
    {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // Search key in chain
        while (head != null)
        {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }

        // If key not found
        return null;
    }

    // Adds a key value pair to hash
    public void add(K key, V value) {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        logMe("---Adding key value pair: " + key + ":" + value);
        logMe("Hash: " + key.hashCode() + ", bucket: " + bucketIndex);
        logMe("Bucket Array before: " + bucketArray);

        // Check if key is already present
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                logMe("Key " + key + " found!");
                logMe("Bucket Array after: " + bucketArray);
                return;
            }
            head = head.next;
        }
        logMe("Key " + key + " not found!");
        // Insert key in chain
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
        logMe("Bucket Array after: " + bucketArray);

        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0*size)/numBuckets >= 0.7) {
            logMe("Resizing HashTable");
            debug = false;
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);

            for (HashNode<K, V> headNode : temp)
            {
                while (headNode != null)
                {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
            debug = true;
            logMe("Bucket Array after resize: " + bucketArray);
        }
    }
}
