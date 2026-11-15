import java.util.concurrent.CyclicBarrier;

class Question10 {
    static class BankAccount {
        private int balance = 2000;
        private final CyclicBarrier barrier = new CyclicBarrier(2);

        // Intentionally not synchronized: both threads can read the same balance.
        void withdraw(int amount) {
            int currentBalance = balance;
            try {
                barrier.await(); // Makes the race visible for this demonstration.
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                return;
            }

            if (currentBalance >= amount) {
                balance = currentBalance - amount;
            }
        }

        int getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) account.withdraw(1);
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) account.withdraw(1);
        }, "Thread-2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Expected balance: 0");
        System.out.println("Actual balance: " + account.getBalance());
        System.out.println("The incorrect balance demonstrates a race condition.");
    }
}
