public class ThreadTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable("A"));
        Thread t2 = new Thread(new MyRunnable("B"));
        t1.start();
        t2.start();
    }
}
