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
