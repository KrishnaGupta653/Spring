public class Test_run {
    public static void main(String[] args) {
        System.out.println("This is a test run file.");
        World_run worldRunnable = new World_run();
        Thread t1=new Thread(worldRunnable);
        t1.start();
        for( ; ; ){
            System.out.println(Thread.currentThread().getName() + " Test_run Infinite Loop");
        }
        
    }
    
}
