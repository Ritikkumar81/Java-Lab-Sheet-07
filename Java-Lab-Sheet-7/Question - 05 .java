import java.util.Random;

class Question05 {
    public static void main(String[] args) {
        String[] names = {"Reader", "Writer", "Logger"};

        for (String name : names) {
            Thread t = new Thread(() -> {
                try {
                    int delay = new Random().nextInt(501);
                    Thread.sleep(delay);
                    System.out.println(Thread.currentThread().getName()
                            + " thread: Message printed after " + delay + " ms");
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted.");
                }
            }, name);
            t.start();
        }
    }
}
