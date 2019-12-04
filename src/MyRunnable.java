class MyRunnable implements Runnable{
    String myName;

    public MyRunnable(String name) {
        myName = name;
    }

    public void run() {
        for (int i = 10; i >= 0; i--) {
            System.out.print(myName + i + " ");
        }
    }
}

