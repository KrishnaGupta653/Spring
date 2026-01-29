//order preserving collection
//allows duplicate values
//indexed access to elements
//ArrayList dynamically resizes not like arrays

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.lang.reflect.Field;
class Student{
    private String name;
    private double gpa;
    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }
    public String getName() {
        return name;
    }
    public double getGpa() {
        return gpa;
    }
}
//Custom comparators 
class IntegerLengthComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
        return i2 - i1; //descending order
        //if i1 - i2 : positive value means i1 > i2
        //if i1 == i2 : 0   
        //if i1 - i2 : negative value means i1 < i2
    }
}
class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s2.length() - s1.length(); //descending order by length
    }
}
public class list {
    public static void main(String[] args) throws Exception {
        List<Integer> arrayList = new ArrayList<>();
        //by default the ArrayList has initial capacity of 10
        //when more elements are added beyond capacity
        //the capacity is increased  by 1.5 times  
        //initial capacity can be specified during creation
        //List<Integer> arrayList = new ArrayList<>(20); //initial capacity 20
        

        //there is no keyword for capacity in ArrayList
        //JUGAAD to see current capacity using reflection
        // List<Integer> tempList = new ArrayList<>();
        // for(int i=0; i<15; i++) {
        //     tempList.add(1); //to avoid empty list exception
        // }
        // Field field=ArrayList.class.getDeclaredField("elementData");
        // field.setAccessible(true);
        // Object[] elementData = (Object[]) field.get(arrayList);
        // System.out.println("\nInitial capacity: " + elementData.length+"\n\n");
        
        //to run reflect: 
        // javac list1.java
        // java --add-opens java.base/java.util=ALL-UNNAMED list1



        //add, get, size, remove, contains, indexOf
        //add : adds element to end of list
        //get : indexed access to element
        //size : number of elements in list
        //remove : removes element at specified index
        //contains : checks if element is present in list
        //indexOf : returns index of first occurrence of element
        //trimToSize() : reduces capacity to current size
        //ensureCapacity(int minCapacity) : increases capacity to at least minCapacity
         
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(20); //duplicate value allowed
        System.out.println("ArrayList: " + arrayList);
        System.out.println("Element at index 2: " + arrayList.get(2)); //indexed access
        System.out.println("Size of ArrayList: " + arrayList.size());
        for(int i=0; i<arrayList.size(); i++) {
            System.out.println("Element at index " + i + ": " + arrayList.get(i));
        }
        for(int num : arrayList) {
            System.out.println("Element at index  "+arrayList.indexOf(num) + ": " + num);
        }

        System.out.println(arrayList.contains(5));
        System.out.println(arrayList.contains(50));
        System.out.println("Removing element at index 1: " + arrayList.remove(1));
        System.out.println("ArrayList after removal: " + arrayList);
        arrayList.add(1, 20) ;
        System.out.println("ArrayList after adding 20 at index 1: " + arrayList);
       
        List<String> stringList = new ArrayList<>();
        stringList.add("Date");
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Cherry");
        System.out.println("\nString ArrayList: " + stringList);
        System.out.println("Index of 'Banana': " + stringList.indexOf("Banana"));
        System.out.println("Index of 'Mango': " + stringList.indexOf("Mango"));

        // Object
        //  └── AbstractCollection
        //      └── AbstractList
        //          └── ArrayList

        //Important
        List<String> l1= new ArrayList<>();
        System.out.println("\nl1.getClass().getName():::: " + l1.getClass().getName());
        System.out.println("l1.getClass().getSuperclass().getName():::: " + l1.getClass().getSuperclass().getName());
        
        List<String> l2= Arrays.asList("Monday","Tuesday");
        System.out.println(l2.getClass().getName());
        //l2.add("Wednesday"); //UnsupportedOperationException
        //as Arrays.asList returns fixed size list
        //backed by the original array
        //and we can only modify elements at existing indices
        l2.set(1, "Wednesday");
        System.out.println("\n" + l2);
        System.out.println(l2.get(1)+"\n ");


        String[] arr= {"Jan","Feb","Mar"};
        List<String> l3= Arrays.asList(arr);
        System.out.println(l3.getClass().getName());

        List<Integer> l4 = List.of(1,2,3,4);

        //difference between Arrays.asList and List.of
        //1. List.of creates immutable list
        //2. List.of does not allow null elements
        //l4.add(5); //UnsupportedOperationException
        //l4.set(1, 10); //UnsupportedOperationException
        //List<Integer> l5 = List.of(1,2,null,4); //NullPointerException
        
        System.out.println("\n" + l4);

        //to make mutable list from asList or List.of
        List<Integer> l6 = new ArrayList<>(l4);
        l6.add(5);
        System.out.println("\n" + l6);

        List<Integer> l7=List.of(4,5,6,7,8,9);
        System.out.println("\nBefore ensureCapacity l7: " + l7);

        l6.addAll(l7); //adding all elements of l7 to l6
        System.out.println("\nAfter adding l7 to l6: " + l6);


        //also
        System.out.println("\n");
        List<Integer> tempList2 = new ArrayList<>();
        tempList2.add(1);
        tempList2.add(2);
        tempList2.add(3);
        System.out.println(tempList2);  
        tempList2.remove(2); //it will remove element at index 2
        tempList2.remove(Integer.valueOf(2)); //it will remove element with value 2
        System.out.println(tempList2);

        //whereas 
        List<String> tempList3 = new ArrayList<>();
        tempList3.add("A");
        tempList3.add("B");
        tempList3.add("C");
        System.out.println(tempList3);  
        tempList3.remove(2); //it will remove element at index 2
        tempList3.remove("B"); //it will remove element with value "B"
        System.out.println(tempList3); 
        
        //list to Array

        arrayList.toArray();
        Object[] array1 = arrayList.toArray(); //returns Object[]
        //or
        Integer[] array2 = arrayList.toArray(new Integer[0]); //returns Integer[]
        
        System.out.println("\nArray1: " + Arrays.toString(array1));
        System.out.println("Array2: " + Arrays.toString(array2));

        //sort
        System.out.println("\n----------------- Sorting ArrayList ------------------");
        //ascending order
        arrayList.sort(null); //ascending order
        System.out.println("\nSorted ArrayList using list.sort(): " + arrayList);

        Collections.sort(arrayList); //ascending order
        System.out.println("\nSorted ArrayList: " + arrayList);



        //descending order
        arrayList.sort(new IntegerLengthComparator());
        System.out.println("\nSorted ArrayList in descending order using custom comparator: " + arrayList); 

        Collections.sort(arrayList, Collections.reverseOrder());
        System.out.println("\nSorted ArrayList in descending order: " + arrayList);
        //or using custom comparator with method reference
        Collections.sort(arrayList, new IntegerLengthComparator());
        System.out.println("\n Sorted ArrayList in descending order using method reference: " + arrayList);

        Collections.sort(stringList); //lexicographical order
        System.out.println("\nString ArrayList sorted lexicographically: " + stringList);
        
        Collections.sort(stringList, Collections.reverseOrder());
        System.out.println("\nString ArrayList sorted in reverse lexicographical order: " + stringList);

        Collections.sort(stringList, new StringLengthComparator());
        System.out.println("\nString ArrayList sorted by descending length using Collections.sort and custom comparator: " + stringList);

        //custom comparator
        stringList.sort(new StringLengthComparator());
        System.out.println("\nString ArrayList sorted by descending length: " + stringList);

         
        //lambda for custom sorting
        List<String> words= new ArrayList<>();
        words.add("elephant");
        words.add("dog");
        words.add("cat");
        words.add("hippopotamus");
        words.add("ant");

        words.sort((s1, s2) -> s1.length() - s2.length()); //ascending order by length
        System.out.println("\nString ArrayList sorted by ascending length using lambda: " + words);
        words.sort((s1, s2) -> s2.length() - s1.length()); //descending order by length
        System.out.println("\nString ArrayList sorted by descending length using lambda: " + words);



        System.out.println("\n");

        List<Student> studentList= new ArrayList<>();
        studentList.add(new Student("Alice", 3.5));
        studentList.add(new Student("Bob", 3.8));
        studentList.add(new Student("Charlie", 3.2));   
        studentList.add(new Student("Akshit", 3.9));
        studentList.add(new Student("Alica", 3.5));

        for(Student s : studentList) {
            System.out.println(s.getName() + " : " + s.getGpa());
        }

        //studentList.sort(null); //ERROR: Student does not implement Comparable - exception at runtime 
        //the error arises because sort(null) tries to cast Student to Comparable but Student does not implement Comparable interface as String, Integer etc do they are built-in comparables but Student is a custom class not implementing Comparable

        studentList.sort((a,b)->{
            if(b.getGpa() - a.getGpa()>0){
                return 1;
            } 
            else if(b.getGpa() - a.getGpa() < 0){
                return -1;
            } 
            else {
                //return 0;//equal
                //or
                return a.getName().compareTo(b.getName()); //if gpa equal then sort by name
            } 
        });
        for(Student s : studentList) {
            System.out.println(s.getName() + " : " + s.getGpa());
        }

        //JAVA 8+ -->using Method References and Comparator helper methods
        System.out.println("\nAscending order:");
        Comparator<Student> comparator1=Comparator.comparingDouble(Student::getGpa);
        studentList.sort(comparator1);
        for (Student s : studentList) {
            System.out.println(s.getName() + " : " + s.getGpa());
        }
        System.out.println("\nDescending order:");
        Comparator<Student> comparator2=Comparator.comparingDouble(Student::getGpa);
        studentList.sort(comparator2.reversed());
        for (Student s : studentList) {
            System.out.println(s.getName() + " : " + s.getGpa());
        }


        List<String> shoppingList= new ArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");  
        System.out.println("\nShopping List: " + shoppingList);

        // ArrayList does not allow structural modification during iteration because its iterator is fail-fast.
        //❌ we cannnot update a arraylist while we are litterating through it
        // ✅ We cannot modify an ArrayList while iterating through it.

        List<String> backupList= new CopyOnWriteArrayList<>(shoppingList); //creating a copy
        for(String item : backupList) {
            System.out.println("Buying: " + item);
            if(item.equals("Eggs")){
                backupList.add("Butter"); //modifying list during iteration
            }
        }
        System.out.println("\nUpdated (backup) Shopping List using CopyOnWriteArrayList: " + backupList);


        //2. or use Iterator
        // Iterator allows safe removal of elements during iteration without causing ConcurrentModificationException.
        Iterator<String> iterator =shoppingList.iterator();
        while(iterator.hasNext()) {
            String item=iterator.next();
            System.out.println("Buying: " + item);
            if(item.equals("Eggs")){
                iterator.remove(); //safe removal during iteration  
            }
        }
        System.out.println("\nUpdated Shopping List using Iterator: " + shoppingList);
    }
}
