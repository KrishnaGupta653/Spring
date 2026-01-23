public class Test {
    public static void main(String[] args) {
        System.out.println(args.length);
        System.out.println("Test class in multithreading package");
        World worldThread = new World();
        worldThread.start();
        for (; ;) {//
            System.out.println(Thread.currentThread().getName() + " Infinite Loop");
        }

        // for (; ;) {//
        //     System.out.println(Thread.currentThread().getName() + " Infinite Loop");
        // }
        //this loop is not reachable as above loop is infinite state

    }

}
