import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * A Map from keys to values that, implemented with a hash table, using chaining to resolve collisions.
 * The user may set the starting size of the hash table, which never changes.
 */
public class HashtableMap<K, V> {

    // The hash table, an ArrayList of LinkedLists of KVPair objects.
    private final ArrayList<LinkedList<KVPair>> table;



    /**
     * Create a new hash table of the given capacity.
     */
    public HashtableMap(int capacity) {
        // Initialize table to have a pre-defined capacity.
        table = new ArrayList<LinkedList<KVPair>>(capacity);


        // Go through table and add an empty linked list to each slot.
        for (int x = 0; x < capacity; x++) {
            table.add(new LinkedList<KVPair>());
        }
    }

    /**
     * Add a new key-value pair into the hash table.
     * If there is already an entry in the table for this key, then overwrite it with the new value.
     */
    public void put(K newKey, V newValue) {
        // This is the index you should use to insert the key-value pair.
        int hashIndex = Math.abs(newKey.hashCode() % table.size());
        LinkedList<KVPair> pairChain = table.get(hashIndex);
        boolean sameKey = false;

        for ( KVPair pair : pairChain)
        {
            if ( pair.key.equals(newKey) ) //changes the value  if its the same key
            {
                pair.value = newValue;
                sameKey = true;
                break;
            }

        }

        if(!sameKey) {
            KVPair newPair = new KVPair(); // if there is a new key, set the values
            newPair.value = newValue;
            newPair.key = newKey;
            pairChain.add(newPair);
        }

    }

    /**
     * Get a value from this hash table, based on its key. If the key doesn't already exist in the table,
     * this method returns null.
     */
    public V get(K searchKey) {

        int hashIndex = Math.abs(searchKey.hashCode() % table.size());

        LinkedList<KVPair> newPair = table.get(hashIndex);

        for ( KVPair pair : newPair) // traverse through and check if the pair.key is the search key, returns value or null(if not found)
        {
            if (pair.key.equals(searchKey))
            {

                return pair.value;
            }

        }

        return null;
    }

    /**
     * Test if this key exists in the hash table, and return true if it does, and false if it doesn't.
     */
    public boolean containsKey(K searchKey) {

        int hashIndex = Math.abs(searchKey.hashCode() % table.size());

        LinkedList<KVPair> newPair = table.get(hashIndex);

        for ( KVPair pair : newPair)
        {

            if (pair.key.equals(searchKey))  //if key is in the hashmap, return true, else return false
            {

                return true;
            }


        }

        return false;

    }

    /**
     * Print the hash table. If the table has more than 100 slots, only print the top 100 (indices 0-99).
     * Print the contents of each index in the table on a single line. Include the index number, the
     * number of entries at that index (hint--use .size() on the linked list), and each individual entry
     * in the format "{key=someKey, value=someValue}".
     *
     * Hint: If you override toString() in the KVPair class below, then you can print the linked lists
     * without iterating through them manually.
     *
     * Example:
     * Index 0 (2): [{key=key1, value=value1}, {key=key2, value=value2}]
     * Index 1 (3): [{key=key3, value=value3}, ...]
     */
    public void printTable() {

        if (table.size() > 100) //if size is more than 0, print top 100
        {

            for (int i = 0; i < 100; i++) {
                LinkedList<KVPair> newPair = table.get(i);
                System.out.println("Index " + i + " (" + newPair.size() + "):[");
                for (KVPair pair : newPair) {
                    if (pair.equals(newPair.getLast())) {
                        System.out.print(pair.toString());

                    } else {
                        System.out.print(pair.toString() + ", ");
                    }

                }

                System.out.print("]");
                System.out.println();

            }

        } else {
            for (int i = 0; i < table.size(); i++) {
                LinkedList<KVPair> newPair = table.get(i);
                System.out.print("Index " + i + " (" + newPair.size() + "): [");
                for (KVPair pair : newPair) {
                    if (pair.equals(newPair.getLast())) {
                        System.out.print(pair.toString());
                    } else {
                        System.out.print(pair.toString() + ", ");
                    }
                }
                System.out.print("]");
                System.out.println();
            }


        }
    }

    /**
     * Return the total number of key-value pairs stored in the hash table.
     * Note, this is not the same thing as the number of slots in the table.
     */
    public int size() {
        int tableSize = 0;

        for (LinkedList<KVPair> newPair: table)
        {
            tableSize +=newPair.size();

        }


        return tableSize;
    }

    /**
     * Turn the hash table into a Set of all the keys in the table (values are ignored).
     * Do this by creating an empty HashSet<K> (built-in Java class),
     * looping through the hash table, looping over each linked list in each slot of the table,
     * and adding each key into the hash set.
     */
    public Set<K> keySet() {

        HashSet<K> newSet = new HashSet<>();

        for (LinkedList<KVPair>newList : table) {
            for (KVPair newPair : newList) {
                newSet.add(newPair.key);//puts the keys into the set
            }
        }
        return newSet;

    }

    /**
     * It is very common to have private classes nested inside other classes. This is most commonly used when
     * the nested class has no meaning apart from being a helper class or utility class for the outside class.
     * In this case, this KVPair class has no meaning outside of this Hashtable class, so we nest it inside here
     * so as to not prevent another class from declaring a KVPair class as well.
     */
    private class KVPair {
        public K key = null;
        public V value = null;


        // Add a constructor here if you'd like.
        // If no constructor is defined, you get the default constructor, `new KVPair()`.

        // Add a toString() method here if you'd like.
        // If no toString() method is defined, you get the default implementation, which shows a memory location.

        public String toString() {
            String string ="";
            string = string + "{key=" + key + ", value=" + value + "}";
            return string;
        }
    }
}
