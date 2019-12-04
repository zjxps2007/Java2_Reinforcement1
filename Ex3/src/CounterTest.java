public class CounterTest {
    public static void main(String[] args) {
        Counter c = new Counter();
        new MyThead(c).start();
        new MyThead(c).start();
        new MyThead(c).start();
        new MyThead(c).start();
    }
}
