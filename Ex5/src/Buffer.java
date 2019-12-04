class Buffer {
    //생산자로부터 소비자로 전해지는 데이터
    private int data;

    //소비자가 기다리고 있으면 true
    //생산자 기다리고 있으면 false가
    private boolean empty = true;

    public synchronized int get() {
        //케이크가 생산될 떄까지 기다린다.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        //상태를 바꾼다.
        empty = true;
        //생산자를 깨운다.
        notifyAll();
        return data;
    }

    public synchronized void put(int data) {
        //케이크가 소비될 떄까지 기다린다.
        while (!empty) {
            try {
                wait();
            }catch (InterruptedException e) {

            }
        }
        empty = false;
        this.data = data;
        //소비자를 깨운다.
        notifyAll();
    }
}
class Producer implements Runnable{
    private Buffer buffer;

    public Producer(Buffer buffer) {
        //버퍼 참조 변수를 저장한다.
        this.buffer = buffer;
    }

    public void run() {
        for (int i =0; i < 10; i++) {
            buffer.put(i); //버퍼에 케이크를 넣는다.
            System.out.println("생성자: "+i+"번 케익을 생산하였습니다.");
            try {
                Thread.sleep((int) (Math.random() * 100));
            }catch (InterruptedException e) {
            }
        }
    }
}
class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer drop) {
        this.buffer = drop;
    }

    public void run() {
        for (int i =0; i <10; i++) {
            int data = buffer.get(); //버퍼에서 케이크를 가져온다.
            System.out.println("소비자: " +data+ "번 케익을 소비하였습니다.");
            try {
                Thread.sleep((int) (Math.random() * 100));
            }catch (InterruptedException e) {

            }
        }
    }
}
class ProducerConsumerTest {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        (new Thread(new Producer(buffer))).start();
        (new Thread(new Consumer(buffer))).start();
    }
}