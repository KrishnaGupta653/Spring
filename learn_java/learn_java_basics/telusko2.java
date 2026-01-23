
class NewException extends Exception{
    public NewException(String str){
        super(str);
        System.out.println("\n"+str);
    }
}
public class telusko2 {
    public static void main(String[] args) throws Exception {
        System.out.println("\n--------Exception Handling-------\n");
            //Exception Handling
            // Exception handling in Java is a mechanism that allows developers to manage and respond to runtime errors gracefully, ensuring the program can continue executing or terminate safely.
            // It involves the use of try, catch, finally, throw, and throws keywords to handle exceptions effectively.
            try{
                int a10=10;
                int b10=0;
                // int c10=a10/b10; //ArithmeticException
                // System.out.println("Result: "+c10);

                // int nums[]= new int[5];
                // nums[7]=9; //ArrayIndexOutOfBoundsException

                // String str=null;
                // System.out.println(str.length()); //NullPointerException
                
                // if(b10==0){
                //     throw new ArithmeticException("Custom Exception: Denominator cannot be zero.");
                // }

                if(b10==0){
                    throw new NewException("##Custom Exception##");
                }
            }
            // catch(ArithmeticException e){
            //     System.out.println("\nException caught: Division by zero is not allowed."+e+"\n");
            // }
            // catch(ArrayIndexOutOfBoundsException e){
            //     System.out.println("\nException caught: Array index is out of bounds."+e+"\n");
            // }
            // catch(NullPointerException e){
            //     System.out.println("\nException caught: Null reference encountered."+e+"\n");
            // }
            catch (NewException e){
                System.out.println("\nException caught::: "+e+"::: "+e.getMessage()+"\n");
            }
            catch(Exception e){
                System.out.println("\nException caught: "+e+": "+e.getMessage()+"\n");
            }

            finally{    
                //finally block is optional AND it always executes
                System.out.println("\nExecution of try-catch block completed.\n");
            }   
    } 
}
