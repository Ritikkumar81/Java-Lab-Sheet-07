class Question14 {
    private static final Object Lock1 = new Object();
    private static final Object Lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (Lock1) {
                System.out.println("Thread-1 acquired Lock1");
                pause();
                synchronized (Lock2) {
                    System.out.println("Thread-1 acquired Lock2");
                }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            synchronized (Lock2) {
                System.out.println("Thread-2 acquired Lock2");
                pause();
                synchronized (Lock1) {
                    System.out.println("Thread-2 acquired Lock1");
                }
            }
        }, "Thread-2");

        // Daemon threads allow the demonstration JVM to exit after main finishes.
        // The two worker threads can remain deadlocked.
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("If both threads hold one lock, they can be deadlocked.");
    }

    private static void pause() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
