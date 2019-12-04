public class Counter {
    private int value = 0;

    public void increment() {
        value ++;
    }
    public void decrement() {
        value --;
    }
    public void printCounter() {
        System.out.println(value);
    }
}
class MyThead extends Thread {
    Counter sharedCounter;

    public MyThead(Counter c) {
        this.sharedCounter = c;
    }

    public void run() {
        for (int i =0; i <10; i++) {
            sharedCounter.increment();
            sharedCounter.decrement();
            sharedCounter.printCounter();
            try {
                sleep(100);
            }
            catch (InterruptedException e){

            }
        }
    }
}
