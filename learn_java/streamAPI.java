import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class streamAPI {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5,1,6,8,5,4,7,8);
        Stream<Integer> numStream = nums.stream();

        //we can use Stream only once because it is consumed after the terminal operation
        numStream.forEach(n -> System.out.println(n));
        
        //numStream.forEach(n -> System.out.println(n)); // This will throw an exception because the stream has already been operated upon and this is a terminal operation so it cannot be reused.
        numStream = nums.stream(); // Create the stream again
        long count= numStream.count();
        System.out.println("\nCount: " + count+"\n");

        //To reuse the stream, we need to create it again
        numStream = nums.stream();
        Stream<Integer> sortedStream = numStream.sorted();
        sortedStream.forEach(n -> System.out.println(n));


        numStream = nums.stream();
        System .out.println("\nDoubled Numbers using for loop:");
        for(int num: nums) {
            System.out.println(num*2);
        }   
        
        //map() function to apply a function to each element of the stream
        numStream = nums.stream();
        System.out.println("\nDoubled Numbers using Stream map():");
        Stream<Integer> doublStream= numStream.map(n -> n * 2);
        doublStream.forEach(n -> System.out.println(n));

        //short way to do the same 
        System.out.println("\nDoubled Numbers using Stream map() in short way:");
        numStream = nums.stream();
        numStream.filter(n->n%2==1).sorted().map(n->n*2).forEach(n->System.out.println(n));

        //Anonymous Class example
        Predicate<Integer> isOdd1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n % 2 == 1;
            }
        };
        System.out.println(isOdd1.test(5));  //true
        System.out.println(isOdd1.test(4));  //false    

        //since it is a functional interface we can use lambda expression
        Predicate<Integer> isOdd2 = n -> n % 2 == 1;
        System.out.println(isOdd2.test(5));  //true
        System.out.println(isOdd2.test(4));  //false
        //Same for map
        Function<Integer, Integer> doubleNum1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n * 2;
            }
        };
        System.out.println(doubleNum1.apply(5));  //10
        System.out.println(doubleNum1.apply(4));  //8

        //since it is a functional interface we can use lambda expression
        Function<Integer, Integer> doubleNum2 = n -> n * 2;  
        System.out.println(doubleNum2.apply(5));  //10
        System.out.println(doubleNum2.apply(4));  //8   


        int result= nums.stream()
            .filter(n->n%2==1)
            .map(n->n*2)
            .reduce(0,(a,b)->a+b);  //Terminal operation
        System.out.println("\nSum of doubled odd numbers: " + result);
    }
}
