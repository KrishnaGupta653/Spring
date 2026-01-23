import java.util.*;
//map does not allow duplicate keys
//map does not maintain any order
//map allows one null key and multiple null values
//HashMap implements Map interface
//HashMap is not synchronized
//Map does not extend Collection interface

public class HashMapDemo {
        public static void display() {
            System.out.println("\n");
        }
    public static void main(String[] args) {
        HashMap<Integer, String> hm1=new HashMap<>();
        hm1.put(1, "Apple");
        hm1.put(12, "Banana");
        hm1.put(3, "Grapes");
        //null key is only one in HashMap but multiple null values are allowed
        // hm1.put(null, "Orange");
        //hm1.put(5, null);
        // hm1.put(null, "Pineapple"); //this will overwrite the previous null key value as key is unique in map



        //null keys and values are allowed in HashMap but not in Hashtable
        //also Hashtable is synchronized, HashMap is not
        

        System.out.println(hm1);
        System.out.println(hm1.get(3)); //get value for key 3
        System.out.println(hm1.keySet()); //get all keys
        System.out.println(hm1.values()); //get all values
        display();
        System.out.println(hm1.containsKey(12)); //true
        System.out.println(hm1.containsValue("Mango")); //false
        display();
        HashMap<String, Integer> hm2=new HashMap<>();
        hm2.put("One", 1);
        hm2.put("Two", 2);
        hm2.put("Three", 3);
        
        System.out.println(hm2);    
        System.out.println(hm2.get("Two")); //2
        System.out.println(hm2.keySet()); //get all keys
        System.out.println(hm2.values()); //get all values

        display();

        //1
        Set<Integer> keys1=hm1.keySet(); 
        System.out.println("Keys: " + keys1);

        for(int i:keys1){
            System.out.println("Key: "+i+" Value: "+hm1.get(i));
        }
        display();
        Set<String> keys2=hm2.keySet();
        System.out.println("Keys2: " + keys2);
        for(String key:keys2){
            System.out.println("Key: "+key+" Value: "+hm2.get(key));
        }

        //or
        //2
        Set<Map.Entry<Integer, String>> entries=hm1.entrySet();
        System.out.println("Entries: " + entries);
        System.out.println("Type of entries: " + entries.getClass().getName());
        display();
        System.out.println("Using Map.Entry to iterate through HashMap:");
        for (Map.Entry<Integer, String> entry: entries) { 
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue().toUpperCase());
        }
        display();

        hm1.remove(12); //removes key 12 and its value
        System.out.println("After removing key 12: "+hm1);

        boolean isRemoved = hm1.remove(3, "Banana"); //removes key 3 only if its value is "Banana"
        System.out.println(isRemoved); // false, as value for key 3 is "Grapes", not "Banana"

        display();
        //Time Complexity of HashMap
        //Map is amazingly fast in searching value by key
        //Time complexity of get() method in HashMap is O(1)
        //example 
        List<Integer> list1=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(list1);
        //to search an element in list time complexity is O(n)
        //but if we store these elements in HashMap as key and some value against it
        //then time complexity to search an element by key will be O(1)
        HashMap<Integer, String> map1=new HashMap<Integer, String>(){{
            put(1, "A");
            put(2, "B");
            put(3, "C");
            put(4, "D");
            put(5, "E");
        }};
        //now to search an element in map by key time complexity is O(1)
        System.out.println(map1);
        

        //Internal Structure of HashMap
        //HashMap internally uses an array of buckets to store key-value pairs
        //Each bucket is essentially a linked list (or a balanced tree in case of high collisions)
        //When a key-value pair is added to the HashMap, the hash code of the key is computed
        //This hash code determines the index of the bucket where the key-value pair will be stored
        //If two keys have the same hash code, they will be stored in the same bucket (collision)
        //In case of collision, the new key-value pair is added to the linked list (or tree) at that bucket
        //When retrieving a value by key, the hash code of the key is computed again to find the appropriate bucket
        //Then, the linked list (or tree) in that bucket is searched for the key to retrieve the corresponding value    
        




    }
    
}
