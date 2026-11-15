class Question15 {
    private static final Object Lock1 = new Object();
    private static final Object Lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(Question15::useLocks, "Thread-1");
        Thread t2 = new Thread(Question15::useLocks, "Thread-2");

        t1.start();
        t2.start();
    }

    private static void useLocks() {
        synchronized (Lock1) {
            System.out.println(Thread.currentThread().getName() + " acquired Lock1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (Lock2) {
                System.out.println(Thread.currentThread().getName() + " acquired Lock2");
            }
        }
    }
}
