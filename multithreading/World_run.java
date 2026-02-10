public class World_run implements Runnable {
    @Override
    public void run() {
        for( ; ;){
            System.out.println(Thread.currentThread().getName() + " World Runnable");
        }
        
    }
    
}
